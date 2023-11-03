package ru.mrsinkaaa.repository;

import ru.mrsinkaaa.entity.Player;
import org.hibernate.Session;
import ru.mrsinkaaa.service.HibernateUtil;

import java.util.List;

public class PlayerRepository implements CrudRepository<Player> {


    @Override
    public Player findById(int id) {
        Player player = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            player = session.get(Player.class, id);

            session.getTransaction().commit();
        }

        return player;
    }

    public Player findByName(String name) {
        Player player = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            player = session.createQuery("from Player where name = :name", Player.class)
                  .setParameter("name", name)
                  .getSingleResult();

            session.getTransaction().commit();
        }

        return player;
    }

    @Override
    public List<Player> findAll() {
        List<Player> players = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            players = session.createQuery("from Player", Player.class).getResultList();

            session.getTransaction().commit();
        }

        return players;
    }

    @Override
    public Player update(Player entity) {
        Player player = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            player = session.merge(entity);

            session.getTransaction().commit();
        }
        return player;
    }

    @Override
    public void save(Player entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(entity);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Player entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.remove(entity);

            session.getTransaction().commit();
        }
    }
}
