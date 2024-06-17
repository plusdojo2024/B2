package model;

import java.io.Serializable;

public class Notifications implements Serializable {
	private int ID; //ID
	private int user_id; //ユーザーid
	private String message; //通知内容
	private int notification_date; //通知日
	private boolean read; //既読の有無

	public Notifications() {

	}

	public Notifications(int ID, int user_id, String message, int notification_date, boolean read) {
		super();
		this.ID = ID;
		this.user_id = user_id;
		this.message = message;
		this.notification_date = notification_date;
		this.read = read;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNotification_date() {
		return notification_date;
	}

	public void setNotification_date(int notification_date) {
		this.notification_date = notification_date;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

}
