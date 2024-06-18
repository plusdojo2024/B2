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
 */
@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/task_list.jsp");
		dispatcher.forward(request, response);

	//セッションスコープに格納されているhouses_idを取得する
		Houses house_data = (Houses)session.getAttribute("house_hash");
		int houses_id = house_data.getHouse_hash();

	//表示処理を行う
		ItemDAO itemDAO= new ItemDAO();
		if (itemDAO.selectAll(new Items(0,null,0,0,houses_id))) {	// 表示成功
			System.out.println("表示成功");
		}
		else {												// 表示失敗
			System.out.println("表示失敗");
		}
	}
}
}
