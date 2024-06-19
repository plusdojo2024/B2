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
 * Servlet implementation class HouseRegistServlet
 */
@WebServlet("/HouseRegistServlet")
public class HouseRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseRegistServlet() {
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
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		// 改造（ここから）
		String house_name = request.getParameter("house_name");
		String password = request.getParameter("password");
		String house_hash= "";
		// 改造（ここまで）
		// SHA-256でハッシュ化(house_nameとcurrentDateTimeを連結文字列にした)
		String hashData = house_name+currentDateTime;
		String hash;
		MessageDigest sha256;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			byte[] sha256_result = sha256.digest(hashData.getBytes());
			hash = Base64.getEncoder().encodeToString(sha256_result);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

		// 登録処理を行う
		HouseDAO hDao = new HouseDAO();

		;

		if (houseDao.insert(new Houses(0,house_name, password,""))) {
			System.out.println("登録成功!");
		}
		else {
			System.out.println("登録失敗!");
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/house_login.jsp");
		dispatcher.forward(request, response);
	}

}
