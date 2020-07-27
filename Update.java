package database;
import java.sql.*;

import windows.MainScreen;

public class Update {
	
	// Updating all nationalities from before to after
	public static void updateArtNat(String before, String after) {
		try {
			Spotify.pStmt = Spotify.conn.prepareStatement("update artist set nationality = ? where nationality = ?");
			
			Spotify.pStmt.setString(1, after);
			Spotify.pStmt.setString(2, before);
			
			Spotify.pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Print.printTable("artist");
	}
	
	// Updating record lengths and release dates
	public static void updateLenDate(int minSec) throws SQLException {
		try {
			Spotify.conn.setAutoCommit(false);
			
			// Transaction step 1: Updating every record length with the given value if shorter
			Spotify.pStmt = Spotify.conn.prepareStatement("update song set lengthSec = ? where lengthSec < ?");
			
			Spotify.pStmt.setInt(1, minSec);
			Spotify.pStmt.setInt(2, minSec);
			
			Spotify.pStmt.executeUpdate();
			
			// Transaction step 2: Updating all release dates of all albums to 2020-07-01
			Spotify.sql = "update album set releaseDate = '2020-07-01'";
			
			Spotify.stmt.executeUpdate(Spotify.sql);
			
			Spotify.conn.commit();
			
			MainScreen.textArea.append("Transaction committed successfully.\n");
			
			Print.printTable("song");
			Print.printTable("album");
		} catch (SQLException e) {
			e.printStackTrace();
			
			if (Spotify.conn != null) {
				try {
					MainScreen.textArea.append("Transaction rolled back.\n");
					Spotify.conn.rollback();
				} catch (SQLException exc) {
					exc.printStackTrace();
				}
			}
		} finally {
			Spotify.conn.setAutoCommit(true);
		}
	}
	
}
