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
import ClassiDAO.AmmissioneTartarugaDAO;

public class SetTartarugaTrue extends JFrame {

	private JPanel contentPane;

	static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField txtVecchiaTarghettaNuova;
	private JTextField VecchiaTarghetta;
	private JTextField NuovaTarghetta;
	
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
		txtVecchiaTarghettaNuova.setText("Vecchia targhetta                      Nuova targhetta");
		txtVecchiaTarghettaNuova.setEditable(false);
		txtVecchiaTarghettaNuova.setBounds(10, 10, 803, 59);
		contentPane.add(txtVecchiaTarghettaNuova);
		txtVecchiaTarghettaNuova.setColumns(10);
		
		VecchiaTarghetta = new JTextField();
		VecchiaTarghetta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VecchiaTarghetta.setBounds(26, 141, 193, 59);
		contentPane.add(VecchiaTarghetta);
		VecchiaTarghetta.setColumns(10);
		
		NuovaTarghetta = new JTextField();
		NuovaTarghetta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NuovaTarghetta.setBounds(368, 141, 212, 59);
		contentPane.add(NuovaTarghetta);
		NuovaTarghetta.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (VecchiaTarghetta.getText().equals("") || NuovaTarghetta.getText().equals("")) {
					Controller.AppareMainGUI();
					setVisible(false);
					Controller.AppareErroreGenerico();
					Controller.AmmissioneIndebita(temp);
				}
				else {
					temp.setTarghetta(NuovaTarghetta.getText());
					temp.setNome(AmmissioneTartarugaDAO.CercaNomeTartaruga(VecchiaTarghetta.getText()));
					
					Controller.AppareMainGUI();
					
					if (temp.getNome() == null) {
						Controller.AmmissioneIndebita(temp);  //CERCANOMETARTARUGA RESTITUISCE NULL SE NON TROVA NIENTE O FA ERRORE
						Controller.AppareErroreGenerico();
					}
					else {
						Controller.PassaPerIlTartarugaDAO(temp);
					}
					setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(338, 301, 139, 59);
		contentPane.add(btnNewButton);
	}
}
