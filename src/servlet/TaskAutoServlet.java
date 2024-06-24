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
		for (Task_Details task: task_list) {
			taskData.add(new TaskAutoInfo(task.getTask_name(), task.getFrequency(), task.getEffort()));
		}

		// 家事名と曜日が格納されたArrayListの二次元配列をつくりたい

		// 家事×頻度分の家事名を取得、Listに格納
		ArrayList<String> taskName = new ArrayList<>();
		int i;
		for (i =0; i < taskData.size(); i++) {
			for (int k = 0; k < taskData.get(i).getFrequency(); k++) {
				taskName.add(taskData.get(i).getTask_name()));
			}
		}

		// 曜日を確定する
		Random rdm = new Random();
		ArrayList<String> task = new ArrayList<>();
		for (i =0; i < taskName.size(); i++) {
			String num = String.valueOf(rdm.nextInt(7)); // 0=月、1=火、2=水、3=木、4=金、5=土、6=日
			// ここで同じ数でてないかチェックしたい！！
			// おそらくString型にキャストしたから.equals
			// だがしかし、やりかたがわからない
			// もしくは、値がnullだったら格納できるみたいな感じ？
			task.add(num);
		}


		// 二次元配列
		// これで二次元配列にきちんと格納できているのか
		ArrayList<ArrayList<String>> assignLists = new ArrayList<ArrayList<String>>();
		for (i =0; i < taskName.size(); i++) {
			ArrayList<String> assignList = new ArrayList<>();
			for (i =0; i < task.size(); i++) {
				assignList.add(task);
			}
			assignLists.add(taskName);
		}











		// 上のやつのtaskバージョンをつくる☑（DAOもいじる☑）
		// 配列二つ（メンバーと家事）arraylist☑
		// メンバー：user_listの名前（user_name）を用いたインスタンス(for文でlength文)☑
		// タスクバージョン☑
		// addで追加☑
		// 個人の合計労力をgetterで取得して☑、比較してsetDataで割り当て家事・労力をいれる
		// 労力が同じ場合は考える
	}

}
