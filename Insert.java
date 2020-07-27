package database;
import java.sql.*;

public class Insert {

	public static void insertArt(String artist, String sex, String nationality, int albumTot, String genre) {
		
		try {
			Spotify.pStmt = Spotify.conn.prepareStatement("insert into Artist values (?, ?, ?, ?, ?)");
			
			Spotify.pStmt.setString(1, artist);
			Spotify.pStmt.setString(2, sex);
			Spotify.pStmt.setString(3, nationality);
			Spotify.pStmt.setInt(4, albumTot);
			Spotify.pStmt.setString(5, genre);
			
			Spotify.pStmt.executeUpdate();
			
			Print.printTable("artist");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
