package ru.vladislav.services;

import ru.vladislav.entities.User;

public interface UserService {

    /**
     * проверяет, удовлетворен ли пользователь или нет
     * @param userName имя пользователя
     * @return удовлетворен или нет
     */
    boolean isGranted(String userName);

    boolean isRegistered(String userName);

    Long save(User user);

    User find(Long id);

    User findByName(String name);

    void update(User user);

    void delete(Long id);

}
