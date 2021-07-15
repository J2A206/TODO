package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class TodoDAO {
	// データベース接続に使用する情報
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "Rapushi1101";//各自のパスワードに変更

	public List<Todo> find(String userName) {
		List<Todo> todoList = new ArrayList<Todo>();
		// SELECT文の準備
		String sql = "SELECT id,priority,content,date,userName FROM todo "
				+ "where userName = ? ORDER BY priority DESC, id asc";
		// データベース接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			pStmt.setString(1, userName);
			try (ResultSet rs = pStmt.executeQuery()) {
				// SELECT文の結果をArrayListに格納
				while (rs.next()) {
					int id = rs.getInt("id");
					String priority = rs.getString("priority");
					String content = rs.getString("content");
					String date = rs.getString("date");
					Todo todo = new Todo(id, priority, content, date, userName);
					todoList.add(todo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return todoList;
	}

	public boolean create(Todo todo) {
		// INSERT文の準備
		String sql = "INSERT INTO todo(id, priority, content, date, userName) VALUES(NEXTVAL('TODO_ID_SEQ'), ?, ?, ?, ?)";
		// データベース接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setInt(1, Integer.parseInt(todo.getPriority()));
			pStmt.setString(2, todo.getContent());
			pStmt.setDate(3, Date.valueOf(todo.getDate()));
			pStmt.setString(4, todo.getUserName());
			// INSERT文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Todo todo) {
		// UPDATE文の準備
		String sql = "update todo set priority = ?, content = ?, date = ? where id = ?";
		// データベース接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			// UPDATE文中の「?」に使用する値を設定しSQLを完成
			pStmt.setInt(1, Integer.parseInt(todo.getPriority()));
			pStmt.setString(2, todo.getContent());
			pStmt.setDate(3, Date.valueOf(todo.getDate()));
			pStmt.setInt(4, todo.getId());
			// UPDATE文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		// DELETE文の準備
		String sql = "delete from todo where id = ?";
		// データベース接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql);) {
			// DELETE文中の「?」に使用する値を設定しSQLを完成
			pStmt.setInt(1, id);
			// DELETE文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
