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

import dao.ExpenseDAO;
import model.Houses;
import model.Settlements;
import model.Users;


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
		HttpSession session = request.getSession();
		 //セッションスコープでhouses_idをとってくる
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();
		// レシートの一覧を表示
		ExpenseDAO eDao = new ExpenseDAO();
		List<Settlements> ReceiptList= eDao.list(houses_id);
		request.setAttribute("receiptList",ReceiptList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
		dispatcher.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//リクエストパラメータを取得
	request.setCharacterEncoding("UTF-8");
	String receipt_name = request.getParameter("receipt_name");
	int receipt_amount = Integer.parseInt(request.getParameter("receipt_amount"));
	String description = request.getParameter("description");

	HttpSession session = request.getSession();
	 //セッションスコープでhouses_idをとってくる
	Houses houses = (Houses)session.getAttribute("Houses");
	int houses_id = houses.getID();
	// セッションスコープでusers_idをとってくる
	Users users = (Users)session.getAttribute("Users");
	int users_id = users.getID();


	//レシート登録処理
		ExpenseDAO eDao = new ExpenseDAO();
		// settlementテーブルの数に合わす
		if (eDao.insert(new Settlements(0, users_id, receipt_name, receipt_amount,
				description, null, false, false, null, houses_id))) {
			System.out.println("登録成功！");
			response.sendRedirect("/B2/SettlementServlet");

		}
		else {
			System.out.println("登録失敗！");
			// 結果フォワード

			// レシートの一覧を表示
			List<Settlements> ReceiptList= eDao.list(houses_id);

			request.setAttribute("receiptList",ReceiptList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
			dispatcher.forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	}
}
