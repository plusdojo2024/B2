package model;
import java.io.Serializable;

public class TaskAutoBox implements Serializable {
	private int day;
	private String user_name;
	private String task_name;

	public TaskAutoBox() {

	}

	public TaskAutoBox(int day, String user_name, String task_name) {
		super();
		this.day = day;
		this.user_name = user_name;
		this.task_name = task_name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}






}
