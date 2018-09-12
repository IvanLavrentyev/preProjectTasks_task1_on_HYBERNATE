package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    void addUser(String name, String login, String password);
    void deleteUserById(long id);
    void updateUser(long id, String name, String login, String password);
    User getUserById(long id);
    List<User> getAllUsers();
}


