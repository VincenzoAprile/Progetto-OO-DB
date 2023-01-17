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

public class ErroreVascaTartaruga extends JFrame {

	private JPanel contentPane;
	private JTextField txtLaTarghettaO;

	

	/**
	 * Create the frame.
	 */
	public ErroreVascaTartaruga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLaTarghettaO = new JTextField();
		txtLaTarghettaO.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtLaTarghettaO.setText("La targhetta o l'id della vasca non sono stati inseriti correttamente");
		txtLaTarghettaO.setEditable(false);
		txtLaTarghettaO.setBounds(10, 10, 842, 96);
		contentPane.add(txtLaTarghettaO);
		txtLaTarghettaO.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(320, 287, 206, 78);
		contentPane.add(btnNewButton);
	}

}
