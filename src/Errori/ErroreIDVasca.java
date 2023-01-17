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

public class ErroreIDVasca extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiEsisteUna;

	

	/**
	 * Create the frame.
	 */
	public ErroreIDVasca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGiEsisteUna = new JTextField();
		txtGiEsisteUna.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtGiEsisteUna.setText("Già esiste una vasca con quell'id");
		txtGiEsisteUna.setEditable(false);
		txtGiEsisteUna.setBounds(10, 10, 852, 111);
		contentPane.add(txtGiEsisteUna);
		txtGiEsisteUna.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(342, 321, 168, 68);
		contentPane.add(btnNewButton);
	}

}
