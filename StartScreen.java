package windows;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Spotify;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StartScreen extends JFrame {

	private JPanel contentPane;
	JLabel press_connect = new JLabel("Press connect to continue");
	JButton connect = new JButton("CONNECT");
	private final JLabel background = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen frame = new StartScreen();
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
	public StartScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connect.setFont(new Font("Marker Felt", Font.PLAIN, 13));
		
		connect.setBounds(329, 598, 142, 29);
		contentPane.add(connect);
		
		press_connect.setForeground(new Color(143, 188, 143));
		press_connect.setFont(new Font("Marker Felt", Font.PLAIN, 28));
		press_connect.setHorizontalAlignment(SwingConstants.CENTER);
		press_connect.setBounds(0, 552, 800, 44);
		contentPane.add(press_connect);
		background.setIcon(new ImageIcon("/Users/katejeon/Documents/Spring_2020/CPSC_20471/spotify_project/background.png"));
		background.setBounds(0, 0, 800, 678);
		
		contentPane.add(background);
		
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spotify.connect();
				new MainScreen().setVisible(true);
				dispose();
			}
		}
		);
		
	}

}
