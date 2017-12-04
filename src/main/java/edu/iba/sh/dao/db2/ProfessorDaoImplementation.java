package edu.iba.sh.dao.db2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.ProfessorDao;

public class ProfessorDaoImplementation implements ProfessorDao {

	private static final String GET_ALL_SQL = "SELECT "
			+ " ID, FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK "
			+ " FROM professors ";
	private static final String GET_BY_ID_SQL = "SELECT "
			+ " ID, FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK "
			+ " FROM professors WHERE ID = ? ";
	private static final String DELETE_BY_ID_SQL = "DELETE FROM professors "
			+ " WHERE ID = ? ";
	private static final String UPDATE_SQL = "UPDATE professors "
			+ " SET FIRST_NAME = ?, SECOND_NAME = ?, FATHER_NAME = ?, BIRTH_DATE = ?, AVG_MARK = ? "
			+ " WHERE ID = ? ";
	private static final String CREATE_SQL = "INSERT INTO professors "
			+ " (FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK) "
			+ " VALUES (?, ?, ?, ?, ?) ";

	@Override
	public void create(Professor professor) throws DaoException {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, professor.getFirstName());
			preparedStatement.setString(2, professor.getSecondName());
			preparedStatement.setString(3, professor.getFatherName());
			preparedStatement.setString(4, professor.getBirthDate());
			preparedStatement.setDouble(5, professor.getAvgMark());
			preparedStatement.execute();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			generatedKeys.next();
			int generatedId = generatedKeys.getInt(1);

			professor.setId(generatedId);
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
	public List<Professor> getAll() throws DaoException {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(GET_ALL_SQL);
			ResultSet set = preparedStatement.executeQuery();

			List<Professor> list = new ArrayList<Professor>();
			while (set.next()) {
				Professor professor = new Professor();
				professor.setId(set.getInt("ID"));
				professor.setFirstName(set.getString("FIRST_NAME"));
				professor.setSecondName(set.getString("SECOND_NAME"));
				professor.setFatherName(set.getString("FATHER_NAME"));
				professor.setBirthDate(set.getString("BIRTH_DATE"));
				professor.setAvgMark(set.getDouble("AVG_MARK"));
				list.add(professor);
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
	public Professor getById(long id) throws DaoException {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(GET_BY_ID_SQL);
			preparedStatement.setLong(1, id);
			ResultSet set = preparedStatement.executeQuery();

			if (set.next()) {
				Professor professor = new Professor();
				professor.setId(set.getInt("ID"));
				professor.setFirstName(set.getString("FIRST_NAME"));
				professor.setSecondName(set.getString("SECOND_NAME"));
				professor.setFatherName(set.getString("FATHER_NAME"));
				professor.setBirthDate(set.getString("BIRTH_DATE"));
				professor.setAvgMark(set.getDouble("AVG_MARK"));
				return professor;
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
	public boolean update(Professor professor) throws DaoException {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, professor.getFirstName());
			preparedStatement.setString(2, professor.getSecondName());
			preparedStatement.setString(3, professor.getFatherName());
			preparedStatement.setString(4, professor.getBirthDate());
			preparedStatement.setDouble(5, professor.getAvgMark());
			preparedStatement.setLong(6, professor.getId());
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
