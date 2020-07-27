package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Insert;
import database.Update;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class UpdateScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nat_from = new JTextField();
	private JTextField textField_nat_to = new JTextField();
	private JTextField textField_min_sec = new JTextField();
	JLabel header1 = new JLabel("Update artist nationality");
	JLabel header2 = new JLabel("Update record length and release date");
	JLabel nat_from = new JLabel("From:");
	JLabel nat_to = new JLabel("To:");
	JLabel min_sec = new JLabel("Minimum second:");
	private JButton enter1;
	private JButton enter2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateScreen frame = new UpdateScreen();
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
	public UpdateScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Updating artist nationality
		header1.setHorizontalAlignment(SwingConstants.CENTER);
		header1.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header1.setBounds(0, 20, 450, 20);
		contentPane.add(header1);
		nat_from.setFont(new Font("Arial", Font.PLAIN, 13));
		
		nat_from.setBounds(35, 60, 140, 20);
		contentPane.add(nat_from);
		nat_to.setFont(new Font("Arial", Font.PLAIN, 13));
		
		nat_to.setBounds(35, 90, 140, 20);
		contentPane.add(nat_to);
		
		
		textField_nat_from.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_nat_from.setBounds(185, 60, 225, 20);
		contentPane.add(textField_nat_from);
		textField_nat_from.setColumns(10);
		
		textField_nat_to.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_nat_to.setBounds(185, 90, 225, 20);
		contentPane.add(textField_nat_to);
		textField_nat_to.setColumns(10);
		
		enter1 = new JButton("ENTER");
		enter1.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter1.setBounds(162, 122, 117, 29);
		contentPane.add(enter1);
		
		enter1.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				String art_nat_from = textField_nat_from.getText();
				String art_nat_to = textField_nat_to.getText();
				Update.updateArtNat(art_nat_from, art_nat_to);
				dispose();
			}
		});
		
		// Updating record length
		header2.setHorizontalAlignment(SwingConstants.CENTER);
		header2.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header2.setBounds(0, 163, 450, 20);
		contentPane.add(header2);
		
		min_sec.setFont(new Font("Arial", Font.PLAIN, 13));
		min_sec.setBounds(35, 203, 140, 20);
		contentPane.add(min_sec);
		
		enter2 = new JButton("ENTER");
		enter2.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter2.setBounds(162, 235, 117, 29);
		contentPane.add(enter2);
		textField_min_sec.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_min_sec.setColumns(10);
		textField_min_sec.setBounds(185, 203, 225, 20);
		
		contentPane.add(textField_min_sec);
		
		enter2.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				int song_min_sec = Integer.parseInt(textField_min_sec.getText());
				try {
					Update.updateLenDate(song_min_sec);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
	}

}
