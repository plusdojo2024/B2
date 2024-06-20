package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Boards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/board.jsp");
		dispatcher.forward(request, response);
    }


    // 投稿された日付を格納する 以下は日付が格納されているのでしょうか・・
    // Boardsのinsertからコピペして書きました
    public boolean insert(Boards board) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");
			// SQL文を準備する
			// この下のところがタイトルと内容と日付で記述すればいいってことでしょうか？ユーザー名前とhouses_id
			// はセッションスコープに格納されているからいらないってことですか?
			String sql = "INSERT INTO BOARDS VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (board.getTittle() != null && !board.getTittle().equals("")) {
				pStmt.setString(1, board.getTittle());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (board.getMessage() != null && !board.getMessage().equals("")) {
				pStmt.setString(2, board.getMessage());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (board.getPost_date() != null && !board.getPost_date().equals("")) {
				pStmt.setString(3, board.getPost_date());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	// 結果を返す
	return result;
}
}
