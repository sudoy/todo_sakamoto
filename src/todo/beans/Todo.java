package todo.beans;

public class Todo {
	private int id;
	private String title;
	private String level;
	private String deadline;

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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Todo(int id, String title, String level, String deadline) {
		super();
		this.id = id;
		this.title = title;
		this.level = level;
		this.deadline = deadline;
	}

}
