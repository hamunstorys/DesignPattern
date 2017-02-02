
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import ch06.TeamBean;

public class MySqlBehavior {

	/*
	 * /** Copyright(c) 2017 Helloworld Education Service
	 * (http://www.hello-world.co.kr/)
	 *
	 * All rights reserved
	 *
	 * Permission to use, copy, modify and distribute this material for any
	 * purpose and without fee is hereby granted, provided that the above
	 * copyright notice and this permission notice appear in all copies, and
	 * that the name of iSavvix Corporation not be used in advertising or
	 * publicity pertaining to this material without the specific, prior written
	 * permission of an authorized representative of iSavvix Corporation.
	 *
	 * ISAVVIX CORPORATION MAKES NO REPRESENTATIONS AND EXTENDS NO WARRANTIES,
	 * EXPRESS OR IMPLIED, WITH RESPECT TO THE SOFTWARE, INCLUDING, BUT NOT
	 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR ANY
	 * PARTICULAR PURPOSE, AND THE WARRANTY AGAINST INFRINGEMENT OF PATENTS OR
	 * OTHER INTELLECTUAL PROPERTY RIGHTS. THE SOFTWARE IS PROVIDED "AS IS", AND
	 * IN NO EVENT SHALL ISAVVIX CORPORATION OR ANY OF ITS AFFILIATES BE LIABLE
	 * FOR ANY DAMAGES, INCLUDING ANY LOST PROFITS OR OTHER INCIDENTAL OR
	 * CONSEQUENTIAL DAMAGES RELATING TO THE SOFTWARE.
	 *
	 */
	/*
	 * 
	 * 
	 * @author Hong Jin-seob
	 * 
	 * @create date by 2017-02-02
	 * 
	 * @last modify date by 2017-02-02
	 * 
	 * this class is Mysql executeQuery manager.
	 * 
	 * before used this class please reference MysqlJDBC and Class
	 * MySqlBehaivor.
	 */

	/*
	 * 데이타베이스 기본 설정
	 */

	MySqlConnector sqlConnector;

	public void executeUpdate(String query, String url, String database, String user, String password) {

		try {
			sqlConnector = new MySqlConnector();
			sqlConnector.connectionDatabase(url, database, user, password);
			sqlConnector.getStatement().executeUpdate(query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE execuetUpdate : " + query);

	}

	public void executeQuery(String query) {

		try {
			sqlConnector = new MySqlConnector();
			sqlConnector.connectionDatabase();
			sqlConnector.getStatement().executeQuery(query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE executeUpdate : " + query);

	}

	public void executeQuery(String query, String url, String user, String password) {

		try {
			sqlConnector = new MySqlConnector();
			sqlConnector.connectionDatabase(url, user, password);
			sqlConnector.getStatement().executeQuery(query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE executeUpdate : " + query);

	}

	public void executeQuery(String query, String url, String database, String user, String password) {

		try {

			sqlConnector = new MySqlConnector();
			sqlConnector.connectionDatabase(url, database, user, password);
			sqlConnector.getStatement().executeQuery(query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE executeUpdate : " + query);

	}

	public void sqlExecuteSelect(String table_name) {

		String query = "SELECT " + "* " + "FROM " + table_name;
		executeQuery(query);
		sqlConnector.setResultset(query);
		ResultSetMetaData metadata = (ResultSetMetaData) sqlConnector.getResultset();

		int columns = 0;

		try {

			columns = metadata.getColumnCount();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {

			Vector tableRows = new Vector<>();

			while (sqlConnector.getResultset().next()) {
				Vector tableColumns = new Vector<>();

				for (int i = 0; i < columns; i++) {

					tableColumns.addElement(sqlConnector.getResultset().getInt(i));

				}

				tableRows.addElement(tableColumns);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void sqlExecuteSelect(String column, String table_name) {

		executeQuery("SELECT " + column + "FROM " + table_name);

	}

	/* getter */

	public MySqlConnector getSqlConnector() {
		return sqlConnector;
	}

	/* setter */

	public void setSqlConnector(MySqlConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

}