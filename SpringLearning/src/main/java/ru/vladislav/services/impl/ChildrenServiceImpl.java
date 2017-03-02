package ru.vladislav.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.entities.Child;
import ru.vladislav.services.ChildrenService;

@Component
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    @Qualifier("dao.hibernate.children")
    private ChildrenDao childrenDao;

    public Long save(Child child) {
        return childrenDao.save(child);
    }

    public Child find(Long id) {
        return null;
    }

    public Child findByName(String name) {
        return null;
    }

    public void update(Child child) {

    }

    public void delete(Long id) {

    }
}
