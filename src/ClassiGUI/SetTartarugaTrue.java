package ClassiGUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.AmmissioneTartaruga;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ClassiDAO.AmmissioneDAO;
import ClassiDAO.TartarugaDAO;

public class SetTartarugaTrue extends JFrame {

	private JPanel contentPane;

	static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField txtVecchiaTarghettaNuova;
	private JTextField Targhetta;
	private JTextField IDTartaruga;
	
	public static void PassaASetTartarugaTrue(AmmissioneTartaruga boh) {
		temp = boh;
	}

	/**
	 * Create the frame.
	 */
	public SetTartarugaTrue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtVecchiaTarghettaNuova = new JTextField();
		txtVecchiaTarghettaNuova.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtVecchiaTarghettaNuova.setText("   Targhetta                                 ID_Tartaruga");
		txtVecchiaTarghettaNuova.setEditable(false);
		txtVecchiaTarghettaNuova.setBounds(10, 10, 803, 59);
		contentPane.add(txtVecchiaTarghettaNuova);
		txtVecchiaTarghettaNuova.setColumns(10);
		
		Targhetta = new JTextField();
		Targhetta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Targhetta.setBounds(26, 141, 193, 59);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
		
		IDTartaruga = new JTextField();
		IDTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IDTartaruga.setBounds(368, 141, 212, 59);
		contentPane.add(IDTartaruga);
		IDTartaruga.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Targhetta.getText().equals("") || IDTartaruga.getText().equals("")) {
					Controller.AppareMainGUI();
					setVisible(false);
					Controller.AppareErroreGenerico();
					Controller.AmmissioneIndebita(temp);
					
					Targhetta.setText("");
					IDTartaruga.setText("");
				}
				else {
					temp.setTarghetta(Targhetta.getText());
					temp.setIDTartaruga(IDTartaruga.getText());
					temp.setNome(Controller.TrovaNomeTartaruga(Targhetta.getText()));
					
					Controller.AppareMainGUI();
					
					if (temp.getNome() == null) {
						Controller.AmmissioneIndebita(temp);  //CERCANOMETARTARUGA RESTITUISCE NULL SE NON TROVA NIENTE O FA ERRORE
						Controller.AppareErroreTarghettaNonTrovata();
						System.out.println("La targhetta inserita non esiste nel database");
					}
					else {
						Controller.PassaPerIlTartarugaDAO(temp);
					}
					setVisible(false);
					
					Targhetta.setText("");
					IDTartaruga.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(338, 301, 139, 59);
		contentPane.add(btnNewButton);
	}
}
