package services;

import dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private int lastId;

    /*public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int getLastId() {
        return lastId;
    }

    public String getUserFullNameById(int id) {
        this.lastId = id;
        return userDao.getUserFirstNameById(id) + " " + userDao.getUserLastNameById(id);
    }

    public void onInit(){
        System.out.println("Initialization of UserService object...");
    }
}
