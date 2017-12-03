package edu.iba.sh.dao;

import edu.iba.sh.bean.Group;

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

	public static GroupDao getGroupDao() {
		switch (currentType) {
			case DB2:
				return new edu.iba.sh.dao.db2.GroupDaoImplementation();
			case MySql:
				return new edu.iba.sh.dao.mysql.GroupDaoImplementation();
			default:
				return null;
		}
	}

	public static UserDao getUserDao() {
		switch (currentType) {
			case DB2:
				return new edu.iba.sh.dao.db2.UserDaoImplementation();
			case MySql:
				return new edu.iba.sh.dao.mysql.UserDaoImplementation();
			default:
				return null;
		}
	}

	public static MarkDao getMarkDao() {
		switch (currentType) {
			case DB2:
				return new edu.iba.sh.dao.db2.MarkDaoImplementation();
			case MySql:
				return new edu.iba.sh.dao.mysql.MarkDaoImplementation();
			default:
				return null;
		}
	}
}
