package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Insert;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertScreen extends JFrame {

	private JPanel contentPane;
	JLabel header = new JLabel("Add new artist");
	JLabel name = new JLabel("Name:");
	JLabel sex = new JLabel("Sex:");
	JLabel nationality = new JLabel("Nationality:");
	JLabel albumTot = new JLabel("Total Album Number:");
	JLabel genre = new JLabel("Genre:");
	private JTextField textField_name;
	private JTextField textField_sex;
	private JTextField textField_nationality;
	private JTextField textField_albumTot;
	private JTextField textField_genre;
	private JButton enter;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertScreen frame = new InsertScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		header.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(0, 20, 450, 20);
		contentPane.add(header);
		
		name.setFont(new Font("Arial", Font.PLAIN, 13));
		name.setBounds(35, 60, 140, 20);
		contentPane.add(name);
		
		sex.setFont(new Font("Arial", Font.PLAIN, 13));
		sex.setBounds(35, 90, 140, 20);
		contentPane.add(sex);
		
		nationality.setFont(new Font("Arial", Font.PLAIN, 13));
		nationality.setBounds(35, 120, 140, 20);
		contentPane.add(nationality);
		
		albumTot.setFont(new Font("Arial", Font.PLAIN, 13));
		albumTot.setBounds(35, 150, 140, 20);
		contentPane.add(albumTot);
		
		genre.setFont(new Font("Arial", Font.PLAIN, 13));
		genre.setBounds(35, 180, 140, 20);
		contentPane.add(genre);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_name.setBounds(185, 60, 225, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_sex = new JTextField();
		textField_sex.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_sex.setColumns(10);
		textField_sex.setBounds(185, 90, 225, 20);
		contentPane.add(textField_sex);
		
		textField_nationality = new JTextField();
		textField_nationality.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_nationality.setColumns(10);
		textField_nationality.setBounds(185, 120, 225, 20);
		contentPane.add(textField_nationality);
		
		textField_albumTot = new JTextField();
		textField_albumTot.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_albumTot.setColumns(10);
		textField_albumTot.setBounds(185, 150, 225, 20);
		contentPane.add(textField_albumTot);
		
		textField_genre = new JTextField();
		textField_genre.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_genre.setColumns(10);
		textField_genre.setBounds(185, 180, 225, 20);
		contentPane.add(textField_genre);
		
		enter = new JButton("ENTER");
		enter.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter.setBounds(168, 227, 117, 29);
		contentPane.add(enter);
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String art_artist = textField_name.getText();
				String art_sex = textField_sex.getText();
				String art_nationality = textField_nationality.getText();
				int art_albumTot = Integer.parseInt(textField_albumTot.getText());
				String art_genre = textField_genre.getText();
				Insert.insertArt(art_artist, art_sex, art_nationality, art_albumTot, art_genre);
				dispose();
			}
		});
	}

}
