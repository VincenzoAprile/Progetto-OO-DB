package Errori;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreTarghettaEsistente extends JFrame {

	private JPanel contentPane;
	private JTextField txtEsisteGiUna;

	

	/**
	 * Create the frame.
	 */
	public ErroreTarghettaEsistente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEsisteGiUna = new JTextField();
		txtEsisteGiUna.setFont(new Font("Tahoma", Font.PLAIN, 29));
		txtEsisteGiUna.setText("Esiste già una tartaruga con quella targhetta nel database\r\n");
		txtEsisteGiUna.setEditable(false);
		txtEsisteGiUna.setBounds(30, 26, 793, 75);
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
		btnNewButton.setBounds(326, 283, 209, 75);
		contentPane.add(btnNewButton);
	}

}
