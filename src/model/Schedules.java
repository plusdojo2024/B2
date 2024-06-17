package model;

import java.io.Serializable;

public class Schedules implements Serializable {
	private int ID; //ID
	private int users_id; //ユーザーID
	private String title; //タイトル
	private String text; //詳細
	private int date; //日時

	public Schedules(int ID, int users_id, String title, String text, int date) {
		super();
		this.ID = ID;
		this.users_id = users_id;
		this.title = title;
		this.text = text;
		this.date = date;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}



}
