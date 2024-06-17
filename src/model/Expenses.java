package model;

import java.io.Serializable;

public class Expenses implements Serializable{
	private int ID; //ID
	private String expense_type; //支出の種類
	private int amount; //金額
	private String description; //詳細
	private int expense_date; //支払日

	public Expenses() {

	}


	public Expenses(int ID, String expense_type, int amount, String description, int expense_date) {
		super();
		this.ID = ID;
		this.expense_type = expense_type;
		this.amount = amount;
		this.description = description;
		this.expense_date = expense_date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getExpense_type() {
		return expense_type;
	}

	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
