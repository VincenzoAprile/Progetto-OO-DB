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

public class ErroreVeterinarioOrData extends JFrame {

	private JPanel contentPane;
	private JTextField txtIlVeterinarioInserito;
	private JTextField txtOppureLaData;



	/**
	 * Create the frame.
	 */
	public ErroreVeterinarioOrData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIlVeterinarioInserito = new JTextField();
		txtIlVeterinarioInserito.setText("Il veterinario inserito non è presente nella sede corrispondente");
		txtIlVeterinarioInserito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIlVeterinarioInserito.setEditable(false);
		txtIlVeterinarioInserito.setBounds(35, 30, 648, 92);
		contentPane.add(txtIlVeterinarioInserito);
		txtIlVeterinarioInserito.setColumns(10);
		
		txtOppureLaData = new JTextField();
		txtOppureLaData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOppureLaData.setText("Oppure la data inserita non è valida (deve essere SUCCESSIVA alla data di ammissione corrispondente)");
		txtOppureLaData.setEditable(false);
		txtOppureLaData.setBounds(35, 189, 648, 74);
		contentPane.add(txtOppureLaData);
		txtOppureLaData.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(305, 321, 159, 61);
		contentPane.add(btnNewButton);
	}
}
