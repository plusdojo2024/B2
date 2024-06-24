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
 * Servlet implementation class SettlementServlet
 */
@WebServlet("/SettlementServlet")
public class SettlementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettlementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String receipt_name = request.getParameter("receipt_name");
		int receipt_amount = Integer.parseInt(request.getParameter("receipt_amount"));
		String description = request.getParameter("description");
		String expense_date = request.getParameter("expense_date");
		String settlement_date = request.getParameter("settlement_date");

		HttpSession session = request.getSession();
		 //セッションスコープでhouses_idをとってくる
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();
		// セッションスコープでusers_idをとってくる
		Users users = (Users)session.getAttribute("Users");

		// レシートの一覧を表示
		ExpenseDAO eDao = new ExpenseDAO();
		List<Settlements> ReceiptList= eDao.list(houses_id);
		// レシート登録・精算画面（settlement.jsp）にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//レシートの登録情報をテーブルに格納する（日付等は自動）
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String receipt_name = request.getParameter("receipt_name");
		int receipt_amount = Integer.parseInt(request.getParameter("receipt_amount"));
		String description = request.getParameter("description");
		String expense_date = request.getParameter("expense_date");
		int settlement_id = Integer.parseInt(request.getParameter("settlement_id"));
		String settlement_date = request.getParameter("settlement_date");

		HttpSession session = request.getSession();
		// セッションスコープでhouses_idをとってくる
		Houses houses = (Houses)session.getAttribute("Houses");
		int houses_id = houses.getID();
		// セッションスコープでusers_idをとってくる
		Users users = (Users)session.getAttribute("Users");

		// レシートを精算済みにする＋精算日の追加
		ExpenseDAO expenseDao = new ExpenseDAO();
		if (request.getParameter("submit").equals("精算")) {
			if (expenseDao.update(houses_id, settlement_id, settlement_date)) {
				System.out.println("精算成功！");
			}
			else {
				System.out.println("精算失敗！");
			}
		}

		// レシートを承認済みにする（実装検討中）
		if (request.getParameter("submit").equals("承認")) {
			if (expenseDao.update(houses_id, settlement_id)) {
				System.out.println("承認成功！");
			}
			else {
				System.out.println("承認失敗！");
			}
		}

		// レシートの削除
		if (request.getParameter("submit").equals("削除")) {
			if (expenseDao.delete(houses_id, settlement_id)) {
				System.out.println("削除成功！");
			}
			else {
				System.out.println("削除失敗！");
			}
		}


		// 結果フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
		dispatcher.forward(request, response);



		//if (expenseDao.setClear(ID)){
			// settlementサーブレットにリダイレクトする
			//response.sendRedirect("/B2/SettlementServlet");
		//}
		//else {
		//	System.out.println("精算失敗！");
		//}
	}

}
