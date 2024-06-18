package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String email = request.getParameter("email");
				String password = request.getParameter("password");


	//ログイン処理を行う
	UserDAO userDao = new UserDAO();
	if (userDao.isLoginOK(new Users(0, null, email, password, 0))) {
		Users user_data = new Users(0, null, email, password, 0);
		Users userResult = userDao.select(user_data);

		//セッションスコープにUsersのインスタンスを格納する
		HttpSession session = request.getSession();
		session.setAttribute("Users", userResult);
		// indexサーブレットにリダイレクトする
		response.sendRedirect("/B2/indexServlet");
	}

	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
	dispatcher.forward(request, response);
	}
}


