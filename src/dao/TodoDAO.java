package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;
import model.Task_Details;

public class TodoDAO {


	// ハウスIDで消耗品在庫リスト(個人)を返す
			public List<Items> list(int house_id) {
				Connection conn = null;
				List<Items> itemList = new ArrayList<Items>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM Items WHERE house_id = ? AND users_id = ? AND item_finish is false AND"
							+ " assigned_date = ?";
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
	// ハウスIDで家事リスト(個人)を返す
				public List<Task_Details> tasklist(int house_id) {
					Connection conn = null;
					List<Task_Details> taskList = new ArrayList<Task_Details>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

						// SQL文を準備する
						String sql = "SELECT * FROM Task_details WHERE house_id = ? AND users_id = ? task_finish is false AND "
								+ "assigned_date = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる

						pStmt.setInt(1, house_id);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Task_Details record = new Task_Details(
							rs.getInt("ID"),
							rs.getString("task_name"),
							rs.getString("description"),
							rs.getInt("effort"),
							rs.getInt("frequency"),
							rs.getInt("house_id")
								);
							taskList.add(record);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						taskList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						taskList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								taskList = null;
							}
						}
					}

					// 結果を返す
					return taskList;
				}




			// ハウスIDで消耗品在庫リスト(全体)を返す
			public List<Items> all_list(int house_id) {
				Connection conn = null;
				List<Items> itemList = new ArrayList<Items>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM Items WHERE house_id = ? AND item_finish is false"
							+ " assigned_date = ?";
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


			// ハウスIDで家事リスト(全体)を返す
			public List<Task_Details> all_tasklist(int house_id) {
				Connection conn = null;
				List<Task_Details> all_taskList = new ArrayList<Task_Details>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM Task_details WHERE house_id = ? AND task_finish is false "
							+ "assigned_date = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる

					pStmt.setInt(1, house_id);

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Task_Details record = new Task_Details(
						rs.getInt("ID"),
						rs.getString("task_name"),
						rs.getString("description"),
						rs.getInt("effort"),
						rs.getInt("frequency"),
						rs.getInt("house_id")
							);
						all_taskList.add(record);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					all_taskList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					all_taskList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							all_taskList = null;
						}
					}
				}

				// 結果を返す
				return all_taskList;
			}



}
