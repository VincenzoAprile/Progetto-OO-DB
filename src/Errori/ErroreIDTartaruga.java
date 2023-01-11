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

public class ErroreIDTartaruga extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiEsisteUna;

	
	/**
	 * Create the frame.
	 */
	public ErroreIDTartaruga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGiEsisteUna = new JTextField();
		txtGiEsisteUna.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtGiEsisteUna.setText("Già esiste una tartaruga con quell'id");
		txtGiEsisteUna.setEditable(false);
		txtGiEsisteUna.setBounds(25, 10, 798, 86);
		contentPane.add(txtGiEsisteUna);
		txtGiEsisteUna.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreIDTartaruga();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(324, 288, 225, 86);
		contentPane.add(btnNewButton);
	}

}
