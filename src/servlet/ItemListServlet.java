package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}


	//表示処理を行う
		ItemDAO = new ItemDAO();
		if (ItemDao.insert(new ItemDAO(item_name,status))) {	// 表示成功
			request.setAttribute("result",
			new Result("表示成功！", "/B2/ItemListServlet"));
		}
		else {												// 表示失敗
			request.setAttribute("result",
			new Result("表示失敗！", , "/B2/ItemListServlet"));
		}
	}

}
