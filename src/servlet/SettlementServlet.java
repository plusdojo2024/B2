package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExpenseDAO;
import model.Settlements;

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

    //レシートの登録画面を出力
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		// リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		// どこまで必要なのかわからない
		// Settlements.javaから持ってきたやつら
//		int ID = Integer.parseInt(request.getParameter("ID"));
		int user_id = 1;

		String receipt_name =request,getParameter("receipt_name"); //支出の種類
		int receipt_amount; //金額
		String description; //詳
		Date now_date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		String now_date_string = dateformat.format(now_date);
		int house_id =1;
		Settlements settlement = new Settlements(0,user_id,receipt_name,receipt_amount,
				description,
				now_date_string,false,false,"",house_id);


		//精算ボタンクリックされたらExpenseDAOを精算済みにする
		ExpenseDAO expenseDao = new ExpenseDAO();


		expenseDao.insert(settlement);


		if (expenseDao.setClear(ID)){
			// settlementサーブレットにリダイレクトする
			response.sendRedirect("/B2/SettlementServlet");
		}
		else {
			System.out.println("精算失敗！");
		}
	}

}
