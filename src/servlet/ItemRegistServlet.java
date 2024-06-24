package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import dao.TaskDAO;
import model.Houses;
import model.Items;
import model.Task_Details;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();

		TaskDAO taskDao = new TaskDAO();
		List<Task_Details> task_list = taskDao.list(houses_id);

		if(task_list != null) {
			System.out.println("task_listがnullでない");
		}else {
			System.out.println("task_listがnullである");
		}

		ItemDAO itemDao = new ItemDAO();
		List<Items> item_list = itemDao.list(houses_id);
		System.out.println("Items List: " + item_list);

		request.setAttribute("itemsList", item_list);
		request.setAttribute("taskDetailsList", task_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String item_name = request.getParameter("item_name");
		int task_details_id = Integer.parseInt(request.getParameter("task_details_id"));
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();



		//在庫品の登録処理
		ItemDAO itemDao = new ItemDAO();

		if(itemDao.itemInsert(new Items(0,item_name, 0, task_details_id , houses_id))) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
		dispatcher.forward(request, response);
	}

}
