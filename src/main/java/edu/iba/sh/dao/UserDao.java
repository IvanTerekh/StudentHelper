package edu.iba.sh.dao;


import edu.iba.sh.bean.User;

import java.util.List;

public interface UserDao {
    void create(User user) throws DaoException;

    List<User> getAll() throws DaoException;

    User getByUser(String user) throws DaoException;

    boolean update(User user, String oldUser) throws DaoException;

    boolean deleteByUser(String user) throws DaoException;

    User getByUserAndPassword(String user, String password) throws DaoException;

}
