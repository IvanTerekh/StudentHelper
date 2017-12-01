package edu.iba.sh.dao.mysql;

import edu.iba.sh.bean.Group;
import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.GroupDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GroupDaoImplementation implements GroupDao {

    private static final String GET_ALL_SQL = "SELECT "
            + " GROUP_NUMBER, AVG_MARK "
            + " FROM groups ";
    private static final String GET_BY_GROUP_NUMBER_SQL = "SELECT "
            + " GROUP_NUMBER, AVG_MARK "
            + " FROM groups WHERE GROUP_NUMBER = ? ";
    private static final String DELETE_BY_ID_SQL = "DELETE FROM groups "
            + " WHERE GROUP_NUMBER = ? ";
    private static final String UPDATE_SQL = "UPDATE groups "
            + " SET GROUP_NUMBER = ?, AVG_MARK = ? "
            + " WHERE GROUP_NUMBER = ? ";
    private static final String CREATE_SQL = "INSERT INTO groups "
            + " (GROUP_NUMBER, AVG_MARK) "
            + " VALUES (?, ?) ";

    private ResourceBundle resources = ResourceBundle.getBundle("mysql");

    private Connection getConnection() throws DaoException {
        try {
            java.sql.Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            return DriverManager.getConnection(
                    resources.getString("url"),
                    resources.getString("user"),
                    resources.getString("password"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void create(Group group) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(CREATE_SQL);
            preparedStatement.setString(1, group.getGroupNumber());
            preparedStatement.setDouble(2, group.getAvgMark());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Group> getAll() throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_ALL_SQL);
            ResultSet set = preparedStatement.executeQuery();

            List<Group> list = new ArrayList<Group>();
            while (set.next()) {
                Group group = new Group();
                group.setGroupNumber(set.getString("GROUP_NUMBER"));
                group.setAvgMark(set.getDouble("AVG_MARK"));
                list.add(group);
            }

            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Group getByGroupNumber(String oldGroupNumber) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_GROUP_NUMBER_SQL);
            preparedStatement.setString(1, oldGroupNumber);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                Group group = new Group();
                group.setGroupNumber(set.getString("GROUP_NUMBER"));
                group.setAvgMark(set.getDouble("AVG_MARK"));
                return group;
            }

            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(Group group, String oldGroupNumber) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, group.getGroupNumber());
            preparedStatement.setDouble(2, group.getAvgMark());
            preparedStatement.setString(3, oldGroupNumber);
            int count = preparedStatement.executeUpdate();

            return count == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean deleteByGroupNumber(String groupNumber) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(DELETE_BY_ID_SQL);
            preparedStatement.setString(1, groupNumber);
            int count = preparedStatement.executeUpdate();

            return count == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

