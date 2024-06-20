package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Settlements;

// テーブルはSettlementにExpensesを合体させた
// なのでテーブルの名前はSettlement
// DAOの名前は変えるとエラーになるからそのままExpensesDAOのまま
public class ExpenseDAO {

	// レシート登録
	public boolean insert(Settlements settlement) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO SETTLEMENTS VALUES (NULL, ?, ?, ?, ?, FALSE, FALSE, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// ユーザーid
			pStmt.setInt(1, settlement.getUsers_id());
			// 支出の種類
			if (settlement.getReceipt_name() != null && !settlement.getReceipt_name().equals("")) {
				pStmt.setString(2, settlement.getReceipt_name());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			// 金額
				pStmt.setInt(3, settlement.getReceipt_amount());
			// 詳細
			if (settlement.getDescription() != null && !settlement.getDescription().equals("")) {
				pStmt.setString(4, settlement.getDescription());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
			// 支払日
			pStmt.setString(5, settlement.get());

			// 精算済みフラグ　初期値FALSE
			// 承認済みフラグ　初期値FALSE

			// 精算日
			pStmt.setString(6, settlement.get());

			// ハウスID
			pStmt.setInt(7, settlement.getHouses_id());

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
