package database;
import java.sql.*;

import windows.MainScreen;

public class Print {

	public static String rightPad(String str, int len) {
	    return String.format(" %-" + len + "." + len + "s", str);
	}
	
	// Printing all tables in given array
	public static void printAll() {
		for (int i = 0; i < Spotify.tables.length; i++) {
			Print.printTable(Spotify.tables[i]);
		}
	}
	
	// Printing one table
	public static void printTable(String table) {
		try {
			Spotify.sql = "select * from " + table;
			Spotify.rset = Spotify.stmt.executeQuery(Spotify.sql);
			
			// Printing header for given table
			switch (table) {
			case "album":
				MainScreen.textArea.append("[----- ALBUM -----]\n");
				MainScreen.textArea.append(String.format(" Name %20s | Artist %9s | Release Date\n", "", ""));
				MainScreen.textArea.append(String.format("%63s\n", "").replace(' ', '-'));
				break;
				
			case "artist":
				MainScreen.textArea.append("[----- ARTIST -----]\n");
				MainScreen.textArea.append(String.format(" Name %13s | Sex | Nationality | Total Album Numbers | Genre\n", ""));
				MainScreen.textArea.append(String.format("%76s\n", "").replace(' ', '-'));
				break;
				
			case "lang":
				MainScreen.textArea.append("[----- LANGUAGE -----]\n");
				MainScreen.textArea.append(String.format(" Title %27s | Language\n", ""));
				MainScreen.textArea.append(String.format("%52s\n", "").replace(' ', '-'));
				break;
				
			case "song":
				MainScreen.textArea.append("[----- SONG -----]\n");
				MainScreen.textArea.append(String.format(" Title %27s | Album %19s | Length in Sec %3s\n", "", "", ""));
				MainScreen.textArea.append(String.format("%81s\n", "").replace(' ', '-'));
				break;
				
			default:
				MainScreen.textArea.append("Table doesn't exist.\n");
				break;
			}
			
			// Printing data for given table
			while (Spotify.rset.next()) {
				switch (table) {
				case "album":
					String alb_name = Spotify.rset.getString("album");
					String alb_art = Spotify.rset.getString("artist");
					String alb_date = Spotify.rset.getString("releaseDate");
					
					MainScreen.textArea.append(rightPad(alb_name, 26));
					MainScreen.textArea.append(rightPad(alb_art, 18));
					MainScreen.textArea.append(rightPad(alb_date, 12));
					break;
				
				case "artist":
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
					break;
				
				case "lang":
					String lang_tit = Spotify.rset.getString("title");
					String lang_lang = Spotify.rset.getString("lang");
					
					MainScreen.textArea.append(rightPad(lang_tit, 35));
					MainScreen.textArea.append(rightPad(lang_lang, 17));
					break;
				
				case "song":
					String song_tit = Spotify.rset.getString("title");
					String song_alb = Spotify.rset.getString("album");
					int song_len = Spotify.rset.getInt("lengthSec");
					
					MainScreen.textArea.append(rightPad(song_tit, 35));
					MainScreen.textArea.append(rightPad(song_alb, 32));
					MainScreen.textArea.append(rightPad(Integer.toString(song_len), 8));
					break;
				
				default:
					MainScreen.textArea.append("Table doesn't exist.\n");
					break;
				
				}
				MainScreen.textArea.append("\n");
			}
			MainScreen.textArea.append("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
