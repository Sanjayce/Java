package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	/**
	 * 连接数据库(开启资源)
	 */
	
	public static Connection getSQLline(){
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/conputer", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	/**
	 * 关闭资源
	 */
	
	public static void closeResult(ResultSet mSet,Connection con ,PreparedStatement mStatement){
		try {
			if (mSet != null) {
				mSet.close();
			}
			if (mStatement != null) {
				mStatement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeResult(Connection con ,PreparedStatement mStatement){
		try {
			if (mStatement != null) {
				mStatement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
