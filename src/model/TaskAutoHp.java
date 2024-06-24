package model;

public class TaskAutoHp {
	String user_name;
	int hp;
	int effort;

	// コンストラクタ
	public TaskAutoHp(String user_name, int hp) {
		super();
		this.user_name = user_name;
		this.hp = hp;
		this.effort = 0;
	}

	public TaskAutoHp() {

	}


	// hpを引いていく
	public void updateHp(String user_name, int effort) {
		hp -= effort;
	}

	public String getUser_name() {
		return user_name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getEffort() {
		return effort;
	}



}
