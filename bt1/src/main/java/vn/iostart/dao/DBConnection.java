package vn.iostart.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String USERNAME = "root";
	private static String PASSWORD = "1234";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static String URL = "jdbc:mysql://127.0.0.1:3306/bt";

	public static Connection getConnection() throws SQLException {

		try {

			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}

	public static void main(String[] args) {

		try {

			new DBConnection();

			System.out.println(DBConnection.getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}


}
