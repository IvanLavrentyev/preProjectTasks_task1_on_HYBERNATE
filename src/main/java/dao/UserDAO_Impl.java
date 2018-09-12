package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.SFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDAO_Impl implements UserDAO{

    private final SessionFactory sessionFactory = SFactory.createSessionFactory();

    @Override
    public void addUser(String name, String login, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(name,login,password));
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUserById(long id) {
        Helper helper = new Helper();
        helper.help(result -> {
            User user = result.get(User.class, id);
            result.delete(user);
            return null;
        });


//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = session.get(User.class, id);
//        session.delete(user);
//        transaction.commit();
//        session.close();
    }

    @Override
    public void updateUser(long id, String name, String login, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(long id) {
        Helper helper = new Helper();
        return helper.help(result ->{
            User user = result.get(User.class,id);
            return user;
        });

//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = session.get(User.class, id);
//        transaction.commit();
//        session.close();
//        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Helper h = new Helper();
        return h.help(result ->{
            String sql = "From " + User.class.getSimpleName();
            List<User> userList = new ArrayList<User> (result.createQuery(sql).list());
            return userList;
        });
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        String sql = "From " + User.class.getSimpleName();
//        List<User> userList = new ArrayList<User> (session.createQuery(sql).list());
//        transaction.commit();
//        session.close();
//        return userList;

    }

    private class Helper {
        private <T> T help(dao.Helper <T> helper){
            T result = null;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            result = helper.help(session);
            transaction.commit();
            session.close();
            return result;
        };
    }

}
