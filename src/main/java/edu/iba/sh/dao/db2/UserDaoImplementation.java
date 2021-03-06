package edu.iba.sh.dao.db2;


import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.UserDao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDaoImplementation implements UserDao {

    private static final String GET_ALL_SQL = "SELECT "
            + " \"USER\", PASSWORD, ROLE "
            + " FROM users ";
    private static final String GET_BY_USER_SQL = "SELECT "
            + " \"USER\", PASSWORD, ROLE "
            + " FROM users WHERE USER = ? ";
    private static final String DELETE_BY_USER_SQL = "DELETE FROM users "
            + " WHERE \"USER\" = ? ";
    private static final String UPDATE_SQL = "UPDATE users "
            + " SET \"USER\" = ?, PASSWORD = ?, ROLE = ? "
            + " WHERE \"USER\" = ? ";
    private static final String CREATE_SQL = "INSERT INTO users "
            + " (\"USER\", PASSWORD, ROLE) "
            + " VALUES (?, ?, ?) ";
    private static final String GET_BY_USER_AND_PASSWORD_SQL = " SELECT \"USER\", PASSWORD, ROLE " +
            " FROM USERS " +
            " WHERE \"USER\" = ? " +
            " AND " +
            " PASSWORD = ? ";

    @Override
    public void create(User user) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(CREATE_SQL);
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public List<User> getAll() throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_ALL_SQL);
            ResultSet set = preparedStatement.executeQuery();

            List<User> list = new ArrayList<User>();
            while (set.next()) {
                User user = new User();
                user.setUser(set.getString("USER"));
                user.setPassword(set.getString("PASSWORD"));
                user.setRole(set.getString("ROLE").toLowerCase());
                list.add(user);
            }

            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public User getByUser(String user) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_USER_SQL);
            preparedStatement.setString(1, user);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                User foundUser = new User();
                foundUser.setUser(set.getString("USER"));
                foundUser.setPassword(set.getString("PASSWORD"));
                foundUser.setRole(set.getString("ROLE").toLowerCase());
                return foundUser;
            }

            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public boolean update(User user, String oldUser) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, oldUser);
            int count = preparedStatement.executeUpdate();

            return count == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public boolean deleteByUser(String user) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(DELETE_BY_USER_SQL);
            preparedStatement.setString(1, user);
            int count = preparedStatement.executeUpdate();

            return count == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public User getByUserAndPassword(String user, String password)
            throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_USER_AND_PASSWORD_SQL);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                User userBean = new User();
                userBean.setUser(user);
                userBean.setPassword(password);
                userBean.setRole(set.getString("ROLE").toLowerCase());
                return userBean;
            }

            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
