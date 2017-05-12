package com.dgit.ncs.setting.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.dgit.ncs.setting.Config;
import com.dgit.ncs.setting.dao.DataBaseDao;
import com.dgit.ncs.setting.jdbc.DBCon;
import com.dgit.ncs.setting.jdbc.JdbcUtil;

public class ImportSettingService extends ServiceSetting {

	@Override
	public void initSetting() {
		DataBaseDao dao = DataBaseDao.getInstance();
		try {
			dao.selectUseDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-------------");
			System.out.println("Can't Use DB");
			System.out.println("-------------");
		}

		dao.setForeignKeyCheck(0);
		for (String tableName : Config.TABLE_NAME) {
			executeImportDate(getFilePath(tableName, true), tableName);
		}
		dao.setForeignKeyCheck(1);
	}

	private void executeImportDate(String tablePath, String tableName) {
		String sql = String.format(
				"LOAD DATA LOCAL INFILE '%s' INTO TABLE %s character set 'UTF8' fields TERMINATED by ','", tablePath,
				tableName);
		Statement stmt = null;
		try {
			Connection con = DBCon.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n", tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
		} finally {
			JdbcUtil.close(stmt);
		}

	}
}
