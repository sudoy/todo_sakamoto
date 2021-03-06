package todo.utils;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Utils {
	public static LocalDate date2LocalDate(final Date date) {
		if(date != null) {
			return date.toLocalDate();
		}
		return null;
	}


	public static boolean checkLogin(HttpServletRequest req, HttpServletResponse resp)
		throws IOException{

		HttpSession session = req.getSession();

		if(session.getAttribute("user") == null) {

			List<String> errors = new ArrayList<>();

			errors.add("ログインしてください。");
			session.setAttribute("errors", errors);

			resp.sendRedirect("login.html");

			return false;

		}else {

			return true;

		}

	}

}