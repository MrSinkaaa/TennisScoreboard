package ru.mrsinkaaa.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mrsinkaaa.entity.Match;
import ru.mrsinkaaa.service.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class MatchRepository implements CrudRepository<Integer, Match>{

    private static final MatchRepository INSTANCE = new MatchRepository();

    private MatchRepository() {}

    @Override
    public Optional<Match> findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Match.class, id));
        }
    }

    @Override
    public List<Match> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Match", Match.class).getResultList();
        }
    }

    @Override
    public void update(Match entity) {
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
    }

    @Override
    public Match save(Match entity) {
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
        return entity;
    }

    @Override
    public boolean delete(Match entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();

            return true;
        } catch (RuntimeException e) {
            if (tx!= null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error deleting player: " + e.getMessage());
        }
        return false;
    }

    public static MatchRepository getInstance() {
        return INSTANCE;
    }
}
