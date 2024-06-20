// メインメソッド
// 家事の分担に関するプログラム。家事クラスとメンバークラスのインスタンスを用いて処理を行う。
// 例えば、データベースからとってきた家事の名前と頻度と労力を、このプログラムの中で使いたいなら、
// new 家事クラス(名前、頻度、労力)としてインスタンスを作る。
// これらのインスタンスをメインメソッドの配列に入れておく。メンバークラスも同様にする。

package model;

import java.util.Random;

public class TaskAuto {
	public static void main(String[] args) {
	Random rdm = new Random();
	TaskAutoMember AutoMember = new TaskAutoMember();
	TaskAutoInfo AutoInfo = new TaskAutoInfo();
	String [] AutoMemberTable; // メンバーを入れる配列
	String [] AutoInfoTable; // 家事詳細を入れる配列
	}




	// 曜日を確定するメソッド → メインメソッド
	public void date_confirm() {
		// 格納するための配列task
		int [] task = new int[AutoInfo.frequency];
		// 頻度数だけ繰り返す
		for (int i = 0; i < AutoInfo.frequency; i++) {
			int num = rdm.nextInt(7);
			// ここで同じ数でてないかチェックしたい！！

			// task配列にnumを格納
			task[i] = num;
		}
	}
}
