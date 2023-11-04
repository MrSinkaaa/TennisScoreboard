package ru.mrsinkaaa.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mrsinkaaa.entity.Match;
import ru.mrsinkaaa.service.HibernateUtil;

import java.util.List;

public class MatchRepository implements CrudRepository<Match>{

    @Override
    public Match findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Match.class, id);
        }
    }

    @Override
    public List<Match> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Match", Match.class).getResultList();
        }
    }

    @Override
    public Match update(Match entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();

        } catch (RuntimeException e) {
            if (tx!= null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error updating player: " + e.getMessage());
        }
        return entity;
    }

    @Override
    public void save(Match entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();

        } catch (RuntimeException e) {
            if (tx!= null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error saving player: " + e.getMessage());
        }
    }

    @Override
    public void delete(Match entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();

        } catch (RuntimeException e) {
            if (tx!= null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error deleting player: " + e.getMessage());
        }
    }
}
