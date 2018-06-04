package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.beans.Todo;
import todo.utils.DBUtils;
import todo.utils.Utils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		req.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
//				.forward(req, resp);

		String id = req.getParameter("id");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();

			String sql=""
						+ "select id, title, content, level, deadline"
						+ " from todolist"
						+ " where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			System.out.println(ps);

			rs = ps.executeQuery();

			if(!rs.next()) {
				throw new Exception();
			}

			Todo todolist = new Todo(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("level"),
						Utils.date2LocalDate(rs.getDate("deadline"))
					);

			req.setAttribute("todolist", todolist);

			req.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
			.forward(req, resp);

		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			DBUtils.close(con, ps, rs);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
				.forward(req, resp);


	}
}
