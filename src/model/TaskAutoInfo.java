// 家事クラス
// 家事の名前、頻度、労力をフィールドにもち、コンストラクタとゲッターセッターを持つ。

package model;

public class TaskAutoInfo {
	String task_name;
	int frequency;
	int effort;
	String day; //曜日
	String user_name; //担当者名

	// コンストラクタ
	public TaskAutoInfo(String task_name, int frequency, int effort, String day, String user_name) {
		super();
		this.task_name = task_name;
		this.frequency = frequency;
		this.effort = effort;
		this.day = day;
		this.user_name = user_name;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
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
