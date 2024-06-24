package model;

public class TaskAutoList {
	String task_name; //家事名
	String day; //曜日
	String user_name; //担当者名

	// コンストラクタ
	public TaskAutoList(String task_name, String day, String user_name) {
		super();
		this.task_name = task_name;
		this.day = day;
		this.user_name = user_name;
	}

	// それぞれのgetter, setter
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


}
