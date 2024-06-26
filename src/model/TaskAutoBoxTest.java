package model;
import java.util.ArrayList;
import java.util.Random;

import dao.TaskAutoListDAO;


public class TaskAutoBoxTest {
	public static void main(String[] args) {

		int houses_id = 1;




		//task_detailsテーブルでhouses_idが「1」のfrequencyの合計を計算するTaskAutoListDAOのメソッド
		TaskAutoListDAO talDAO = new TaskAutoListDAO();
		int array_num = talDAO.numArray(houses_id);

		//day,user_name,task_name,effortを入れるモデルをリスト化する
		ArrayList <TaskAutoBox> TaskAutoList = new ArrayList<>();
		 Random rand = new Random();

		for(int i=0;i<array_num;i++) {
			//day,user_name,task_name,effortを入れるモデルをインスタンス化
			TaskAutoBox tab = new TaskAutoBox();
			tab.setDay(rand.nextInt(7));
			TaskAutoList.add(tab);

		}

		//task_nameとfrequencyを取得してTaskAutoNameに格納するDAOのメソッドを実行する

		ArrayList<TaskNameFreqEffo> tnfeList = talDAO.namefreqeffo(houses_id);
		//tnfeListのTaskNameFreqEffo型のデータをすべて取ってくる
		//frequenceyの回数分task_nameをTaskAutoListに挿入
		int g_count=0;
		for(TaskNameFreqEffo tnfe :tnfeList) {

			int count = tnfe.getFrequency();
			for (int i= g_count; i< count+g_count; i++) {
				TaskAutoList.get(i).setTask_name(tnfe.getTask_name());
			}
			g_count += count;
		}

		//HPを計算
		int hp = talDAO.calHp(houses_id);
		//hpをぴったりにしてしまうと端数が出たとき困るので５を足している
		hp += 5;
		//users_tableからhouses_idから住んでいる人一覧を取得し、
		//UserHpモデルのuser_nameにいれる、HPに変数hpを入れたリストを作成。
		ArrayList<UserHp> uh_list=talDAO.namehp(houses_id,hp);




		//TaskAutoListにある分すべてが対象
		//入っている、TaskAutoBox型のtask_nameと
		//task_detailsテーブルにあるtask_nameを検索して
		//effortの数値を取得。

		//家に入っている人数を計算
		int uhlength = uh_list.size();
		 Random randUser = new Random();


		int task_effort=0;
		for(TaskAutoBox tab :TaskAutoList) {
			//やる家事の疲労度を検索するDAOメソッド
			task_effort = talDAO.searchEffort(tab.getTask_name());


			//その人のhpと家事の疲労度を比較。余裕があればその人が家事をやる
			while(true) {

				//人数をもとにランダムな整数を作成。家事をする人を選択
				String workperson = uh_list.get(randUser.nextInt(uhlength)).getUser_name();
				//その人の現在のhpを取ってくるDAO
				int workperson_hp = 0;
				int workperson_number = 0;
				for(int i=0; i<uhlength; i++) {
					if(uh_list.get(i).getUser_name()== workperson) {
						workperson_hp = uh_list.get(i).getHp();
						workperson_number = i;
					}
				}
				if(workperson_hp > task_effort) {
					tab.setUser_name(workperson);
					int now_hp = uh_list.get(workperson_number).getHp()-task_effort;
					 uh_list.get(workperson_number).setHp(now_hp);
					 break;
				}

			}



		}



		System.out.println("hello");
	}
}
