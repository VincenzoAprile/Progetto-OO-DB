package Errori;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreSpecifico extends JFrame {

	private JPanel contentPane;
	private JTextField MessaggioDiErrore;
	

	/**
	 * Create the frame.
	 */
	public ErroreSpecifico(String Errore) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(365, 305, 127, 61);
		contentPane.add(btnNewButton);
		
		MessaggioDiErrore = new JTextField();
		MessaggioDiErrore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MessaggioDiErrore.setEditable(false);
		MessaggioDiErrore.setBounds(30, 39, 796, 89);
		contentPane.add(MessaggioDiErrore);
		MessaggioDiErrore.setColumns(10);
		MessaggioDiErrore.setText(Errore);
	}
}
