package repository.impl;

import entity.Event;
import org.hibernate.Session;
import repository.EventRepository;

import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    public EventRepositoryImpl() {
    }

    @Override
    public Event getById(Long aLong) {
        return HibernateUtil.getSessionFactory().openSession().get(Event.class, aLong);
    }

    @Override
    public List<Event> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Event> events = session.createQuery("FROM Event ").list();
        session.getTransaction().commit();
        session.close();
        return events;
    }

    @Override
    public Event update(Event event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Event event1 = session.get(Event.class, event.getId());
        event1.setDateEvent(event.getDateEvent());
        event1.setFileInfo(event.getFileInfo());
        session.update(event1);
        session.getTransaction().commit();
        session.close();
        return event1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Event event = session.get(Event.class, aLong);
        session.delete(event);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public Event save(Event event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(event);
        session.getTransaction().commit();
        session.close();
        return event;
    }
}
