package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;

public class TodoDAO {


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

	// ハウスIDで家事リストを返す
			public List<Items> tasklist(int house_id) {
				Connection conn = null;
				List<Items> itemList = new ArrayList<Task_details>();

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
}
