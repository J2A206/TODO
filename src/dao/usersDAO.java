package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class usersDAO {
	// データベース接続に使用する情報
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "Rapushi1101";//各自のパスワードに変更

	public User findByLogin(User users) {
		User user = null;
		// SELECT文の準備
		String sql = "SELECT name,pass FROM users where name = ? and pass = ?";
		// データベース接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			pStmt.setString(1, users.getName());
			pStmt.setString(2, users.getPass());

			try (ResultSet rs = pStmt.executeQuery()) {
				// SELECT文の結果をArrayListに格納
				while (rs.next()) {
					String name = rs.getString("name");
					String pass = rs.getString("pass");
					user = new User(name, pass);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
}
