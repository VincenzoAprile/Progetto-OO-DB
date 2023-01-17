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

public class ErroreDimesioneVasca extends JFrame {

	private JPanel contentPane;
	private JTextField txtInUnoDelle;

	
	/**
	 * Create the frame.
	 */
	public ErroreDimesioneVasca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInUnoDelle = new JTextField();
		txtInUnoDelle.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtInUnoDelle.setEditable(false);
		txtInUnoDelle.setText("In uno delle dimensioni della vasca hai inserito un dato non valido!");
		txtInUnoDelle.setBounds(10, 10, 859, 86);
		contentPane.add(txtInUnoDelle);
		txtInUnoDelle.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(323, 254, 187, 86);
		contentPane.add(btnNewButton);
	}

}
