package edu.iba.sh.dao.mysql;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.StudentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentDaoImplementation implements StudentDao {

    private static final String GET_ALL_SQL = "SELECT "
            + " ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER "
            + " FROM STUDENTS ";
    private static final String GET_BY_ID_SQL = "SELECT "
            + " ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER "
            + " FROM STUDENTS WHERE ID = ? ";
    private static final String DELETE_BY_ID_SQL = "DELETE FROM STUDENT "
            + " WHERE ID = ? ";
    private static final String UPDATE_SQL = "UPDATE STUDENTS "
            + " SET FIRST_NAME = ?, SECOND_NAME = ?, AVG_MARK = ?, GROUP_NUMBER = ? "
            + " WHERE ID = ? ";
    private static final String CREATE_SQL = "INSERT INTO STUDENTS "
            + " (FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER) "
            + " VALUES (?, ?, ?, ?) ";

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
    public void create(Student student) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getSecondName());
            preparedStatement.setDouble(3, student.getAvgMark());
            preparedStatement.setString(4, student.getGroupNumber());
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            System.out.println(generatedKeys.getInt(1));
            System.out.println(generatedKeys.getObject(2));
            System.out.println(generatedKeys.getObject(3));
            System.out.println(generatedKeys.getObject(4));
            System.out.println(generatedKeys.getObject(5));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Student> getAll() throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_ALL_SQL);
            ResultSet set = preparedStatement.executeQuery();

            List<Student> list = new ArrayList<Student>();
            while (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("ID"));
                student.setFirstName(set.getString("FIRST_NAME"));
                student.setSecondName(set.getString("SECOND_NAME"));
                student.setAvgMark(set.getDouble("AVG_MARK"));
                student.setGroupNumber(set.getString("GROUP_NUMBER"));
                list.add(student);
            }

            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Student getById(long id) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("ID"));
                student.setFirstName(set.getString("FIRST_NAME"));
                student.setSecondName(set.getString("SECOND_NAME"));
                student.setAvgMark(set.getDouble("AVG_MARK"));
                student.setGroupNumber(set.getString("GROUP_NUMBER"));
                return student;
            }

            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(Student student) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getSecondName());
            preparedStatement.setDouble(3, student.getAvgMark());
            preparedStatement.setString(4, student.getGroupNumber());
            preparedStatement.setLong(5, student.getId());
            int count = preparedStatement.executeUpdate();

            return count == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(DELETE_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            int count = preparedStatement.executeUpdate();

            return count == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}