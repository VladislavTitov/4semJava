package ru.vladislav.dao;

import ru.vladislav.entities.Child;

import java.util.List;

public interface ChildrenDao extends BaseDao<Child> {

    List<Child> findByUserId(Long userId);

}
