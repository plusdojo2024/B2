package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UserDAO {
	// ユーザー登録
	public boolean insert(Users user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO USERS VALUES (NULL, ?, ?, ?, NULL)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user.getUser_name() != null && !user.getUser_name().equals("")) {
				pStmt.setString(1, user.getUser_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (user.getEmail() != null && !user.getEmail().equals("")) {
				pStmt.setString(2, user.getEmail());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (user.getPassword() != null && !user.getPassword().equals("")) {
				pStmt.setString(3, user.getPassword());
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
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users user) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM USERS WHERE email = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getEmail());
			pStmt.setString(2,user.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//メールアドレスとパスワードが一致するユーザーがいたかどうかをチェックする
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

	//emailを返す
	public Users select(Users user) {
		Connection conn = null;
		Users user_data;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM USERS WHERE email = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (user.getEmail() != null) {
				pStmt.setString(1, user.getEmail());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			user_data = new Users(
					rs.getInt("ID"),
					rs.getString("user_name"),
					rs.getString("email"),
					rs.getString("password"),
					rs.getInt("house_id")
					);

		}
		catch (SQLException e) {
			e.printStackTrace();
			user_data = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			user_data = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					user_data = null;
				}
			}
		}
		// 結果を返す
		return user_data;
	}

}