package database;

import java.sql.SQLException;

import windows.MainScreen;

public class Select {

	// Aligning strings from the left
	public static String rightPad(String str, int len) {
	    return String.format(" %-" + len + "." + len + "s", str);
	}
	
	// Selecting artists of given genre
	public static void selectGenre(String genre) {
		try {
			switch (genre) {
			case "Hip hop":
				Spotify.sql = "select * from artist where genre = 'Hip hop'";
				break;
			
			case "Latin Pop":
				Spotify.sql = "select * from artist where genre = 'Latin pop'";
				break;
			
			case "Pop":
				Spotify.sql = "select * from artist where genre = 'Pop'";
				break;
			
			case "R&B":
				Spotify.sql = "select * from artist where genre = 'R&B'";
				break;
			
			default:
				MainScreen.textArea.append("No artist of given genre.\n");
				break;
			}
			
			Spotify.rset = Spotify.stmt.executeQuery(Spotify.sql);
			
			MainScreen.textArea.append(String.format(" Name %13s | Sex | Nationality | Total Album Numbers | Genre\n", ""));
			MainScreen.textArea.append(String.format("%76s\n", "").replace(' ', '-'));
			
			while (Spotify.rset.next()) {
				String art_name = Spotify.rset.getString("artist");
				String art_sex = Spotify.rset.getString("sex");
				String art_nat = Spotify.rset.getString("nationality");
				int art_tot = Spotify.rset.getInt("albumTot");
				String art_gen = Spotify.rset.getString("genre");
				
				MainScreen.textArea.append(rightPad(art_name , 21));
				MainScreen.textArea.append(rightPad(art_sex, 4));
				MainScreen.textArea.append(rightPad(art_nat , 21));
				MainScreen.textArea.append(rightPad(Integer.toString(art_tot) , 13));
				MainScreen.textArea.append(rightPad(art_gen , 11));
				MainScreen.textArea.append("\n");
			}
			MainScreen.textArea.append("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Selecting outdated records from view table with given year extent
	public static void selectOutdated(int period) {
		int curr_year = 2020;
		int min_year = curr_year - period;
		
		try {
			Spotify.sql = "select title, artist, releaseDate from playlist where year(releaseDate) <= " + min_year;
			
			Spotify.rset = Spotify.stmt.executeQuery(Spotify.sql);
			
			MainScreen.textArea.append(String.format(" Title %27s | Artist %9s | Release Date\n", "", ""));
			MainScreen.textArea.append(String.format("%71s\n", "").replace(' ', '-'));
			
			while (Spotify.rset.next()) {
				String pl_tit = Spotify.rset.getString("title");
				String pl_art = Spotify.rset.getString("artist");
				String pl_rd = Spotify.rset.getString("releaseDate");
				
				MainScreen.textArea.append(rightPad(pl_tit, 35));
				MainScreen.textArea.append(rightPad(pl_art, 18));
				MainScreen.textArea.append(rightPad(pl_rd, 12));
				MainScreen.textArea.append("\n");
			}
			MainScreen.textArea.append("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Selecting records with at least minCount songs from same artist
	public static void selectMinCount(int min_count) {
		try {
			Spotify.sql = "select title, artist from (song natural join album) join artist using (artist) where artist in (select artist from playlist group by artist having count(*) >= " + min_count + ")";
			
			Spotify.rset = Spotify.stmt.executeQuery(Spotify.sql);
			
			MainScreen.textArea.append(String.format(" Title %27s | Artist %9s\n", "", ""));
			MainScreen.textArea.append(String.format("%55s\n", "").replace(' ', '-'));
			
			while (Spotify.rset.next()) {
				String pl_tit = Spotify.rset.getString("title");
				String pl_art = Spotify.rset.getString("artist");
				
				MainScreen.textArea.append(rightPad(pl_tit, 35));
				MainScreen.textArea.append(rightPad(pl_art, 18));
				MainScreen.textArea.append("\n");
			}
			MainScreen.textArea.append("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
