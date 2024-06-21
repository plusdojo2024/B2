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
import dao.UserDAO;
import model.Houses;
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
		HttpSession session = request.getSession();
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");


	//ログイン処理を行う
	UserDAO userDao = new UserDAO();
	HouseDAO houseDao = new HouseDAO();
	if (userDao.isLoginOK(new Users(0, null, email, password, 0))) {

		Integer houses_id = userDao.houseExist(email);

		//既に参加している家があるかどうかで遷移ページを変える
		if(houses_id != null) {
			Houses house = houseDao.selectById(houses_id);
			session.setAttribute("Houses", house);

			Users userResult = userDao.selectLoginUser(email);
			session.setAttribute("Users", userResult);
			if(userResult != null) {
				System.out.println("nullでない");
			}else {
				System.out.println("nullである");
			}
			//リダイレクト
			response.sendRedirect("/B2/IndexServlet");
		}else {

			Users userResult = userDao.selectLoginUser2(email);
			session.setAttribute("Users", userResult);

			if(userResult != null) {
				System.out.println("nullでない");
			}else {
				System.out.println("nullである");
			}

			response.sendRedirect("/B2/HouseRegistServlet");
		}

	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
		dispatcher.forward(request, response);
		System.out.println("ログイン失敗");
	}
	}
}


