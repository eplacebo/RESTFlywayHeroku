package repository.impl;


import entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements repository.UserRepository {


    @Override
    public User getById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = session.get(User.class, aLong);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> users = session.createQuery("FROM User ").list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user1 = session.get(User.class, user.getId());
        user1.setUsername(user.getUsername());
        user1.setEventList(user.getEventList());
        session.saveOrUpdate(user1);
        session.getTransaction().commit();
        session.close();
        return user1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = session.get(User.class, aLong);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public User save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User getByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User where username=:username");
        query.setParameter("username",username);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
