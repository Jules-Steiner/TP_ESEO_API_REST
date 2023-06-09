package com.dao;

import java.sql.*;

public class DaoFactory {
	private String url;
	private String username;
	private String password;
	
	DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}

		DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/twic", "root", "");

		return instance;
    }
	
	public Connection getConnection() throws SQLException {
		Connection connexion = DriverManager.getConnection(url, username, password);
		return connexion;
	}

}
