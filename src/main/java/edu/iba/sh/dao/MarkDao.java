package edu.iba.sh.dao;

import edu.iba.sh.bean.Mark;

import java.util.List;

public interface MarkDao {

    void create(Mark mark) throws DaoException;

    List<Mark> getAll() throws DaoException;

    Mark getById(long id) throws DaoException;

    boolean update(Mark mark) throws DaoException;

    boolean deleteById(long id) throws DaoException;
}
