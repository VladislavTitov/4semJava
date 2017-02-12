package dao;

public class UserDaoImpl implements UserDao {
    public String getUserFirstNameById(int id) {
        if (id == 1){
            return "Vladislav";
        }else {
            return "Nobody";
        }
    }

    public String getUserLastNameById(int id) {
        if (id == 1){
            return "Titov";
        }else {
            return "Nobody";
        }
    }
}
