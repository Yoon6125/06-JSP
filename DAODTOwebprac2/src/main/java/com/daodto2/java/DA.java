package com.daodto2.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DA {
	Connection con = null;
	Statement st = null;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeconnect() {
		try {
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateSql(String sql) {
		try {
			int result = st.executeUpdate(sql);

			System.out.println("실행된 쿼리:" + sql);
			System.out.println("실행된 행 수:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
