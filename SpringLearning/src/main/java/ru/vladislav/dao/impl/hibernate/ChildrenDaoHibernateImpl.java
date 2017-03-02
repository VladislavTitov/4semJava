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
import javax.persistence.NoResultException;
import java.util.List;

@Component("dao.hibernate.children")
public class ChildrenDaoHibernateImpl implements ChildrenDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Long save(Child model) {
        model.setId(null);
        Session session = getSession();
        session.beginTransaction();
        session.save(model);
        Long id = model.getId();
        session.getTransaction().commit();
        return id;
    }

    public Child find(Long id) {
        try{
            Child child = new Child.Builder().setId(id).build();
            Session session = getSession();
            session.beginTransaction();
            Child foundedChild = session.createQuery("from Child where id = :id", Child.class)
                    .setProperties(child)
                    .getSingleResult();
            session.getTransaction().commit();
            return foundedChild;
        }catch (NoResultException e){
            return null;
        }
    }

    public void update(Child model) {
        if (model.getId() == null){
            throw new IllegalArgumentException("Updating child hasn't id!");
        }
        Session session = getSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
    }

    public void delete(Long id) {
        try {
            Session session = getSession();
            session.beginTransaction();
            Child child = session.createQuery("from Child where child_id = :childId", Child.class)
                    .setParameter("childId", id)
                    .getSingleResult();
            session.delete(child);
            session.getTransaction().commit();
        }catch (NoResultException e){
            e.printStackTrace();
        }
    }

    public List<Child> findAll() {
        Session currentSession = getSession();
        currentSession.beginTransaction();
        List<Child> allChildren = currentSession.createQuery("from Child", Child.class).list();
        currentSession.getTransaction().commit();
        return allChildren;
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
