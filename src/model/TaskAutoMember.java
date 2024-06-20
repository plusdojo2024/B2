// メンバークラス
// メンバーの名前、割り当て家事（アレイリスト型）、総労力をフィールドに持ち、
// コンストラクタとゲッターセッターをもつ。

package model;

import java.util.ArrayList;
import java.util.List;

public class TaskAutoMember {
	String name;
	int total_effort;
	List<String> assignedList;

	// コンストラクタ
	public TaskAutoMember(String name) {
		this.name = name;
		this.total_effort = 0;
		this.assignedList = new ArrayList<>();
	}

	// 総労力と割り当て家事をsetするやつ
	public void setData(int effort, String task_name) {
		this.total_effort += effort;
		assignedList.add(task_name);
	}

	// getter
	public String getName() {
		return name;
	}


	public int getTotal_effort() {
		return total_effort;
	}


	public List<String> getAssignedList() {
		return assignedList;
	}
}
