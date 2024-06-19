package model;

import java.io.Serializable;

public class Users implements Serializable {
	private int ID; //ID
	private String user_name; //ユーザー名
	private String email; //メールアドレス
	private String password; //パスワード
	private int houses_id; //ハウスID

	public Users() {

	}

	public Users(int ID, String user_name, String email, String password, int houses_id) {
		super();
		this.ID = ID;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getHouses_id() {
		return houses_id;
	}

	public void setHouse_id(int houses_id) {
		this.houses_id = houses_id;
	}

}
