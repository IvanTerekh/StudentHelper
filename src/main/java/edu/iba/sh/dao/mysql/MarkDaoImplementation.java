package edu.iba.sh.dao.mysql;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.MarkDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarkDaoImplementation implements MarkDao {

    private static final String GET_ALL_SQL = "SELECT "
            + " ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS "
            + " FROM marks ";
    private static final String GET_BY_ID_SQL = "SELECT "
            + " ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS "
            + " FROM marks WHERE ID = ? ";
    private static final String DELETE_BY_ID_SQL = "DELETE FROM marks "
            + " WHERE ID = ? ";
    private static final String UPDATE_SQL = "UPDATE marks "
            + " SET STUDY_ID = ?, STUDENT_ID = ?, DATE = ?, PROFESSOR_ID = ?, MARK = ?, COMMENTS = ? "
            + " WHERE ID = ? ";
    private static final String CREATE_SQL = "INSERT INTO marks "
            + " (ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS) "
            + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) ";

    @Override
    public void create(Mark mark) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, mark.getStudyId());
            preparedStatement.setLong(2, mark.getStudentId());
            preparedStatement.setString(3, mark.getDate());
            preparedStatement.setLong(4, mark.getProfessorId());
            preparedStatement.setInt(5, mark.getMark());
            preparedStatement.setString(6, mark.getComments());
            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            int generatedId = generatedKeys.getInt(1);

            mark.setId(generatedId);
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
    public List<Mark> getAll() throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_ALL_SQL);
            ResultSet set = preparedStatement.executeQuery();

            List<Mark> list = new ArrayList<Mark>();
            while (set.next()) {
                Mark mark = new Mark();
                mark.setId(set.getLong("ID"));
                mark.setStudyId(set.getLong("STUDY_ID"));
                mark.setStudentId(set.getLong("STUDENT_ID"));
                mark.setDate(set.getString("DATE"));
                mark.setMark(set.getInt("MARK"));
                mark.setComments(set.getString("COMMENTS"));
                list.add(mark);
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
    public Mark getById(long id) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                Mark mark = new Mark();
                mark.setId(set.getLong("ID"));
                mark.setStudyId(set.getLong("STUDY_ID"));
                mark.setStudentId(set.getLong("STUDENT_ID"));
                mark.setDate(set.getString("DATE"));
                mark.setMark(set.getInt("MARK"));
                mark.setComments(set.getString("COMMENTS"));
                return mark;
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
    public boolean update(Mark mark) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(UPDATE_SQL);
            preparedStatement.setLong(1, mark.getStudyId());
            preparedStatement.setLong(2, mark.getStudentId());
            preparedStatement.setString(3, mark.getDate());
            preparedStatement.setLong(4, mark.getProfessorId());
            preparedStatement.setInt(5, mark.getMark());
            preparedStatement.setString(6, mark.getComments());
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
    public boolean deleteById(long id) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(DELETE_BY_ID_SQL);
            preparedStatement.setLong(1, id);
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
}
