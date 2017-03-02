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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoHibernateConfig.class)
public class ChildrenDaoHibernateImplTest {

    @Autowired
    private ChildrenDao childrenDao;

    @Test
    public void save() throws Exception {
        Child insertingChild = new Child.Builder()
                .setId(1L)
                .setSurname("AA")
                .setName("BB")
                .setPatronymic("CC")
                .setUser(new User.Builder().setId(1L).build())
                .build();
        Long actual = childrenDao.save(insertingChild);
        Long expected = 10L;
        assertEquals(expected, actual);
    }

    @Test
    public void find() throws Exception {
        Child actual = childrenDao.find(1L);
        Child expected = new Child.Builder()
                .setId(1L)
                .setSurname("A")
                .setName("B")
                .setPatronymic("C")
                .setUser(new User.Builder().setId(1L).build())
                .build();
        assertEquals(expected, actual);
    }

    @Test
    public void findNobody() throws Exception {
        Child child = childrenDao.find(130L);
        assertNull(child);
    }

    @Test
    public void update() throws Exception {
        Long id = 1L;
        Child expected = new Child.Builder()
                .setId(id)
                .setSurname("A")
                .setName("ASDSFSF")
                .setPatronymic("C")
                .setUser(new User.Builder().setId(1L).build())
                .build();
        childrenDao.update(expected);
        Child actual = childrenDao.find(id);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() throws Exception {
        Long id = 2L;
        if (childrenDao.find(id) == null){
            fail("Child with id = " + id + " isn't exist!");
        }
        childrenDao.delete(id);
        Child actual = childrenDao.find(id);
        assertNull(actual);
    }

    @Test
    public void findAll() throws Exception {
        List<Child> actual = childrenDao.findAll();
        ArrayList<Child> expected = new ArrayList<Child>();
        expected.add(new Child.Builder()
                .setId(1L)
                .setSurname("A")
                .setName("B")
                .setPatronymic("C")
                .setUser(new User.Builder().setId(1L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(2L)
                .setSurname("D")
                .setName("E")
                .setPatronymic("F")
                .setUser(new User.Builder().setId(2L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(3L)
                .setSurname("G")
                .setName("H")
                .setPatronymic("I")
                .setUser(new User.Builder().setId(3L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(4L)
                .setSurname("J")
                .setName("K")
                .setPatronymic("L")
                .setUser(new User.Builder().setId(3L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(5L)
                .setSurname("M")
                .setName("N")
                .setPatronymic("O")
                .setUser(new User.Builder().setId(1L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(6L)
                .setSurname("P")
                .setName("R")
                .setPatronymic("S")
                .setUser(new User.Builder().setId(4L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(7L)
                .setSurname("T")
                .setName("U")
                .setPatronymic("V")
                .setUser(new User.Builder().setId(1L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(8L)
                .setSurname("X")
                .setName("Y")
                .setPatronymic("Z")
                .setUser(new User.Builder().setId(2L).build())
                .build());
        expected.add(new Child.Builder()
                .setId(9L)
                .setSurname("Q")
                .setName("W")
                .setPatronymic("QW")
                .setUser(new User.Builder().setId(4L).build())
                .build());

        assertEquals(expected, actual);

    }

    @Test
    public void findByUserId() throws Exception {
        List<Child> actual = childrenDao.findByUserId(2L);
        Child child1 = new Child.Builder()
                .setId(2L)
                .setSurname("D")
                .setName("E")
                .setPatronymic("F")
                .setUser(new User.Builder().setId(2L).build())
                .build();
        Child child2 = new Child.Builder()
                .setId(8L)
                .setSurname("X")
                .setName("Y")
                .setPatronymic("Z")
                .setUser(new User.Builder().setId(2L).build())
                .build();
        ArrayList<Child> expected = new ArrayList<Child>();
        expected.add(child1);
        expected.add(child2);
        assertEquals(expected, actual);
    }

    @Test
    public void findByMissingUserId() throws Exception {
        List<Child> actual = childrenDao.findByUserId(130L);
        List<Child> expected = new ArrayList<Child>();
        assertEquals(expected, actual);
    }

}