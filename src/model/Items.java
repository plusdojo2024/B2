package model;

import java.io.Serializable;

public class Items implements Serializable{
	private int ID; //ID
	private String item_name; //アイテム名
	private int status; //状態
	private int task_details_id; //タスク詳細ID
	private int houses_id; //ハウスID

	public Items() {

	}

	public Items(int ID, String item_name, int status, int task_details_id, int houses_id) {
		super();
		this.ID = ID;
		this.item_name = item_name;
		this.status = status;
		this.task_details_id = task_details_id;
		this.houses_id = houses_id;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTask_details_id() {
		return task_details_id;
	}

	public void setTask_details_id(int task_details_id) {
		this.task_details_id = task_details_id;
	}

	public int getHouses_id() {
		return houses_id;
	}

	public void setHouses_id(int houses_id) {
		this.houses_id = houses_id;
	}


}
