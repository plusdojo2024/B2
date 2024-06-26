package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TaskNameFreqEffo;
import model.UserHp;

public class TaskAutoListDAO {
	//その家の家事の回数を計算するメソッド
	public int numArray(int  houses_id) {
		Connection conn = null;
		int num = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "SELECT sum(frequency) as sum  FROM TASK_DETAILS WHERE houses_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, houses_id);


	            // SELECT文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();
			rs.next();
			num = rs.getInt("sum");


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
	return num;
}
	//その家の家事の名前、頻度、疲労度をあつめるメソッド
	public ArrayList<TaskNameFreqEffo> namefreqeffo (int  houses_id) {
		Connection conn = null;
		ArrayList<TaskNameFreqEffo> tanList = new ArrayList<TaskNameFreqEffo>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SELECT文を準備する
			String sql = "SELECT task_name,frequency,effort  FROM TASK_DETAILS WHERE houses_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL文を完成させる
			pStmt.setInt(1, houses_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//

			while (rs.next()) {
				TaskNameFreqEffo tan = new TaskNameFreqEffo(
			                    rs.getString("task_name"),
			                    rs.getInt("frequency"),
			                    rs.getInt("effort")
			            );
			    tanList.add(tan);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			tanList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			tanList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						tanList = null;
					}
				}
		}
		// 結果を返す
		return tanList;
	}

	//家に入居している人を検索してリストに入れるメソッド
	public ArrayList<UserHp> namehp(int houses_id,int hp) {
		Connection conn = null;
		ArrayList<UserHp> hpList = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "SELECT user_name  FROM users WHERE houses_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, houses_id);

            // SELECT文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();

            //
			while (rs.next()) {
				UserHp record = new UserHp(
				rs.getString("user_name"),
				hp
				);
				hpList.add(record);
			}
		}

			catch (SQLException e) {
				e.printStackTrace();
				hpList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				hpList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						hpList = null;
					}
				}
			}

			// 結果を返す
			return hpList;
		}

	//HPを計算するメソッド
	public int calHp(int houses_id) {
		Connection conn = null;
		int hp = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2", "sa", "");

			//SQL文を準備する
			String sql = "SELECT sum(effort*frequency) as sumhp  FROM TASK_DETAILS where houses_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, houses_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();

			hp=rs.getInt("sumhp");

		}
		catch (SQLException e) {
			e.printStackTrace();
			hp = 0;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			hp = 0;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					hp = 0;
				}
			}
		}
		// 結果を返す
		return hp;
	}
	//家事名から労力を持ってくるメソッド
	public int searchEffort(String task_name) {
		Connection conn = null;
		int effort=0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B2","sa", "");

			// SQL文を準備する
			String sql = "SELECT effort  FROM TASK_DETAILS  WHERE task_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, task_name);

            // SELECT文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();

            //
			rs.next();
			effort = rs.getInt("effort");

		}

			catch (SQLException e) {
				e.printStackTrace();
				effort = 0;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				effort = 0;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						effort = 0;
					}
				}
			}

			// 結果を返す
			return effort;
		}

}