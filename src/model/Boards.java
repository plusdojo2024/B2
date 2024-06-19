package model;

import java.io.Serializable;

public class Boards implements Serializable {
	private int ID; //ID
	private String user_name; //ユーザー名
	private String title; //タイトル
	private String message; //内容
	private String post_date; //投稿日
	private int houses_id; //ハウスID

	public Boards() {

	}

	public Boards(int ID, String user_name, String title, String message, String post_date, int houses_id) {
		super();
		this.ID = ID;
		this.user_name = user_name;
		this.title = title;
		this.message = message;
		this.post_date = post_date;
		this.houses_id = houses_id;
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

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public int getHouses_id() {
		return houses_id;
	}

	public void setHouses_id(int houses_id) {
		this.houses_id = houses_id;
	}

}
