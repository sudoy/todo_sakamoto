package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.beans.Todo;
import todo_utils.DBUtils;
import todo_utils.Utils;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//context.xalのリソースへアクセス
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try{
//			Context initContext = new InitialContext();
//			Context envContext = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/mysql");
			con = DBUtils.getConnection();

			//コネクションプールからコネクションを1つもらう。
			//con = ds.getConnection();

			sql = "select * from todolist ORDER BY id";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			ArrayList<Todo> list = new ArrayList<>();

			while(rs.next()) {
				Todo tdl = new Todo(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("level"),
						Utils.date2LocalDate(rs.getDate("deadline")));
				list.add(tdl);
			}

			req.setAttribute("list", list);

			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
					.forward(req, resp);

		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(ps != null){ps.close();}
				if(con != null){con.close();}
			}catch(Exception e){ }
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
				.forward(req, resp);
	}
}
