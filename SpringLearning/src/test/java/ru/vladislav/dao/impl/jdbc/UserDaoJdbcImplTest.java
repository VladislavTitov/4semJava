package ru.vladislav.dao.impl.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vladislav.dao.UserDao;
import ru.vladislav.dao.impl.config.TestDaoJdbcConfig;
import ru.vladislav.entities.User;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoJdbcConfig.class)
public class UserDaoJdbcImplTest {

    @Autowired
    UserDao userDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
        User user = userDao.findAll().get(0);
        System.out.println(user.getUserName());
    }

}