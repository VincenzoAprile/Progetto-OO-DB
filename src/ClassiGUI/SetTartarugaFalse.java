package ClassiGUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAO.AmmissioneDAO;
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
	private JTextField IDTartaruga;
	private JButton btnNewButton_1;

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
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Nome.getText().equals("") || Targhetta.getText().equals("") || IDTartaruga.getText().equals("")) {
					Controller.AppareMainGUI();
					setVisible(false);
					Controller.AppareErroreGenerico();
					Controller.AmmissioneIndebita(temp);
					
					Nome.setText("");
					Targhetta.setText("");
					IDTartaruga.setText("");
					
				}
				else {
					temp.setNome(Nome.getText());
					temp.setTarghetta(Targhetta.getText());
					temp.setIDTartaruga(IDTartaruga.getText());
					Controller.AppareMainGUI();
					
					Controller.PassaPerIlTartarugaDAO(temp);
					
					setVisible(false);
					
					Nome.setText("");
					Targhetta.setText("");
					IDTartaruga.setText("");
				}
			}
		});
		btnNewButton.setBounds(108, 294, 173, 70);
		contentPane.add(btnNewButton);
		
		txtNomeTarghetta = new JTextField();
		txtNomeTarghetta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNomeTarghetta.setEditable(false);
		txtNomeTarghetta.setText("Nome           Targhetta                  ID_Tartaruga");
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
		
		IDTartaruga = new JTextField();
		IDTartaruga.setBounds(408, 132, 221, 64);
		contentPane.add(IDTartaruga);
		IDTartaruga.setColumns(10);
		
		btnNewButton_1 = new JButton("Ammissioni e Tartarughe");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ViewAmmissioniTartarughe();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(497, 287, 336, 70);
		contentPane.add(btnNewButton_1);
	}

}
