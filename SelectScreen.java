package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Delete;
import database.Select;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SelectScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_genre = new JTextField();
	JLabel header1 = new JLabel("Select artist with genre");
	JLabel genre = new JLabel("Genre:");
	private final JButton enter1 = new JButton("ENTER");
	private final JLabel header2 = new JLabel("Select outdated records");
	private final JLabel year_period = new JLabel("Year period:");
	private final JTextField textField_yr_pr = new JTextField();
	private final JButton enter2 = new JButton("ENTER");
	private final JLabel header3 = new JLabel("Select with minimum counts");
	private final JLabel min_count = new JLabel("Minimum count:");
	private final JTextField textField_min_count = new JTextField();
	private final JButton enter3 = new JButton("ENTER");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectScreen frame = new SelectScreen();
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
	public SelectScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Selecting artist with genre
		header1.setHorizontalAlignment(SwingConstants.CENTER);
		header1.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header1.setBounds(0, 20, 450, 20);
		contentPane.add(header1);
		
		genre.setFont(new Font("Arial", Font.PLAIN, 13));
		genre.setBounds(35, 60, 140, 20);
		contentPane.add(genre);
		
		textField_genre.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_genre.setColumns(10);
		textField_genre.setBounds(185, 60, 225, 20);
		contentPane.add(textField_genre);
		
		enter1.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter1.setBounds(165, 90, 120, 30);
		contentPane.add(enter1);

		enter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String art_gen = textField_genre.getText();
				Select.selectGenre(art_gen);
				dispose();
			}
		});
		
		// Selecting outdated records
		header2.setHorizontalAlignment(SwingConstants.CENTER);
		header2.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header2.setBounds(0, 142, 450, 20);
		
		contentPane.add(header2);
		year_period.setFont(new Font("Arial", Font.PLAIN, 13));
		year_period.setBounds(35, 182, 140, 20);
		
		contentPane.add(year_period);
		textField_yr_pr.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_yr_pr.setColumns(10);
		textField_yr_pr.setBounds(185, 182, 225, 20);
		
		contentPane.add(textField_yr_pr);
		enter2.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter2.setBounds(165, 212, 120, 30);
		contentPane.add(enter2);
		
		enter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int period = Integer.parseInt(textField_yr_pr.getText());
				Select.selectOutdated(period);
				dispose();
			}
		});
		
		// Selecting with minimum counts
		header3.setHorizontalAlignment(SwingConstants.CENTER);
		header3.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header3.setBounds(0, 261, 450, 20);
		contentPane.add(header3);
		
		min_count.setFont(new Font("Arial", Font.PLAIN, 13));
		min_count.setBounds(35, 301, 140, 20);
		
		contentPane.add(min_count);
		textField_min_count.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_min_count.setColumns(10);
		textField_min_count.setBounds(185, 301, 225, 20);
		
		contentPane.add(textField_min_count);
		enter3.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter3.setBounds(165, 331, 120, 30);
		contentPane.add(enter3);
		
		enter3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pl_min_count = Integer.parseInt(textField_min_count.getText());
				Select.selectMinCount(pl_min_count);
				dispose();
			}
		});
	}

}
