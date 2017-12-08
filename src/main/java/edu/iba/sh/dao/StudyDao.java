package edu.iba.sh.dao;
import edu.iba.sh.bean.Study;

import java.util.List;

public interface StudyDao {

    void create(Study study) throws DaoException;

    List<Study> getAll() throws DaoException;

    Study getById(long id) throws DaoException;

    boolean update(Study study) throws DaoException;

    boolean deleteById(long id) throws DaoException;
}
