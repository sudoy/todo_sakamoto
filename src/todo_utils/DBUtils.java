package todo_utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {
	public static Connection getConnection()
			throws NamingException, SQLException {

		//データベースへの接続の確立
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/mysql");

		return ds.getConnection();
	}

	public static void close(Connection con) throws SQLException {
		if(con != null){
			con.close();
		}
	}
}
