package ru.mrsinkaaa.repository;

import java.util.List;

public interface CrudRepository<T> {

    T findById(int id);

    List<T> findAll();

    T update(T entity);

    void save(T entity);

    void delete(T entity);


}
