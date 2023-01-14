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

public class ErroreFloatCartellaClinica extends JFrame {

	private JPanel contentPane;
	private JTextField txtPerLunghezzaLarghezza;

	/**
	 * Create the frame.
	 */
	public ErroreFloatCartellaClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPerLunghezzaLarghezza = new JTextField();
		txtPerLunghezzaLarghezza.setText("Per Lunghezza, Larghezza e Peso inserire valori validi! (int o float CON IL PUNTO)");
		txtPerLunghezzaLarghezza.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtPerLunghezzaLarghezza.setEditable(false);
		txtPerLunghezzaLarghezza.setBounds(20, 10, 795, 88);
		contentPane.add(txtPerLunghezzaLarghezza);
		txtPerLunghezzaLarghezza.setColumns(10);
		
		JButton btnNewButton = new JButton("OK\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreFloatCartellaClinica();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(290, 323, 215, 71);
		contentPane.add(btnNewButton);
	}

}
