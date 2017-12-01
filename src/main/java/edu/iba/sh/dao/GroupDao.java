package edu.iba.sh.dao;

import edu.iba.sh.bean.Group;

import java.util.List;

public interface GroupDao {

    void create(Group group) throws DaoException;

    List<Group> getAll() throws DaoException;

    Group getByGroupNumber(String oldGroupNumber) throws DaoException;

    boolean update(Group group, String oldGroupNumber) throws DaoException;

    boolean deleteByGroupNumber(String groupNumber) throws DaoException;
}
