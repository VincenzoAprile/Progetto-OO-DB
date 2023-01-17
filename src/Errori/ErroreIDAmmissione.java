package Errori;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreIDAmmissione extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiEsisteUnammissione;

	

	/**
	 * Create the frame.
	 */
	public ErroreIDAmmissione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGiEsisteUnammissione = new JTextField();
		txtGiEsisteUnammissione.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtGiEsisteUnammissione.setText("Già esiste un'ammissione con quell'id");
		txtGiEsisteUnammissione.setEditable(false);
		txtGiEsisteUnammissione.setBounds(77, 51, 664, 95);
		contentPane.add(txtGiEsisteUnammissione);
		txtGiEsisteUnammissione.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(327, 272, 164, 61);
		contentPane.add(btnNewButton);
	}
}
