package model;

import java.io.Serializable;

public class TaskNameFreqEffo implements Serializable {
	private String task_name;
	private int frequency;
	private int effort;

	public TaskNameFreqEffo() {

	}

	public TaskNameFreqEffo(String task_name, int frequency, int effort) {
		super();
		this.task_name = task_name;
		this.frequency = frequency;
		this.effort = effort;
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



}
