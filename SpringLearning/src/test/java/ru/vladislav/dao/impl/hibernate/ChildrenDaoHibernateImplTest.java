package ru.vladislav.dao.impl.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.dao.impl.config.TestDaoHibernateConfig;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoHibernateConfig.class)
public class ChildrenDaoHibernateImplTest {

    @Autowired
    ChildrenDao childrenDao;

    @Test
    public void findByUserId() throws Exception {
        List<Child> children = childrenDao.findByUserId(2L);
        Child expected = new Child.Builder().setId(2L).setSurname("D").setName("E").setPatronymic("F").build();

        System.out.println(children.get(0).getSurname());
        assertEquals(expected.getSurname(), children.get(0).getSurname());
    }

}