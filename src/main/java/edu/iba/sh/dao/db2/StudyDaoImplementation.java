package edu.iba.sh.dao.db2;

import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.StudyDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudyDaoImplementation implements StudyDao {

    private static final String GET_ALL_SQL = "SELECT "
            + " ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK "
            + " FROM studies ";
    private static final String GET_BY_ID_SQL = "SELECT "
            + " ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK "
            + " FROM studies WHERE ID = ? ";
    private static final String DELETE_BY_ID_SQL = "DELETE FROM studies "
            + " WHERE ID = ? ";
    private static final String UPDATE_SQL = "UPDATE studies "
            + " SET NAME = ?, HOURS = ?, PROFESSOR_ID = ?, AVG_MARK = ? "
            + " WHERE ID = ? ";
    private static final String CREATE_SQL = "INSERT INTO studies "
            + " (ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK) "
            + " VALUES (DEFAULT, ?, ?, ?, ?) ";


    @Override
    public void create(Study study) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, study.getName());
            preparedStatement.setInt(2, study.getHours());
            preparedStatement.setLong(3, study.getProfessorId());
            preparedStatement.setDouble(4, study.getAvgMark());
            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            int generatedId = generatedKeys.getInt(1);

            study.setId(generatedId);
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
    public List<Study> getAll() throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_ALL_SQL);
            ResultSet set = preparedStatement.executeQuery();

            List<Study> list = new ArrayList<Study>();
            while (set.next()) {
                Study study = new Study();
                study.setId(set.getInt("ID"));
                study.setName(set.getString("NAME"));
                study.setAvgMark(set.getDouble("AVG_MARK"));
                study.setHours(set.getInt("PROFESSOR_ID"));
                study.setHours(set.getInt("HOURS"));
                list.add(study);
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
    public Study getById(long id) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                Study study = new Study();
                study.setId(set.getInt("ID"));
                study.setName(set.getString("NAME"));
                study.setAvgMark(set.getDouble("AVG_MARK"));
                study.setHours(set.getInt("PROFESSOR_ID"));
                study.setHours(set.getInt("HOURS"));
                return study;
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
    public boolean update(Study study) throws DaoException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, study.getName());
            preparedStatement.setInt(2, study.getHours());
            preparedStatement.setLong(3, study.getProfessorId());
            preparedStatement.setDouble(4, study.getAvgMark());
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