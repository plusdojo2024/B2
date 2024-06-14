package servlet;

import java.io.IOException;
<<<<<<< HEAD
=======

import javax.servlet.RequestDispatcher;
>>>>>>> 24065dab9841d06a785c061173e71dc0ba2cdcc6
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
<<<<<<< HEAD
<<<<<<<< HEAD:src/servlet/HouseJoinServlet.java
=======
>>>>>>> 24065dab9841d06a785c061173e71dc0ba2cdcc6
 * Servlet implementation class HouseJoinServlet
 */
@WebServlet("/HouseJoinServlet")
public class HouseJoinServlet extends HttpServlet {
<<<<<<< HEAD
========
 * Servlet implementation class HouseRegistServlet
 */
@WebServlet("/HouseRegistServlet")
public class HouseRegistServlet extends HttpServlet {
>>>>>>>> 24065dab9841d06a785c061173e71dc0ba2cdcc6:src/servlet/HouseRegistServlet.java
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
<<<<<<<< HEAD:src/servlet/HouseJoinServlet.java
    public HouseJoinServlet() {
========
    public HouseRegistServlet() {
>>>>>>>> 24065dab9841d06a785c061173e71dc0ba2cdcc6:src/servlet/HouseRegistServlet.java
=======
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseJoinServlet() {
>>>>>>> 24065dab9841d06a785c061173e71dc0ba2cdcc6
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/house_login.jsp");
		dispatcher.forward(request, response);
>>>>>>> 24065dab9841d06a785c061173e71dc0ba2cdcc6
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
