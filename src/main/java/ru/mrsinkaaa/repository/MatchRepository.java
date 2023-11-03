package ru.mrsinkaaa.repository;

import org.hibernate.Session;
import ru.mrsinkaaa.entity.Match;
import ru.mrsinkaaa.service.HibernateUtil;

import java.util.List;

public class MatchRepository implements CrudRepository<Match>{
    @Override
    public Match findById(int id) {
        Match match = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            match = session.get(Match.class, id);

            session.getTransaction().commit();
        }
        return match;
    }

    @Override
    public List<Match> findAll() {
        List<Match> matches = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            matches = session.createQuery("from Match", Match.class).getResultList();

            session.getTransaction().commit();
        }
        return matches;
    }

    @Override
    public Match update(Match entity) {
        Match match = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            match = session.merge(entity);

            session.getTransaction().commit();
        }
        return match;
    }

    @Override
    public void save(Match entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(entity);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Match entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.remove(entity);

            session.getTransaction().commit();
        }
    }
}
