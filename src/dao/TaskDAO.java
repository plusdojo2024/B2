package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Task_Details;

public class TaskDAO {
	//家事登録
	public boolean insert(Task_Details task_detail) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO TASK_DETAILS VALUES (0, ?, ?, ?, ?, 0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// 家事名
			if (task_detail.getTask_name() != null && !task_detail.getTask_name().equals("")) {
				pStmt.setString(1, task_detail.getTask_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			// 説明
			if (task_detail.getDescription() != null && !task_detail.getDescription().equals("")) {
				pStmt.setString(2, task_detail.getDescription());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			// 労力
			pStmt.setInt(3, task_detail.getEffort());

			// 頻度
			pStmt.setInt(4, task_detail.getFrequency());


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


