package com.crud.conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	private static Connection connection = null;

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/crudJava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "";
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("succes");
		} catch (Exception e) {
			System.err.println(e);
		}
		return connection;
	}

	public static void main(String[] args) {
		new ConnectionDB();
	}
}
