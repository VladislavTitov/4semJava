package ru.vladislav.services;

import java.util.List;

public interface BaseService<M> {

    M save(M m);

    void delete(Long id);

    void delete(M m);

    List<M> findAll();

    M find(Long id);
    
}
