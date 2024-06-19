package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Items;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemListServlet

@@ -30,21 +27,16 @@ public class ItemListServlet extends HttpServlet {
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//表示処理を行う
		ItemDAO itemDAO= new ItemDAO();
		if (itemDAO.selectAll(new Items(0,null,0,0,houses_id))) {	// 表示成功
			System.out.println("表示成功");
		}
		else {												// 表示失敗
			System.out.println("表示失敗");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

