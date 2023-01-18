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

public class ErroreTarghettaNonTrovata extends JFrame {

	private JPanel contentPane;
	private JTextField txtLaTarghettaNon;

	

	/**
	 * Create the frame.
	 */
	public ErroreTarghettaNonTrovata() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLaTarghettaNon = new JTextField();
		txtLaTarghettaNon.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtLaTarghettaNon.setText("La targhetta non esiste nel database");
		txtLaTarghettaNon.setEditable(false);
		txtLaTarghettaNon.setBounds(21, 21, 762, 93);
		contentPane.add(txtLaTarghettaNon);
		txtLaTarghettaNon.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(294, 329, 215, 93);
		contentPane.add(btnNewButton);
	}
}
