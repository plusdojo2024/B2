package model;

import java.io.Serializable;

public class Notifications implements Serializable {
	private int ID; //ID
	private int users_id; //ユーザーid
	private String message; //通知内容
	private String notification_date; //通知日
	private boolean read; //既読の有無

	public Notifications() {

	}

	public Notifications(int ID, int users_id, String message, String notification_date, boolean read) {
		super();
		this.ID = ID;
		this.users_id = users_id;
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

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNotification_date() {
		return notification_date;
	}

	public void setNotification_date(String notification_date) {
		this.notification_date = notification_date;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}



}
