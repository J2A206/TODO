package model;

import java.io.Serializable;

public class Todo implements Serializable {
	private int id;
	private String priority;
	private String content;
	private String date;
	private String userName;

	public Todo() {}

	public Todo(int id, String priority, String content, String date, String userName) {
		this.id = id;
		this.priority = priority;
		this.content = content;
		this.date = date;
		this.userName = userName;
	}

	public Todo(String priority, String content, String date, String userName) {
		this.priority = priority;
		this.content = content;
		this.date = date;
		this.userName = userName;
	}

	public Todo(int no, String priority, String content, String date) {
		this.id = no;
		this.priority = priority;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
