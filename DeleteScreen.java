package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Delete;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_lang;
	JLabel header = new JLabel("Delete language");
	JLabel lang = new JLabel("Language:");
	JButton enter = new JButton("ENTER");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteScreen frame = new DeleteScreen();
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
	public DeleteScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		header.setBounds(0, 20, 450, 20);
		contentPane.add(header);
		
		lang.setFont(new Font("Arial", Font.PLAIN, 13));
		lang.setBounds(35, 60, 140, 20);
		contentPane.add(lang);
		
		textField_lang = new JTextField();
		textField_lang.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_lang.setColumns(10);
		textField_lang.setBounds(185, 60, 225, 20);
		contentPane.add(textField_lang);
		
		enter.setFont(new Font("Marker Felt", Font.PLAIN, 11));
		enter.setBounds(165, 90, 120, 30);
		contentPane.add(enter);
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lang_lang = textField_lang.getText();
				Delete.deleteLang(lang_lang);
				dispose();
			}
		});
	}

}
