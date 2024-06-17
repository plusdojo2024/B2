package model;

import java.io.Serializable;

public class Houses implements Serializable {
	private int ID; //ID
	private String house_hash; //家番号
	private String password; //パスワード
	private String house_name; //名前

	public Houses() {
	}

	public Houses(int ID, String house_hash, String password, String house_name) {
		super();
		this.ID = ID;
		this.house_hash = house_hash;
		this.password = password;
		this.house_name = house_name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getHouse_hash() {
		return house_hash;
	}

	public void setHouse_hash(String house_hash) {
		this.house_hash = house_hash;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHouse_name() {
		return house_name;
	}

	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}

}
