package todo.beans;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String title;
	private String content;
	private String level;
	private LocalDate deadline;

	public Todo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Todo(int id, String title, String content, String level, LocalDate deadline) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.level = level;
		this.deadline = deadline;
	}

}
