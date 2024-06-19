package model;

import java.io.Serializable;


public class Settlements implements Serializable{
	private int ID; //ID
	private int users_id; //ユーザーID
	private String receipt_name; //支出の種類
	private int receipt_amount; //金額
	private String description; //詳細
	private String expense_date; //支払日
	private boolean settlement_finish; //精算済みフラグ
	private boolean settlement_approval; //承認済みフラグ
	private String settlement_date; //精算日
	private int houses_id; // 家ID

	public Settlements() {

	}

	public Settlements(int ID, int users_id, String receipt_name, int receipt_amount, String description,
			String expense_date, boolean settlement_finish, boolean settlement_approval, String settlement_date,
			int houses_id) {
		super();
		this.ID = ID;
		this.users_id = users_id;
		this.receipt_name = receipt_name;
		this.receipt_amount = receipt_amount;
		this.description = description;
		this.expense_date = expense_date;
		this.settlement_finish = settlement_finish;
		this.settlement_approval = settlement_approval;
		this.settlement_date = settlement_date;
		this.houses_id = houses_id;
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

	public String getReceipt_name() {
		return receipt_name;
	}

	public void setReceipt_name(String receipt_name) {
		this.receipt_name = receipt_name;
	}

	public int getReceipt_amount() {
		return receipt_amount;
	}

	public void setReceipt_amount(int receipt_amount) {
		this.receipt_amount = receipt_amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpense_date() {
		return expense_date;
	}

	public void setExpense_date(String expense_date) {
		this.expense_date = expense_date;
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

	public String getSettlement_date() {
		return settlement_date;
	}

	public void setSettlement_date(String settlement_date) {
		this.settlement_date = settlement_date;
	}

	public int getHouses_id() {
		return houses_id;
	}

	public void setHouses_id(int houses_id) {
		this.houses_id = houses_id;
	}








}
