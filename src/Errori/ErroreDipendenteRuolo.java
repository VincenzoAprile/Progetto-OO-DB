package Errori;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import PackageController.Controller;

public class ErroreDipendenteRuolo extends JFrame {

	private JPanel contentPane;
	private JTextField txtIlRuoloInserito;

	
	/**
	 * Create the frame.
	 */
	public ErroreDipendenteRuolo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIlRuoloInserito = new JTextField();
		txtIlRuoloInserito.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtIlRuoloInserito.setText("Il ruolo inserito non esiste");
		txtIlRuoloInserito.setEditable(false);
		txtIlRuoloInserito.setBounds(62, 96, 470, 117);
		contentPane.add(txtIlRuoloInserito);
		txtIlRuoloInserito.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(247, 278, 119, 73);
		contentPane.add(btnNewButton);
	}
}
