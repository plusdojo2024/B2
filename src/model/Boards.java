package model;

import java.io.Serializable;

public class Boards implements Serializable {
	private int ID; //ID
	private String user_name; //ユーザー名
	private String title; //タイトル
	private String message; //内容
	private int post_date; //投稿日

	public Boards() {

	}

	public Boards(int ID, String user_name, String title, String message, int post_date) {
		super();
		this.ID = ID;
		this.user_name = user_name;
		this.title = title;
		this.message = message;
		this.post_date = post_date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPost_date() {
		return post_date;
	}

	public void setPost_date(int post_date) {
		this.post_date = post_date;
	}

}
