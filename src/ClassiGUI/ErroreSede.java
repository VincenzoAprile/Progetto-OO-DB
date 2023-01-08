package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreSede extends JFrame {

	private JPanel contentPane;
	private JTextField txtGiEsisteUna;

	

	/**
	 * Create the frame.
	 */
	public ErroreSede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreSede();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(268, 284, 85, 41);
		contentPane.add(btnNewButton);
		
		txtGiEsisteUna = new JTextField();
		txtGiEsisteUna.setText("Già esiste una sede con quell'ID!");
		txtGiEsisteUna.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtGiEsisteUna.setBounds(43, 102, 500, 144);
		contentPane.add(txtGiEsisteUna);
		txtGiEsisteUna.setColumns(10);
	}
}
