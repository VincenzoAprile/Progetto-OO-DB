package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.AmmissioneTartaruga;
import PackageController.Controller;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class SetTartarugaFalse extends JFrame {

	private JPanel contentPane;
	
	private static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField txtNomeTarghetta;
	private JTextField Nome;
	private JTextField Targhetta;

	public static void PassaASetTartarugaFalse(AmmissioneTartaruga boh) {
		temp = boh;
	}


	/**
	 * Create the frame.
	 */
	public SetTartarugaFalse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp.setNome(Nome.getText());
				temp.setTarghetta(Targhetta.getText());
				Controller.AppareMainGUI();
				
				Controller.PassaPerIlTartarugaDAO(temp);
				
				Controller.ScompareSetTartarugaFalse();
			}
		});
		btnNewButton.setBounds(350, 271, 173, 70);
		contentPane.add(btnNewButton);
		
		txtNomeTarghetta = new JTextField();
		txtNomeTarghetta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNomeTarghetta.setEditable(false);
		txtNomeTarghetta.setText("Nome           Targhetta");
		txtNomeTarghetta.setBounds(33, 30, 581, 64);
		contentPane.add(txtNomeTarghetta);
		txtNomeTarghetta.setColumns(10);
		
		Nome = new JTextField();
		Nome.setBounds(10, 132, 109, 64);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		Targhetta = new JTextField();
		Targhetta.setBounds(181, 132, 173, 64);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
	}

}
