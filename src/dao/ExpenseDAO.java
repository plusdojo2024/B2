package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Settlements;

// テーブルはSettlementにExpensesを合体させた
// なのでテーブルの名前はSettlement
// DAOの名前は変えるとエラーになるからそのままExpensesDAOのまま
public class ExpenseDAO {

	// レシート登録、成功したらtrueを返す
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

	// ハウスIDでレシートリストを返す
	public List <Receipt_Details> list(int houses_id) {
		Connection conn = null;
		List<Receipt_Details> ReceiptList = new ArrayList<Receipt_Details>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM RECEIPT_DETAILS WHERE houses_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, houses_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Receipt_Details Receipt_record = new Receipt_Details(
				rs.getInt("ID"),						// ID
				rs.getInt("users_id"),					//ユーザーID
				rs.getString("receipt_name"),			//支出の種類
				rs.getInt("receipt_amount"),			//金額
				rs.getString("description"),			//詳細
				rs.getString("expense_date"),			//支払日
				rs.getString("settlement_finish"),		//精算済みフラグ
				rs.getString("settlement_approval"),	//承認済みフラグ
				rs.getString("settlement_date"),		//精算日
				rs.getInt("houses_id")					//家ID
				);
				ReceiptList.add(Receipt_record);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			ReceiptList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			ReceiptList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ReceiptList = null;
				}
			}
		}
		// 結果を返す
		return ReceiptList;
	}

}
