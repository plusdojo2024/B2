package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class ItemDAO {

	// 引数itemで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Items item) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Items VALUES ( 0,?,?,?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる



			if (item.getItem_name() != null && !item.getItem_name().equals("")) {
				pStmt.setString(1, item.getItem_name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			if (item.getTask_details_id() != null && !item.getTask_details_id().equals("")) {
				pStmt.setInt(1, item.getTask_details_id());
			}
			else {
				pStmt.setInt(1, "（未設定）");
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
	// ハウスIDで消耗品在庫リストを返す
		public List<Items> list(int house_id) {
			Connection conn = null;
			List<Items> itemList = new ArrayList<Items>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM Items WHERE house_id = ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				pStmt.setInt(1, house_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Items record = new Items(
					rs.getInt("ID"),
					rs.getString("item_name"),
					rs.getInt("status"),
					rs.getInt("task_details_id"),
					rs.getInt("house_id")
					);
					itemList.add(record);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				itemList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				itemList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemList = null;
					}
				}
			}

			// 結果を返す
			return itemList;
		}

		//消耗品、在庫少ない（３）をhouse_idで返す
		public List<Items> selectThreeStatus(int house_id) {
			Connection conn = null;
			List<Items> itemList = new ArrayList<Items>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM Items WHERE house_id = ? AND status = 3";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				pStmt.setInt(1, house_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Items record = new Items(
					rs.getInt("ID"),
					rs.getString("item_name"),
					rs.getInt("status"),
					rs.getInt("task_details_id"),
					rs.getInt("house_id")
					);
					itemList.add(record);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				itemList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				itemList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemList = null;
					}
				}
			}

			// 結果を返す
			return itemList;
		}

		//消耗品、在庫無い（２）をhouse_idで返す
				public List<Items> selectTwoStatus(int house_id) {
					Connection conn = null;
					List<Items> itemList = new ArrayList<Items>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

						// SQL文を準備する
						String sql = "SELECT * FROM Items WHERE house_id = ? AND status = 2";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる

						pStmt.setInt(1, house_id);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Items record = new Items(
							rs.getInt("ID"),
							rs.getString("item_name"),
							rs.getInt("status"),
							rs.getInt("task_details_id"),
							rs.getInt("house_id")
							);
							itemList.add(record);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						itemList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								itemList = null;
							}
						}
					}

					// 結果を返す
					return itemList;
				}
				//消耗品、在庫あり（1）をhouse_idで返す
				public List<Items> selectOneStatus(int house_id) {
					Connection conn = null;
					List<Items> itemList = new ArrayList<Items>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

						// SQL文を準備する
						String sql = "SELECT * FROM Items WHERE house_id = ? AND status = 1";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる

						pStmt.setInt(1, house_id);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Items record = new Items(
							rs.getInt("ID"),
							rs.getString("item_name"),
							rs.getInt("status"),
							rs.getInt("task_details_id"),
							rs.getInt("house_id")
							);
							itemList.add(record);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						itemList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								itemList = null;
							}
						}
					}

					// 結果を返す
					return itemList;
				}
				// ハウスIDで消耗品在庫リストを返す
				public List<Items> tasklist(int task_details_id) {
					Connection conn = null;
					List<Items> taskList = new ArrayList<Items>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

						// SQL文を準備する
						// 家事名で絞るけど、絞り方わからない
						String sql = "SELECT * FROM Items WHERE house_id = ? ";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる

						pStmt.setInt(1, house_id);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Items record = new Items(
							rs.getInt("ID"),
							rs.getString("item_name"),
							rs.getInt("status"),
							rs.getInt("task_details_id"),
							rs.getInt("house_id")
							);
							itemList.add(record);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						itemList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								itemList = null;
							}
						}
					}

					// 結果を返す
					return itemList;
				}

}