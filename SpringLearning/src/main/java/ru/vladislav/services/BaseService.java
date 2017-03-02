package ru.vladislav.services;

public interface BaseService<M> {
    Long save(M m);

    M find(Long id);

    M findByName(String name);

    void update(M m);

    void delete(Long id);
}
