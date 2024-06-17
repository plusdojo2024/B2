package model;

import java.io.Serializable;

public class Approvals implements Serializable {

	private int ID; //ID
	private String settlements_id; //精算ID
	private String users_id; //ユーザーID
	private String confirm; //支払チェック済か

	public Approvals() {

	}

	public Approvals(int ID, String settlements_id, String users_id, String confirm) {
		super();
		this.ID = ID;
		this.settlements_id = settlements_id;
		this.users_id = users_id;
		this.confirm = confirm;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getSettlements_id() {
		return settlements_id;
	}

	public void setSettlements_id(String settlements_id) {
		this.settlements_id = settlements_id;
	}

	public String getUsers_id() {
		return users_id;
	}

	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
