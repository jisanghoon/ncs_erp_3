package org.gradle;

import org.junit.Test;

import com.dgit.ncs.setting.jdbc.DBCon;

public class DBConnectionTest {

	@Test
	public void testGetConnection() {
		DBCon.getConnection();
	}

	@Test
	public void testCloseConnection() {
		DBCon.closeConnection();
	}

}
