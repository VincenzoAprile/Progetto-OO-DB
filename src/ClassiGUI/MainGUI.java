package ClassiGUI;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuestaLa;

	

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuestaLa = new JTextField();
		txtQuestaLa.setBackground(Color.CYAN);
		txtQuestaLa.setEditable(false);
		txtQuestaLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtQuestaLa.setText("Questa è la schermata principale\r\n");
		txtQuestaLa.setBounds(69, 39, 272, 80);
		contentPane.add(txtQuestaLa);
		txtQuestaLa.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi qualcosa");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.AppareAddNew();
				Controller.ScopareMainGUI();
			}
		});
		btnNewButton.setBounds(69, 295, 243, 73);
		contentPane.add(btnNewButton);
	}
}
