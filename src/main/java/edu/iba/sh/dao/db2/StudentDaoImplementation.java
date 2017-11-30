package edu.iba.sh.dao.db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.StudentDao;

public class StudentDaoImplementation implements StudentDao {

    private static final String GET_ALL_SQL = "SELECT "
            + " ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER "
            + " FROM STUDENTS ";
    private static final String GET_BY_ID_SQL = "SELECT "
            + " ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER "
            + " FROM STUDENTS WHERE ID = ? ";
    private static final String DELETE_BY_ID_SQL = "DELETE FROM STUDENT "
            + " WHERE ID = ? ";

    private Connection getConnection() throws DaoException {
        try {
            String jndiName = "jdbc/StudentHelperDS";
            DataSource dataSource = (DataSource) new InitialContext()
                    .lookup(jndiName);

            return dataSource.getConnection();
        } catch (NamingException e) {
            throw new DaoException(e);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void create(Student student) throws DaoException {

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
        return false;
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
