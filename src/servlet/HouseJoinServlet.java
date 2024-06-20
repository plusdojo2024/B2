package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HouseDAO;
import model.Houses;


/**
 * Servlet implementation class HouseJoinServlet
 */
@WebServlet("/HouseJoinServlet")
public class HouseJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/house_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		// リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String house_hash = request.getParameter("house_hash");
		String password = request.getParameter("password");

		// ログイン処理を行う（参加）
		HouseDAO houseDao = new HouseDAO();
		if(houseDao.isLoginOK(new Houses(0, house_hash, password, null))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HouseDAO hDao = new HouseDAO();
			Houses houses = hDao.selectByhash(house_hash);
			session.setAttribute("Houses", houses);


			// indexサーブレットにリダイレクトする
			response.sendRedirect("/B2/IndexServlet");
		}
		else {		//ログイン失敗
			System.out.println("参加に失敗しました。IDかパスワードに間違いがあります。");
			// 結果ページにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/house_login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
