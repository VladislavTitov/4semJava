package ru.vladislav.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component("dao.jdbc.children")
public class ChildrenDaoJdbcImpl implements ChildrenDao {

    private NamedParameterJdbcTemplate template;

    private User currentUser;

    //language=SQL
    private final String SQL_SELECT_CHILDREN_BY_USER_ID = "SELECT * FROM (SELECT * FROM users WHERE users.user_id = :userId) u INNER JOIN children ON u.user_id = children.user_id";

    RowMapper<Child> childrenRowMapper = new RowMapper<Child>() {
        public Child mapRow(ResultSet resultSet, int i) throws SQLException {

            if (currentUser == null){
                currentUser = new User.Builder()
                        .setId(resultSet.getLong("user_id"))
                        .setUserName(resultSet.getString("user_name"))
                        .setDateRegistration(resultSet.getDate("date_registration"))
                        .setDeleted(resultSet.getBoolean("deleted"))
                        .setChildren(new ArrayList<Child>())
                        .build();
            }

            Child child = new Child.Builder()
                    .setId(resultSet.getLong("child_id"))
                    .setSurname(resultSet.getString("child_surname"))
                    .setName(resultSet.getString("child_name"))
                    .setPatronymic(resultSet.getString("child_patronymic"))
                    .setUser(currentUser)
                    .build();

            currentUser.getChildren().add(child);
            return child;

        }
    };

    @Autowired
    public ChildrenDaoJdbcImpl(DataSource source) {
        template = new NamedParameterJdbcTemplate(source);
        currentUser = null;
    }

    public Long save(Child model) {
        return null;
    }

    public Child find(Long id) {
        return null;
    }

    public void update(Child model) {

    }

    public void delete(Long id) {

    }

    public List<Child> findAll() {
        return null;
    }

    public List<Child> findByUserId(Long userId) {
        try{
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", userId);
            List<Child> children = template.query(SQL_SELECT_CHILDREN_BY_USER_ID, paramMap, childrenRowMapper);
            return children;
        }catch (EmptyResultDataAccessException e){
            return new ArrayList<Child>();
        }finally {
            currentUser = null;
        }
    }
}
