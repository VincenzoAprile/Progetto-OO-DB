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

public class ErroreDataNonValida extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataInseritaNon;

	
	/**
	 * Create the frame.
	 */
	public ErroreDataNonValida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDataInseritaNon = new JTextField();
		txtDataInseritaNon.setText("Data inserita non valida");
		txtDataInseritaNon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDataInseritaNon.setBounds(27, 24, 861, 79);
		contentPane.add(txtDataInseritaNon);
		txtDataInseritaNon.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreDataNonValida();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(359, 304, 165, 73);
		contentPane.add(btnNewButton);
	}

}
