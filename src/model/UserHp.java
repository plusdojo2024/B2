package model;

import java.io.Serializable;

public class UserHp implements Serializable{

	private String user_name;
	private int hp;

	public UserHp() {

	}


	public UserHp(String user_name, int hp) {
		super();
		this.user_name = user_name;
		this.hp = hp;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}




}
