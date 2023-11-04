package ru.mrsinkaaa.repository;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import ru.mrsinkaaa.entity.Player;
import org.hibernate.Session;
import ru.mrsinkaaa.service.HibernateUtil;

import java.util.List;

public class PlayerRepository implements CrudRepository<Player> {


    @Override
    public Player findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Player.class, id);
        }
    }

    public Player findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Player where name = :name", Player.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
    }

    @Override
    public List<Player> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Player", Player.class).getResultList();
        }
    }

    @Override
    public Player update(Player entity) {
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
        return entity;
    }

    @Override
    public void save(Player entity) {
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
    }

    @Override
    public void delete(Player entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();

        } catch (RuntimeException e) {
            if(tx!= null && tx.isActive()) {
                tx.rollback();
            }
            System.err.println("Error deleting player: " + e.getMessage());
        }
    }
}
