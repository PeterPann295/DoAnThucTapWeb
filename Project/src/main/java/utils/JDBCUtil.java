package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private final static String server = "DESKTOP-RRE6GOE\\SQLEXPRESS";
	private final static String port = "1433";
	private final static String databaseName = "KetNoiCSDL";
	private final static String username = "sa";
	private final static String password = "123456";

	public static Connection getConnection() {
		Connection c = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=project;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";

			try {
				c = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (Exception e) {

		}

		return c;
	} 


	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		JDBCUtil jd = new JDBCUtil();
		Connection con = jd.getConnection();
		closeConnection(con);

	}
}
