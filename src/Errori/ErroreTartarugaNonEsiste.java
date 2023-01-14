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

public class ErroreTartarugaNonEsiste extends JFrame {

	private JPanel contentPane;
	private JTextField txtLaTartarugaInserita;

	

	/**
	 * Create the frame.
	 */
	public ErroreTartarugaNonEsiste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLaTartarugaInserita = new JTextField();
		txtLaTartarugaInserita.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtLaTartarugaInserita.setText("La tartaruga inserita non esiste!");
		txtLaTartarugaInserita.setEditable(false);
		txtLaTartarugaInserita.setBounds(66, 24, 679, 108);
		contentPane.add(txtLaTartarugaInserita);
		txtLaTartarugaInserita.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreTartarugaNonEsiste();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(262, 288, 246, 100);
		contentPane.add(btnNewButton);
	}

}
