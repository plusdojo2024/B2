package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskAutoListDAO;
import dao.TaskDAO;
import model.Houses;
import model.TaskAutoBox;
import model.TaskNameFreqEffo;
import model.Task_Details;
import model.UserHp;

/**
 * Servlet implementation class TaskAutoServlet
 */
@WebServlet("/TaskAutoServlet")
public class TaskAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskAutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_auto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();

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



		System.out.println(TaskAutoList);


	// あとは、TaskAutoListをスコープに入れて、中のTaskAutoBoxのdayと、task_nameに従って、user_nameを配置
		request.setAttribute("TaskAutoList", TaskAutoList);

		TaskDAO taskDao = new TaskDAO();
		List<Task_Details> task_list = taskDao.list(houses_id);
		request.setAttribute("task_list", task_list);

		for (TaskAutoBox e: TaskAutoList) {
			System.out.println(e.getDay());
			System.out.println(e.getUser_name());
			System.out.println(e.getTask_name());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_auto.jsp");
		dispatcher.forward(request, response);




	}

}
