package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Items;

/**
 * Servlet implementation class ItemUpdateDeleteServlet
 */
@WebServlet("/ItemUpdateDeleteServlet")
public class ItemUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdateDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		int ID = Integer.parseInt(request.getParameter("ID"));
		String item_name = request.getParameter("item_name");
		int task_details_id = Integer.parseInt(request.getParameter("task_details_id"));
		int status = Integer.parseInt(request.getParameter("status"));

		ItemDAO itemDao = new ItemDAO();

		//在庫品の更新処理
		if (request.getParameter("submit").equals("更新")) {

			if(itemDao.update(new Items(0,item_name, 0, task_details_id , 0))) {
				System.out.println("更新成功！");
			}
			else {
				System.out.println("更新失敗！");
			}
		}
				else {
					if(itemDao.delete(ID)) {
						System.out.println("削除成功！");
					}
					else {
						System.out.println("削除失敗！");
					}
				}

		// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/house_login.jsp");
			dispatcher.forward(request, response);
			}
	}


