package Errori;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreStatoTartaruga extends JFrame {

	private JPanel contentPane;
	private JTextField txtNellePartiDella;

	
	/**
	 * Create the frame.
	 */
	public ErroreStatoTartaruga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNellePartiDella = new JTextField();
		txtNellePartiDella.setText("Nelle parti della tartaruga si devono inserire solo espressioni valide");
		txtNellePartiDella.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNellePartiDella.setEditable(false);
		txtNellePartiDella.setBounds(0, 10, 810, 105);
		contentPane.add(txtNellePartiDella);
		txtNellePartiDella.setColumns(10);
		
		JTextArea txtrEspressioniValideCompromesso = new JTextArea();
		txtrEspressioniValideCompromesso.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtrEspressioniValideCompromesso.setText("Espressioni Valide:\r\nCompromesso\r\nCon ferite profonde\r\nCon ferite superficiali\r\nBuono\r\nPerfetto");
		txtrEspressioniValideCompromesso.setEditable(false);
		txtrEspressioniValideCompromesso.setBounds(10, 155, 410, 257);
		contentPane.add(txtrEspressioniValideCompromesso);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(549, 214, 218, 105);
		contentPane.add(btnNewButton);
	}
}
