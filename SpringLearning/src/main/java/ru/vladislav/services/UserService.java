package ru.vladislav.services;

import ru.vladislav.entities.User;

public interface UserService extends BaseService<User>{

    /**
     * проверяет, удовлетворен ли пользователь или нет
     * @param userName имя пользователя
     * @return удовлетворен или нет
     */
    boolean isGranted(String userName);

    boolean isRegistered(String userName);

}
