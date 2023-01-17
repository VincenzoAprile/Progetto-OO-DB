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

public class ErroreIDDocumentazione extends JFrame {

	private JPanel contentPane;
	private JTextField txtEsisteGiUna;

	

	/**
	 * Create the frame.
	 */
	public ErroreIDDocumentazione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEsisteGiUna = new JTextField();
		txtEsisteGiUna.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtEsisteGiUna.setText("Esiste Già una Documentazione con quell'id");
		txtEsisteGiUna.setEditable(false);
		txtEsisteGiUna.setBounds(30, 27, 733, 113);
		contentPane.add(txtEsisteGiUna);
		txtEsisteGiUna.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(299, 291, 196, 88);
		contentPane.add(btnNewButton);
	}

}
