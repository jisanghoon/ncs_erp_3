package com.dgit.ncs.setting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dgit.ncs.setting.jdbc.DBCon;
import com.dgit.ncs.setting.jdbc.JdbcUtil;

public class TableDao {
	private PreparedStatement pstmt;

	private static TableDao instance = new TableDao();

	private TableDao() {
	}

	public static TableDao getInstance() {
		return instance;
	}

	public void createTable(String sql) throws SQLException {
		Connection con = DBCon.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.printf("CREATE TABLE(%s) Success! %n", sql.substring(13, sql.indexOf("(")));
		} catch (SQLException e) {
			System.out.printf("CREATE TABLE(%s) Fail! %n", sql.substring(13, sql.indexOf("(")));
			e.printStackTrace();
			throw new SQLException();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public void createTrigger(String sql) {
		Connection con = DBCon.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.printf("CREATE Trigger Success! %n");
		} catch (SQLException e) {
			System.out.printf("CREATE Trigger Fail! %n");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
