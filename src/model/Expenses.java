package model;

import java.io.Serializable;

public class Expenses implements Serializable{
	private int ID; //ID
	private String receipt_name; //支出の種類
	private int receipt_amount; //金額
	private String description; //詳細
	private int expense_date; //支払日

	public Expenses() {

	}


	public Expenses(int ID, String receipt_name, int receipt_amount, String description, int expense_date) {
		super();
		this.ID = ID;
		this.receipt_name = receipt_name;
		this.receipt_amount = receipt_amount;
		this.description = description;
		this.expense_date = expense_date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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

	public int getExpense_date() {
		return expense_date;
	}

	public void setExpense_date(int expense_date) {
		this.expense_date = expense_date;
	}
}
