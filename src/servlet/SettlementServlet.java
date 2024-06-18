package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExpenseDAO;
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
		// レシート登録・精算画面（settlement.jsp）にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/settlement.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		// どこまで必要なのかわからない
		// Settlements.javaから持ってきたやつら
		int ID = Integer.parseInt(request.getParameter("ID"));


		//精算ボタンクリックされたらExpenseDAOを精算済みにする
		ExpenseDAO expenseDao = new ExpenseDAO();
		if (expenseDao.setClear(ID) {
			// settlementサーブレットにリダイレクトする
			response.sendRedirect("/B2/SettlementServlet");
		}
		else {
			System.out.println("精算失敗！");
		}
	}

}
