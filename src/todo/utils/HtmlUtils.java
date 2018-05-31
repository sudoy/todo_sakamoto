package todo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import todo.beans.Todo;

public class HtmlUtils {
	public static String test() {
		return "test";
	}

	public static String formatDeadline(Todo tdl) {
		LocalDate line = tdl.getDeadline();

		if(line == null) {
			return "";
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return line.format(dtf);

	}
}
