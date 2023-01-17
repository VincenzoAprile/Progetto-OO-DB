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

public class ErroreIDCartellaClinica extends JFrame {

	private JPanel contentPane;
	private JTextField txtEsisteGiUna;




	/**
	 * Create the frame.
	 */
	public ErroreIDCartellaClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEsisteGiUna = new JTextField();
		txtEsisteGiUna.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtEsisteGiUna.setEditable(false);
		txtEsisteGiUna.setText("Esiste già una cartella clinica con quell'id");
		txtEsisteGiUna.setBounds(32, 32, 790, 145);
		contentPane.add(txtEsisteGiUna);
		txtEsisteGiUna.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(292, 324, 257, 84);
		contentPane.add(btnNewButton);
	}
}
