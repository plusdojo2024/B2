package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Houses;
//Houses型のHouse

public class HouseDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す ☆この検索はいる？？
	/* public List<Houses> select(Houses house) {
		Connection conn = null;
		List<Houses> houseList = new ArrayList<Houses>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM Bc WHERE name LIKE ? AND address LIKE ? ORDER BY number";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (house.getName() != null) {
				pStmt.setString(1, "%" + house.getName() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (house.getPassword() != null) {
				pStmt.setString(2, "%" + house.getPassword() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする ☆以下もデータベース作成後変えていく？？
			while (rs.next()) {
				Houses house record = new house(
				rs.getInt("number"),
				rs.getString("company"),
				rs.getString("department"),
				rs.getString("position"),
				rs.getString("name"),
				rs.getString("zipcode"),
				rs.getString("address"),
				rs.getString("phone"),
				rs.getString("fax"),
				rs.getString("email"),
				rs.getString("remarks")
				);
				houseList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			houseList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			houseList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					houseList = null;
				}
			}
		}

		// 結果を返す
		return houseList;
	}*/

	// 家登録ができたらtrueを返す
	public boolean insert(Houses house) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO HOUSES VALUES (NULL, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (house.getHouse_hash() != null && !house.getHouse_hash().equals("")) {
				pStmt.setString(1, house.getHouse_hash());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (house.getPassword() != null && !house.getPassword().equals("")) {
				pStmt.setString(2, house.getPassword());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (house.getHouse_name() != null && !house.getHouse_name().equals("")) {
				pStmt.setString(3, house.getHouse_name());
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
	public boolean isLoginOK(Houses house) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM HOUSES WHERE house_hash = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, house.getHouse_hash());
			pStmt.setString(2,house.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
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


	//house_hushからHousesのインスタンスを持ってくる
	public Houses select(Houses house) {
		Connection conn = null;
		Houses house_data;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT * FROM HOUSES WHERE house_hash = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (house.getHouse_hash() != null) {
				pStmt.setString(1, house.getHouse_hash());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			house_data = new Houses(
					rs.getInt("ID"),
					rs.getString("house_hash"),
					rs.getString("password"),
					rs.getString("house_name")
					);

		}
		catch (SQLException e) {
			e.printStackTrace();
			house_data = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			house_data = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					house_data = null;
				}
			}
		}
		// 結果を返す
		return house_data;
	}
}
