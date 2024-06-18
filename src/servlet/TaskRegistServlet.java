package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import model.Tasks;

/**
 * Servlet implementation class TaskRegistServlet
 */
@WebServlet("/TaskRegistServlet")
public class TaskRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/house_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		//フォームデータを取得
		String task_name = request.getParameter("task_name");
		int frequency = Integer.parseInt(request.getParameter("frequency"));
		int effort = Integer.parseInt(request.getParameter("effort"));

		// 登録処理を行う
		TaskDAO taskDao = new TaskDAO();

		if (taskDao.insert(new Tasks(0,task_name, "", effort, frequency,0))) {
			System.out.println("登録成功!");
		}
		else {
			System.out.println("登録失敗!");
		}

		request.setAttribute("task_name", task_name);

		   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/TaskRegistServlet.jsp");
			dispatcher.forward(request, response);
	}

}
