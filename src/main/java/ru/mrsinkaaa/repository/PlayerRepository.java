package ru.mrsinkaaa.repository;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import ru.mrsinkaaa.entity.Player;
import org.hibernate.Session;
import ru.mrsinkaaa.service.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class PlayerRepository implements CrudRepository<Integer, Player> {

    private static final PlayerRepository INSTANCE = new PlayerRepository();

    private PlayerRepository() {

    }

    @Override
    public Optional<Player> findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Player.class, id));
        }
    }

    public Optional<Player> findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.createQuery("from Player where name = :name", Player.class)
                    .setParameter("name", name)
                    .getSingleResult());
        }
    }

    @Override
    public List<Player> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Player", Player.class).getResultList();
        }
    }

    @Override
    public void update(Player entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();

        } catch (RuntimeException e) {
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error updating player: " + e.getMessage());
        }

    }

    @Override
    public Player save(Player entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error saving player: " + e.getMessage());
        }
        return entity;
    }

    @Override
    public boolean delete(Player entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();

            return true;
        } catch (RuntimeException e) {
            if(tx!= null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error deleting player: " + e.getMessage());
        }
        return false;
    }

    public static PlayerRepository getInstance() {
        return INSTANCE;
    }
}
