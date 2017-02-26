package ru.vladislav.dao.impl.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Component("dao.hibernate.children")
public class ChildrenDaoHibernateImpl implements ChildrenDao {

    @Autowired
    private SessionFactory sessionFactory;

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
        User user = new User();
        user.setId(userId);
        Child child = new Child();
        child.setUser(user);
        Session session = getSession();
        session.beginTransaction();
        List<Child> children = session.createQuery("from Child ch where ch.user = :user", Child.class)
                .setProperties(child)
                .list();
        session.getTransaction().commit();
        return children;
    }

    private Session getSession(){

        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        return session;
    }

}
