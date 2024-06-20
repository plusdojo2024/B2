// 家事クラス
// 家事の名前、頻度、労力をフィールドにもち、コンストラクタとゲッターセッターを持つ。

package model;

public class TaskAutoInfo {
	String task_name;
	int frequency;
	int effort;

	// コンストラクタ
	public TaskAutoInfo(String task_name, int frequency, int effort) {
		super();
		this.task_name = task_name;
		this.frequency = frequency;
		this.effort = effort;
	}

	public TaskAutoInfo() {

	}

	// getter, setter
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


}
