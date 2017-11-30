package edu.iba.sh.dao;

public class DaoFactory {

	enum Type {
		DB2, MySql
	}

	private static Type currentType = Type.MySql;

	public static StudentDao getStudentDao() {
		switch (currentType) {
		case DB2:
			return new edu.iba.sh.dao.db2.StudentDaoImplementation();
		case MySql:
			return new edu.iba.sh.dao.mysql.StudentDaoImplementation();
		default:
			return null;
		}
	}
}
