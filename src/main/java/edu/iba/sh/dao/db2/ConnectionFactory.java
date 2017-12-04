package edu.iba.sh.dao.db2;

import edu.iba.sh.dao.DaoException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory{

    static Connection getConnection() throws DaoException {
        try {
            String jndiName = "jdbc/StudentHelperDS";
            DataSource dataSource = (DataSource) new InitialContext()
                    .lookup(jndiName);

            return dataSource.getConnection();
        } catch (NamingException e) {
            throw new DaoException(e);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

}
