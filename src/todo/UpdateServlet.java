package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

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
		req.setCharacterEncoding("utf-8");

		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String level = req.getParameter("level");
		String deadline = req.getParameter("deadline");

		List<String> errors = validate(id, title, deadline, level);
		if(errors.size() > 0) {
			req.setAttribute("errors", errors);
			req.setAttribute("todolist", new Todo());

			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
				.forward(req, resp);

			return;
		}



		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBUtils.getConnection();

			String sql = ""
						+ "update todolist set"
						+ " title = ?, content = ?, level = ?, deadline = ?"
						+ " where id = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, level);
			ps.setString(4, deadline.equals("")? null: deadline);
			ps.setString(5, id);

			ps.executeUpdate();

			resp.sendRedirect("index.html");

		} catch (Exception e) {
			throw new ServletException(e);

		}finally {
				DBUtils.close(con, ps);
		}
	}

	private List<String> validate(String id, String title, String deadline, String level) {
		List<String> errors = new ArrayList<>();

		if(id == null || id.equals("")) {
			errors.add("不正なアクセスです。");
		}

		if(title.equals("")) {
			errors.add("題名は必須です。");
		}

		if(title.length() > 100) {
			errors.add("題名は100文字以内です。");
		}

		System.out.println(deadline);

		if(!deadline.equals("")) {
			try {
				LocalDate.parse(deadline, DateTimeFormatter.ofPattern("uuuu/MM/dd")
						.withResolverStyle(ResolverStyle.STRICT));
			}catch(Exception e) {
				errors.add("期限は「YYYY/MM/DD」の形式で入力してください。");
			}
		}

		if(!level.equals("★★★") && !level.equals("★★") && !level.equals("★")) {
			errors.add("不正なアクセスです。");
		}

		return errors;
	}
}
