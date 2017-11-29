package edu.iba.sh.dao;

import edu.iba.sh.dao.db2.StudentDaoImplementation;

public class DaoFactory {

	enum Type {
		DB2, MySql
	}

	private static Type currentType = Type.DB2;

	public static StudentDao getStudentDao() {
		switch (currentType) {
		case DB2:
			return new StudentDaoImplementation();
		case MySql:
			return null;
		default:
			return null;
		}
	}
}
