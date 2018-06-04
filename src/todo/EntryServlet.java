package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.servlet.http.HttpSession;

import todo.utils.DBUtils;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String level = req.getParameter("level");
		String deadline = req.getParameter("deadline");

		List<String> errors = validate(title,deadline,level);
		if(errors.size() > 0) {

			session.setAttribute("errors", errors);

			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
				.forward(req, resp);

			return;
		}

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBUtils.getConnection();

			String sql = ""
						+"insert into todolist(title, content, level, deadline)"
						+"values(?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, level);
			ps.setString(4, deadline.equals("")? null: deadline);

			ps.executeUpdate();

			List<String> successes = new ArrayList<>();
			successes.add("登録しました。");
			session.setAttribute("successes", successes);


			resp.sendRedirect("index.html");

		} catch (Exception e) {
			throw new ServletException(e);

		}finally {
				DBUtils.close(con, ps);
		}
	}

	private List<String> validate(String title, String deadline, String level) {
		List<String> errors = new ArrayList<>();

		System.out.println(title);

		if(title.equals("")) {
			errors.add("題名は必須です。");
		}

		if(title.length() > 100) {
			errors.add("題名は100文字以内です。");
		}

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
