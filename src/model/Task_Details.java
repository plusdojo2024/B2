package model;

import java.io.Serializable;

public class Task_Details implements Serializable{
	private int ID; //ID
	private String task_name; //家事名
	private String description; //説明
	private int effort; //労力
	private int frequency; //頻度
	private int houses_id; //ハウスID

	public Task_Details() {

	}

	public Task_Details(int ID, String task_name, String description, int effort, int frequency, int houses_id) {
		super();
		this.ID = ID;
		this.task_name = task_name;
		this.description = description;
		this.effort = effort;
		this.frequency = frequency;
		this.houses_id = houses_id;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getHouses_id() {
		return houses_id;
	}

	public void setHouses_id(int houses_id) {
		this.houses_id = houses_id;
	}



}
