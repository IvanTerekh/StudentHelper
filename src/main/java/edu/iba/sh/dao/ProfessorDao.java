package edu.iba.sh.dao;

import java.util.List;

import edu.iba.sh.bean.Professor;

public interface ProfessorDao {

	void create(Professor professor) throws DaoException;
	
	List<Professor> getAll() throws DaoException;
	
	Professor getById(long id) throws DaoException;
	
	boolean update(Professor professor) throws DaoException;
	
	boolean deleteById(long id) throws DaoException;
}
