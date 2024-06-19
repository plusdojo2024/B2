package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Boards;

public class BoardDAO {
	// 書き込み情報登録
	public boolean insert(Boards board) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO BOARDS VALUES (NULL, ?, ?, ?, NULL)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (board.getUsers_id() != null && !board.getUsers_id().equals("")) {
				pStmt.setString(1, board.getUsers_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (board.getTittle() != null && !board.getTittle().equals("")) {
				pStmt.setString(2, board.getTittle());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (board.getMessage() != null && !board.getMessage().equals("")) {
				pStmt.setString(3, board.getMessage());
			}
			else {
				pStmt.setString(3, "（未設定）");
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
	// 書き込めたらtrueを返す
	public boolean isLoginOK(Boards board) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM BOARDS WHERE users_id = ? AND tittle = ? AND message = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, board.getUsers_id());
			pStmt.setString(2,board.getTittle());
			pStmt.setString(3,board.getMessage());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//ユーザーの書き込みが完了しているかをチェックする？
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
				}
		}
		// 結果を返す
		return loginResult;
	}

	//なんの処理かはわからないけどセレクト
	public Boards select(Boards board) {
		Connection conn = null;
		Boards board_data;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM BOARDS WHERE users_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (board.getEmail() != null) {
				pStmt.setString(1, board.getUsers_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			board_data = new Boards(
					rs.getInt("ID"),
					rs.getString("users_name"),
					rs.getString("tattle"),
					rs.getString("message"),
					rs.getInt("post_date")
					);

		}
		catch (SQLException e) {
			e.printStackTrace();
			board_data = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			board_data = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					board_data = null;
				}
			}
		}
		// 結果を返す
		return board_data;
	}

}
