package edu.iba.sh.dao;

import java.util.List;

import edu.iba.sh.bean.Student;

public interface StudentDao {

	void create(Student student) throws DaoException;
	
	List<Student> getAll() throws DaoException;
	
	Student getById(long id) throws DaoException;
	
	boolean update(Student student) throws DaoException;
	
	boolean deleteById(long id) throws DaoException;
}
