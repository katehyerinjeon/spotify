package windows;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Delete;
import database.Insert;
import database.Print;
import database.Spotify;
import database.Update;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	JButton insert = new JButton("INSERT");
	JButton update = new JButton("UPDATE");
	JButton select = new JButton("SELECT");
	JButton delete = new JButton("DELETE");
	JButton print_all = new JButton("PRINT ALL");
	JButton exit = new JButton("EXIT");
	JLabel press_exit = new JLabel("Press exit to terminate");
	JScrollPane scrollPane = new JScrollPane();
	public static JTextArea textArea = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		insert.setFont(new Font("Marker Felt", Font.PLAIN, 17));
		insert.setBounds(25, 34, 134, 40);
		contentPane.add(insert);
		
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertScreen().setVisible(true);
			}
		});
		
		update.setFont(new Font("Marker Felt", Font.PLAIN, 17));
		update.setBounds(334, 34, 134, 40);
		contentPane.add(update);
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateScreen().setVisible(true);
			}
		});
		
		select.setFont(new Font("Marker Felt", Font.PLAIN, 17));
		select.setBounds(180, 34, 134, 40);
		contentPane.add(select);
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectScreen().setVisible(true);
			}
		});
		
		delete.setFont(new Font("Marker Felt", Font.PLAIN, 17));
		delete.setBounds(490, 34, 134, 40);
		contentPane.add(delete);
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteScreen().setVisible(true);
			}
		});
		
		print_all.setFont(new Font("Marker Felt", Font.PLAIN, 17));
		print_all.setBounds(645, 34, 134, 40);
		contentPane.add(print_all);
		
		print_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print.printAll();
			}
		});
		
		scrollPane.setBounds(25, 112, 754, 445);
		contentPane.add(scrollPane);
		
		textArea.setFont(new Font("Courier", Font.PLAIN, 14));
		scrollPane.setViewportView(textArea);
		
		textArea.setText("... Connected to database " + Spotify.db + " in MySQL with " + Spotify.conn.toString() + " ...\n");
		
		exit.setFont(new Font("Marker Felt", Font.PLAIN, 13));
		exit.setBounds(329, 617, 142, 29);
		contentPane.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spotify.close();
			}
		});
		
		press_exit.setHorizontalAlignment(SwingConstants.CENTER);
		press_exit.setForeground(new Color(0, 0, 0));
		press_exit.setFont(new Font("Marker Felt", Font.PLAIN, 28));
		press_exit.setBounds(0, 571, 800, 44);
		contentPane.add(press_exit);
	}
}
