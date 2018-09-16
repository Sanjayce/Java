package com.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOConputer {

	public boolean fige = false;
	public String sql1 = "SELECT * FROM nootbook";
	public String sql2 = "INSERT nootbook(model,cate,brand,peice) VALUE(?,?,?,?)";
	public String sql3 = "UPDATE nootbook SET model = ?,cate = ?,brand = ?,peice = ? WHERE nootbook.id = ?";
	public String sql4 = "DELETE FROM nootbook WHERE nootbook.id = ?";
	/**
	 * 查询数据
	 */

	public ArrayList<Conputer> getList() {

		ArrayList<Conputer> mlists = new ArrayList<Conputer>();
		Connection con = TestConnection.getSQLline();
		System.out.println(con);
		PreparedStatement mStatement = null;
		ResultSet mSet = null;
		try {
			mStatement = con.prepareStatement(sql1);
			mSet = mStatement.executeQuery();
			while (mSet.next()) {
				Conputer mConputer = new Conputer();
				mConputer.setId(mSet.getInt("id"));
				mConputer.setModel(mSet.getString("model"));
				mConputer.setCate(mSet.getString("cate"));
				mConputer.setBrand(mSet.getString("brand"));
				mConputer.setPeice(mSet.getInt("peice"));
				mlists.add(mConputer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			TestConnection.closeResult(mSet, con, mStatement);
		}
		return mlists;
	}

	/**
	 * 添加数据
	 */

	public boolean insert(Conputer mConputer) {

		Connection con = TestConnection.getSQLline();
		PreparedStatement mStatement = null;
		try {
			mStatement = con.prepareStatement(sql2);
			mStatement.setString(1, mConputer.getModel());
			mStatement.setString(2, mConputer.getCate());
			mStatement.setString(3, mConputer.getBrand());
			mStatement.setInt(4, mConputer.getPeice());
			int a = mStatement.executeUpdate();
			if (a > 0) {
				fige = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			TestConnection.closeResult(con, mStatement);
		}
		return fige;
	}

	/**
	 * 修改数据
	 */

	public boolean update(Conputer mConputer) {
		Connection con = TestConnection.getSQLline();
		PreparedStatement mStatement = null;
		try {
			mStatement = con.prepareStatement(sql3);
			mStatement.setString(1, mConputer.getModel());
			mStatement.setString(2, mConputer.getCate());
			mStatement.setString(3, mConputer.getBrand());
			mStatement.setInt(4, mConputer.getPeice());
			mStatement.setInt(5, mConputer.getId());
			int a = mStatement.executeUpdate();
			if (a > 0) {
				fige = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fige;
	}

	/**
	 * 删除数据
	 */

	public boolean delete(int id) {
		Connection con = TestConnection.getSQLline();
		PreparedStatement mStatement = null;
		try {
			mStatement = con.prepareStatement(sql4);
			mStatement.setInt(1, id);
			int a = mStatement.executeUpdate();
			if (a > 0) {
				fige = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fige;
	}
}
