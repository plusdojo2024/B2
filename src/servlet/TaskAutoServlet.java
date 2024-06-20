package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		// 一人あたりのHPを計算する






		// 上のやつのtaskバージョンをつくる☑（DAOもいじる☑）
		// 配列二つ（メンバーと家事）arraylist☑
		// メンバー：user_listの名前（user_name）を用いたインスタンス(for文でlength文)☑
		// タスクバージョン☑
		// addで追加☑
		// 個人の合計労力をgetterで取得して☑、比較してsetDataで割り当て家事・労力をいれる
		// 労力が同じ場合は考える
	}

}
