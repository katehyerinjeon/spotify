package database;
import java.sql.*;

import windows.MainScreen;
import windows.StartScreen;

public class Spotify {

	// Setting systematic variables
	static String user = "root";
	static String pw = "qwerty123";
	public static String db = "spotify";
	static String url = "jdbc:mysql://localhost:3306/" + db + "?&serverTimezone=UTC";
	
	// Declaring database variables
	public static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pStmt = null;
	static ResultSet rset = null;
	static String sql = "";
	
	// Array of all table names
	static String[] tables = {"album", "artist", "lang", "song"};
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// Preparing application
	public static void connect() {
		try {
		conn = DriverManager.getConnection(url, user, pw);
		stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Terminating application
	public static void close() {
		if (rset != null) {
			try {
				rset.close();
				MainScreen.textArea.append("... Closing result set ...\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
				MainScreen.textArea.append("... Closing statement ...\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pStmt != null) {
			try {
				pStmt.close();
				MainScreen.textArea.append("... Closing prepared statement ...\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
				MainScreen.textArea.append("... Closing connection " + conn.toString() + " ...\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		MainScreen.textArea.append("Application orderly terminated. Goodbye!");
	}
	
	// Main method for application
	public static void main(String[] args) {
		new StartScreen().setVisible(true);
	}
	
}
