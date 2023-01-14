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

public class ErroreCentroNonEsiste extends JFrame {

	private JPanel contentPane;
	private JTextField txtIlCentroInserito;

	
	/**
	 * Create the frame.
	 */
	public ErroreCentroNonEsiste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIlCentroInserito = new JTextField();
		txtIlCentroInserito.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtIlCentroInserito.setText("Il centro inserito non esiste!");
		txtIlCentroInserito.setEditable(false);
		txtIlCentroInserito.setBounds(56, 65, 628, 90);
		contentPane.add(txtIlCentroInserito);
		txtIlCentroInserito.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreCentroNonEsiste();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(308, 295, 135, 46);
		contentPane.add(btnNewButton);
	}

}
