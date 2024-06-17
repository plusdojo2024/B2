package model;

import java.io.Serializable;


public class Settlements implements Serializable{
	private int ID; //ID
	private int users_id; //ユーザーID
	private int expenses_id; //支出詳細ID
	private boolean settlement_finish; //精算済みフラグ
	private boolean settlement_approval; //承認済みフラグ
	private int settlement_date; //精算日

	public Settlements() {

	}

	public Settlements(int ID, int users_id, int expenses_id, boolean settlement_finish, boolean settlement_approval,
			int settlement_date) {
		super();
		this.ID = ID;
		this.users_id = users_id;
		this.expenses_id = expenses_id;
		this.settlement_finish = settlement_finish;
		this.settlement_approval = settlement_approval;
		this.settlement_date = settlement_date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getExpenses_id() {
		return expenses_id;
	}

	public void setExpenses_id(int expenses_id) {
		this.expenses_id = expenses_id;
	}

	public boolean isSettlement_finish() {
		return settlement_finish;
	}

	public void setSettlement_finish(boolean settlement_finish) {
		this.settlement_finish = settlement_finish;
	}

	public boolean isSettlement_approval() {
		return settlement_approval;
	}

	public void setSettlement_approval(boolean settlement_approval) {
		this.settlement_approval = settlement_approval;
	}

	public int getSettlement_date() {
		return settlement_date;
	}

	public void setSettlement_date(int settlement_date) {
		this.settlement_date = settlement_date;
	}




}
