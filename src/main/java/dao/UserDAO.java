package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    boolean addUser(User user);
    boolean deleteUser(String ssn);
    boolean updateUserzData(User user);
    List<User> getAllUsers();

}
