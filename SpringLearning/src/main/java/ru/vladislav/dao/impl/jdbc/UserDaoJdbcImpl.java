package ru.vladislav.dao.impl.jdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import ru.vladislav.dao.UserDao;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoJdbcImpl implements UserDao {

    private JdbcTemplate template;

    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO users VALUES (DEFAULT, ?, ?, ?, DEFAULT)";

    //language=SQL
    private final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";

    //language=SQL
    private final String SQL_UPDATE_USER = "UPDATE users SET user_name = ?, password = ? WHERE user_id = ?";

    //language=SQL
    private final String SQL_DELETE_USER = "DELETE FROM users WHERE user_id = ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM users";

    //language=SQL
    private final String SQL_SELECT_BY_DATE_REGISTRATION = "SELECT * FROM users WHERE date_registration = ?";

    //language=SQL
    private final String SQL_SELECT_DELETED = "SELECT * FROM users WHERE deleted = TRUE";

    //language=SQL
    private final String SQL_SELECT_BY_NAME = "SELECT * FROM users WHERE user_name = ?";

    //language=SQL
    private final String SQL_SELECT_ALL_CHILDREN = "SELECT * FROM children";

    private final Map<Long, User> userMap;

    RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {

            User user = new User.Builder()
                    .setId(resultSet.getLong("user_id"))
                    .setUserName(resultSet.getString("user_name"))
                    .setDateRegistration(resultSet.getDate("date_registration"))
                    .setDeleted(resultSet.getBoolean("deleted"))
                    .setChildren(new ArrayList<Child>())
                    .build();

            userMap.put(user.getId(), user);

            return user;
        }
    };

    RowMapper<Child> childrenRowMapper = new RowMapper<Child>() {
        public Child mapRow(ResultSet resultSet, int i) throws SQLException {
            Child child = new Child.Builder()
                    .setId(resultSet.getLong("child_id"))
                    .setSurname(resultSet.getString("child_surname"))
                    .setName(resultSet.getString("child_name"))
                    .setPatronymic(resultSet.getString("child_patronymic"))
                    .setUser(userMap.get(resultSet.getLong("user_id")))
                    .build();

            userMap.get(child.getUser().getId()).getChildren().add(child);


            return child;
        }
    };

    @Autowired
    public UserDaoJdbcImpl(DataSource source) {
        template = new JdbcTemplate(source);
        userMap = new HashMap<Long, User>();
    }

    public Long save(final User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, model.getUserName());
                statement.setString(2, model.getPassword());
                statement.setDate(3, model.getDateRegistration());
                return statement;
            }
        }, keyHolder);
        return ((Integer) keyHolder.getKeys().get("user_id")).longValue();
    }

    public User find(Long id) {
        try {
            return template.queryForObject(SQL_SELECT_USER_BY_ID, new Object[]{id}, userRowMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public void update(User model) {
        template.update(SQL_UPDATE_USER, model.getUserName(), model.getPassword(), model.getId());
    }

    public void delete(Long id) {
        template.update(SQL_DELETE_USER, id);
    }

    public List<User> findAll() {
        try {
            template.query(SQL_SELECT_ALL, userRowMapper);
            template.query(SQL_SELECT_ALL_CHILDREN, childrenRowMapper);
            return new ArrayList<User>(userMap.values());
        }catch (EmptyResultDataAccessException e){
            return null;
        }finally {
            userMap.clear();
        }
    }

    public List<User> findByDateRegistration(Date date) {
        try {
            return template.query(SQL_SELECT_BY_DATE_REGISTRATION, new Object[]{date}, userRowMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public List<User> findDeleted() {
        try {
            return template.query(SQL_SELECT_DELETED, userRowMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public User findByName(String name) {
        try {
            return template.queryForObject(SQL_SELECT_BY_NAME, new Object[]{name}, userRowMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

}
