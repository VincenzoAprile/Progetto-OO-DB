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

public class ErroreDipendente extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiEsisteUn;

	
	/**
	 * Create the frame.
	 */
	public ErroreDipendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGiEsisteUn = new JTextField();
		txtGiEsisteUn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiEsisteUn.setText("Già esiste un dipendente con quell'id");
		txtGiEsisteUn.setEditable(false);
		txtGiEsisteUn.setBounds(58, 36, 419, 84);
		contentPane.add(txtGiEsisteUn);
		txtGiEsisteUn.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreDipendente();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton.setBounds(204, 217, 140, 62);
		contentPane.add(btnNewButton);
	}

}
