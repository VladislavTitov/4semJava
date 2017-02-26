package ru.vladislav.dao;

import java.util.List;

public interface BaseDao<M> {

    Long save(M model);

    M find(Long id);

    void update(M model);

    void delete(Long id);

    List<M> findAll();

}
