package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.utils.DBUtils;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String id = req.getParameter("id");

		List<String> errors = validate(id);
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);
			resp.sendRedirect("index.html");
			return;
		}

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBUtils.getConnection();

			String sql = ""
						+"delete from todolist"
						+" where id = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ps.executeUpdate();

			List<String> successes = new ArrayList<>();
			successes.add("削除しました。");
			session.setAttribute("successes", successes);

			resp.sendRedirect("index.html");

		}catch(Exception e) {
			throw new ServletException();
		}finally {
			DBUtils.close(con, ps);
		}
	}

	private List<String> validate(String id) {
		List<String> errors = new ArrayList<>();

		if(id == null || id.equals("")) {
			errors.add("不正なアクセスです。");
		}

		return errors;
	}
}
