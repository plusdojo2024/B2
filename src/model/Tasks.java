package model;

import java.io.Serializable;

public class Tasks implements Serializable{
	private int ID;
	private int task_details_id;
	private int users_id;
	private int assigned_date;
	private boolean task_finish;
	private boolean item_finish;
	private int houses_id;

	public Tasks(){

	}

	public Tasks(int ID, int task_details_id, int users_id, int assigned_date, boolean task_finish,
			boolean item_finish, int houses_id) {
		super();
		this.ID = ID;
		this.task_details_id = task_details_id;
		this.users_id = users_id;
		this.assigned_date = assigned_date;
		this.task_finish = task_finish;
		this.item_finish = item_finish;
		this.houses_id = houses_id;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getTask_details_id() {
		return task_details_id;
	}

	public void setTask_details_id(int task_details_id) {
		this.task_details_id = task_details_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getAssigned_date() {
		return assigned_date;
	}

	public void setAssigned_date(int assigned_date) {
		this.assigned_date = assigned_date;
	}

	public boolean isTask_finish() {
		return task_finish;
	}

	public void setTask_finish(boolean task_finish) {
		this.task_finish = task_finish;
	}

	public boolean isItem_finish() {
		return item_finish;
	}

	public void setItem_finish(boolean item_finish) {
		this.item_finish = item_finish;
	}

	public int getHouses_id() {
		return houses_id;
	}

	public void setHouses_id(int houses_id) {
		this.houses_id = houses_id;
	}


}
