package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Expenses;


public class ExpenseDAO {
	// レシート登録
	public boolean insert(Expenses expense) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO EXPENSES VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (expense.getReceipt_name() != null && !expense.getReceipt_name().equals("")) {
				pStmt.setString(1, expense.getReceipt_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			// 金額
				pStmt.setInt(2, expense.getReceipt_amount());

			if (expense.getDescription() != null && !expense.getDescription().equals("")) {
				pStmt.setString(3, expense.getDescription());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			// 日付
				pStmt.setString(4, expense.getDescription());


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

	// レシートを精算済みにする
	public boolean setClear(Expenses expense) {
		Connection conn = null;
		boolean result = false;


		// 結果を返す
		return result;
	}




	// 未精算レシートを表示
	public Expenses UnpaidSelect(Expenses expense) {
		Connection conn = null;
		Expenses UnpaidReceipt = new Expenses();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する・SQL文を完成させる
			String sql = "SELECT * FROM Expenses WHERE settlement_finish = false ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			UnpaidReceipt = new Expenses(
					rs.getInt("ID"),
					rs.getString("receipt_name"),
					rs.getInt("receipt_amout"),
					rs.getString("description"),
					rs.getInt("expense_date")
					);

		}
		catch (SQLException e) {
			e.printStackTrace();
			UnpaidReceipt = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			UnpaidReceipt = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					UnpaidReceipt = null;
				}
			}
		}
		// 結果を返す
		return UnpaidReceipt;
	}

	// 精算済みレシートを表示
	public Expenses ClearedSelect(Expenses expense) {
		Connection conn = null;
		Expenses ClearedReceipt = new Expenses();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する・SQL文を完成させる
			String sql = "SELECT * FROM Expenses WHERE settlement_finish = true ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			ClearedReceipt = new Expenses(
					rs.getInt("ID"),
					rs.getString("receipt_name"),
					rs.getInt("receipt_amout"),
					rs.getString("description"),
					rs.getInt("expense_date")
					);

		}
		catch (SQLException e) {
			e.printStackTrace();
			ClearedReceipt = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			ClearedReceipt = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ClearedReceipt = null;
				}
			}
		}
		// 結果を返す
		return ClearedReceipt;
	}

}
