package todo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		DataSource ds = (DataSource)envContext.lookup("todolist_sakamoto");

		return ds.getConnection();
	}

	public static void close(Connection con, PreparedStatement ps, ResultSet rs){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection con, PreparedStatement ps) {
		if(con != null){
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		if(ps != null) {
			try{
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
