package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExpenseDAO;
import model.Expenses;
import model.Houses;

/**
 * Servlet implementation class ReceiptServlet
 */
@WebServlet("/ReceiptServlet")
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//リクエストパラメータを取得
	request.setCharacterEncoding("UTF-8");
	String receipt_name = request.getParameter("receipt_name");
	int receipt_amount = Integer.parseInt(request.getParameter("receipt_amount"));
	String description = request.getParameter("description");
	int expense_date = Integer.parseInt(request.getParameter("expense_date"));

	// セッションスコープからhouses_idをとってくる
	Houses house_data = (Houses)session.getAttribute("house_hash");
	String houses_id = house_data.getHouse_hash();

	//レシート登録処理
		ExpenseDAO eDao = new ExpenseDAO();

		if (eDao.insert(new Expenses(0, receipt_name, receipt_amount, description, expense_date, house_id))) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
		dispatcher.forward(request, response);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	}
}
