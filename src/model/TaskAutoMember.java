// メンバークラス
// メンバーの名前、割り当て家事（アレイリスト型）、総労力をフィールドに持ち、
// コンストラクタとゲッターセッターをもつ。

package model;

import java.util.ArrayList;
import java.util.List;

public class TaskAutoMember {
	String user_name;
	int total_effort;
	List<String> assignedList;

	// コンストラクタ
	public TaskAutoMember(String user_name) {
		this.user_name = user_name;
		this.total_effort = 0;
		this.assignedList = new ArrayList<>();
	}

	// 総労力と割り当て家事をsetするやつ
	public void setData(int effort, String task_name) {
		this.total_effort += effort;
		assignedList.add(task_name);
	}

	// getter
	public String getUser_name() {
		return user_name;
	}


	public int getTotal_effort() {
		return total_effort;
	}


	public List<String> getAssignedList() {
		return assignedList;
	}
}
