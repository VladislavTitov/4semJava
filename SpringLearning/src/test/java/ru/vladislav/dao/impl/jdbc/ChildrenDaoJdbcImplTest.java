package ru.vladislav.dao.impl.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.dao.impl.config.TestDaoJdbcConfig;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoJdbcConfig.class)
public class ChildrenDaoJdbcImplTest {


    @Autowired
    ChildrenDao childrenDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByUserId() throws Exception {
        List<Child> children = childrenDao.findByUserId(2L);
        Child expected = new Child.Builder().setId(2L).setSurname("D").setName("E").setPatronymic("F").build();
        User user = new User.Builder()
                .setId(2L)
                .setUserName("Vlad")
                .setDateRegistration(new Date(2017, 1, 17))
                .setChildren(children)
                .build();

        assertEquals(expected.getSurname(), children.get(0).getSurname());
    }

}