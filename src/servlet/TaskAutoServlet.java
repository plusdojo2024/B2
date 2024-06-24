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

import dao.TaskDAO;
import dao.UserDAO;
import model.Houses;
import model.TaskAutoHp;
import model.TaskAutoInfo;
import model.TaskAutoMember;
import model.Task_Details;
import model.Users;

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
		Random rdm = new Random();

		// メンバーリスト
		// リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();

		// UserDAOのlistメソッドつかう
		UserDAO userDao = new UserDAO();
		List<Users> user_list = userDao.list(houses_id);

		// 家事リスト
		// TaskDAOのlistメソッドを使う
		TaskDAO taskDao = new TaskDAO();
		List<Task_Details> task_list = taskDao.list(houses_id);

		// 配列を用意
		List<TaskAutoMember> eachTask = new ArrayList<>();
		List<TaskAutoInfo> taskData = new ArrayList<>();

		// user_listのuser_nameを用いたインスタンス生成
		for (Users name: user_list) {
			eachTask.add(new TaskAutoMember(name.getUser_name()));
		}

		// taskバージョン
		// TaskAutoInfo型配列に家事名、頻度、労力が格納されている状態（曜日と担当者はnull）
		for (Task_Details task: task_list) {
			taskData.add(new TaskAutoInfo(task.getTask_name(), task.getFrequency(), task.getEffort(), null, null));
		}

		// TaskAutoList型の配列に、家事×頻度分の家事名を格納した状態
		// これって最初曜日と担当者はnullでいいのかしら
		List<TaskAutoInfo> taskList = new ArrayList<>();
		int i;
		for (i =0; i < taskData.size(); i++) {
			for (int k = 0; k < taskData.get(i).getFrequency(); k++) {
				taskList.add(new TaskAutoInfo(taskData.get(i).getTask_name(),
						taskData.get(i).getFrequency(), taskData.get(i).getEffort(), null, null ));
			}
		}

		// 各TaskAutoInfoモデルに曜日をランダムで格納
		for (i =0; i < taskList.size(); i++) {
			// String型のdayにランダムで曜日を格納
			String day = String.valueOf(rdm.nextInt(7)); // 0=月、1=火、2=水、3=木、4=金、5=土、6=日
			// ここで同じ数でてないかチェックしたい！！
			// おそらくString型にキャストしたから.equals
			// だがしかし、やりかたがわからない
			// もしくは、値がnullだったら格納できるみたいな感じ？
			for (TaskAutoInfo e: taskList) {
				e.setDay(day);
			}
		}

		// 担当者の初期体力を設定する
		int total_effort = 0;
		int hp = 0;
		for (i =0; i < taskData.size(); i++) {
			total_effort += taskData.get(i).getFrequency() * taskData.get(i).getEffort();
		}
		hp = total_effort / eachTask.size();

		// TaskAutoHp型配列に名前と計算したhpを格納
		List<TaskAutoHp> userHp = new ArrayList<>();
		userHp.add(new TaskAutoHp(eachTask.get(i).getUser_name(), hp));


		// 担当者を決める
		TaskAutoHp hpConfirm = new TaskAutoHp();
		for (i =0; i < taskList.size(); i++) { // taskListの長さ分繰り返す
			if (userHp.get(i).getHp() > 0) {
				int user_num = rdm.nextInt(eachTask.size()); // メンバーの人数分ランダムで数字を選択（上から順に番号を振ってある）
				// taskListの担当者に名前を格納
				for (TaskAutoInfo e: taskList) {
					e.setUser_name(eachTask.get(user_num).getUser_name());
				}

				// hpからeffortを引いて、再度hpを格納
				// getの後ろに乱数指定したけどこれでいいのかしら
				hpConfirm.setHp(userHp.get(user_num).getHp() - taskList.get(user_num).getEffort());
			}
		}



	}
}
