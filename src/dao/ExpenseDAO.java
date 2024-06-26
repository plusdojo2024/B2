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
			String sql = "INSERT INTO SETTLEMENTS (id,users_id,receipt_name,receipt_amount,description,expense_date,settlement_finish,settlement_approval,settlement_date,houses_id)"
					+ "                      VALUES (NULL, ?,      ?,           ?,              ?, CURRENT_DATE,FALSE,FALSE,null,?)";
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

			// ハウスID
			pStmt.setInt(5, settlement.getHouses_id());

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

	// ハウスIDでレシートリストを返す(未精算の)
	public List<Settlements> list(int houses_id) {
		Connection conn = null;
		List<Settlements> ReceiptList = new ArrayList<Settlements>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM SETTLEMENTS WHERE houses_id = ? AND settlement_finish = false";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, houses_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Settlements Receipt_record = new Settlements(
				rs.getInt("ID"),						// ID
				rs.getInt("users_id"),					//ユーザーID
				rs.getString("receipt_name"),			//支出の種類
				rs.getInt("receipt_amount"),			//金額
				rs.getString("description"),			//詳細
				rs.getString("expense_date"),			//支払日
				rs.getBoolean("settlement_finish"),		//精算済みフラグ
				rs.getBoolean("settlement_approval"),	//承認済みフラグ
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

	//精算ボタンクリックされたらExpenseDAOを精算済みにする＋精算日を追加
	public boolean update(int houses_id, int settlement_id, String settlement_date){
		Connection conn = null;
		boolean result = false;

	try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			String sql = "UPDATE SETTLEMENTS SET SETTLEMENT_FINISH=TRUE, SETTLEMENT_DATE=CURRENT_DATE WHERE HOUSES_ID=? AND ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, houses_id);
			pStmt.setInt(2, settlement_id);

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

	// 承認ボタンクリックされたらExpenseDAOを承認済みにする
	public boolean update(int houses_id, int settlement_id){
		Connection conn = null;
		boolean result = false;

	try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			String sql = "UPDATE SETTLEMENTS SET SETTLEMENT_APPROVAL=TRUE WHERE HOUSES_ID=? AND ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,houses_id);
			pStmt.setInt(2,settlement_id);
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


	// 精算済みをレシートをhouse_idで返す
	public List<Settlements> settlement_finish (int houses_id) {
		Connection conn = null;
		List<Settlements> ReceiptList = new ArrayList<Settlements>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM SETTLEMENTS WHERE house_id = ? AND settlement_finish = true";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる

			pStmt.setInt(1, houses_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Settlements Receipt_record = new Settlements(
				rs.getInt("ID"),						// ID
				rs.getInt("users_id"),					//ユーザーID
				rs.getString("receipt_name"),			//支出の種類
				rs.getInt("receipt_amount"),			//金額
				rs.getString("description"),			//詳細
				rs.getString("expense_date"),			//支払日
				rs.getBoolean("settlement_finish"),		//精算済みフラグ
				rs.getBoolean("settlement_approval"),	//承認済みフラグ
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

	// 承認済みをレシートをhouse_idで返す（実装検討中）
	public List<Settlements> settlement_approval (int houses_id) {
		Connection conn = null;
		List<Settlements> ReceiptList = new ArrayList<Settlements>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM SETTLEMENTS WHERE house_id = ? AND settlement_approval = true";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる

			pStmt.setInt(1, houses_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Settlements Receipt_record = new Settlements(
				rs.getInt("ID"),						// ID
				rs.getInt("users_id"),					//ユーザーID
				rs.getString("receipt_name"),			//支出の種類
				rs.getInt("receipt_amount"),			//金額
				rs.getString("description"),			//詳細
				rs.getString("expense_date"),			//支払日
				rs.getBoolean("settlement_finish"),		//精算済みフラグ
				rs.getBoolean("settlement_approval"),	//承認済みフラグ
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

	// レシートの削除
	public boolean delete(int houses_id, int settlement_id) {
	  Connection conn = null;
	  boolean result = false;

	try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			String sql = "DELETE FROM SETTLEMENTS WHERE HOUSES_ID=? AND ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,houses_id);
			pStmt.setInt(2,settlement_id);
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

