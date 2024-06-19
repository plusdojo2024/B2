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
			String sql = "INSERT INTO BOARDS VALUES (0, ?, ?, ?, ?, 0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (board.getUser_name() != null && !board.getUser_name().equals("")) {
				pStmt.setString(1, board.getUser_name());
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
				pStmt.setString(4, board.getPost_date());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
				pStmt.setInt(5, board.getHouses_id());

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


	//全件返すセレクトのやつ
	public Boards selectAll(int houses_id) {
		Connection conn = null;
		Boards board_data;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM BOARDS WHERE houses_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
				pStmt.setInt(1, board_data.getHouses_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			board_data = new Boards(
					rs.getInt("ID"),
					rs.getString("users_name"),
					rs.getString("tittle"),
					rs.getString("message"),
					rs.getString("post_date"),
					rs.getInt("house_id")
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
