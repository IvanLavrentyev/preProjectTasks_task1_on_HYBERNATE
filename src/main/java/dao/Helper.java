package dao;

import org.hibernate.Session;

@FunctionalInterface
public interface Helper <T>{
    T help(Session session);
}
