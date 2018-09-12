package service;

import dao.UserDAO;
import dao.UserDAO_Impl;
import model.User;

import java.util.List;

public class UserService implements UserDAO {

    private final UserDAO_Impl userDAO_Impl = new UserDAO_Impl();

    @Override
    public void addUser(String name, String login, String password) {
        userDAO_Impl.addUser(name,login,password);
    }

    @Override
    public void deleteUserById(long id) {
        userDAO_Impl.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO_Impl.getAllUsers();
    }

    @Override
    public void updateUser(long id, String name, String login, String password) {
        userDAO_Impl.updateUser(id,name,login,password);
    }

    @Override
    public User getUserById(long id) {
        return userDAO_Impl.getUserById(id);
    }
}
