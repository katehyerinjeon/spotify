package database;
import java.sql.*;

public class Delete {
	
	// Deleting any tuple with given language
	public static void deleteLang(String lang) {
		try {
			Spotify.pStmt = Spotify.conn.prepareStatement("delete from lang where lang = ?");
			
			Spotify.pStmt.setString(1, lang);

			Spotify.pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Print.printTable("lang");
	}

}
