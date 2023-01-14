package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.AmmissioneTartaruga;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SetAmmissione extends JFrame {

	private JPanel contentPane;
	private JTextField txtRiammessoDataDi;
	private JTextField Data;
	private JTextField IDAmmissione;
	private JTextField Centro;
	private JRadioButton Riammissione;

	AmmissioneTartaruga temp = new AmmissioneTartaruga();
	
	/**
	 * Create the frame.
	 */
	public SetAmmissione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRiammessoDataDi = new JTextField();
		txtRiammessoDataDi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRiammessoDataDi.setText("Riammesso?                  Data Di Ammissione(YYYY-MM-DD)        IDAmmissione            Centro");
		txtRiammessoDataDi.setEditable(false);
		txtRiammessoDataDi.setBounds(43, 33, 863, 52);
		contentPane.add(txtRiammessoDataDi);
		txtRiammessoDataDi.setColumns(10);
		
		JRadioButton Riammissione = new JRadioButton("è stato già ammesso?");
		Riammissione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Riammissione.setBounds(6, 132, 179, 52);
		contentPane.add(Riammissione);
		
		Data = new JTextField();
		Data.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Data.setBounds(261, 132, 214, 52);
		contentPane.add(Data);
		Data.setColumns(10);
		
		IDAmmissione = new JTextField();
		IDAmmissione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDAmmissione.setBounds(586, 135, 185, 52);
		contentPane.add(IDAmmissione);
		IDAmmissione.setColumns(10);
		
		Centro = new JTextField();
		Centro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Centro.setBounds(818, 132, 88, 52);
		contentPane.add(Centro);
		Centro.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Centro.getText().equals("") || IDAmmissione.getText().equals("") || Centro.getText().equals("")) {
					Controller.ScompareSetAmmissione();
					Controller.AppareMainGUI();
					Controller.AppareErroreGenerico();
					
					Centro.setText("");
					IDAmmissione.setText("");
					Data.setText("");
				}
				else {
					temp.setDataDiAmmissione(Data.getText());
					temp.setIDAmmssione(IDAmmissione.getText());
					temp.setCentro(Centro.getText());
					
					
					if (Riammissione.isSelected()) {
						temp.setRiammissione("TRUE");
						Controller.ControllerPassaTartarugaTrue(temp);
						Controller.ScompareSetAmmissione();
						Controller.AppareSetTartarugaTrue();
						Controller.PassaPerIlAmmissioneDAO(temp);
						
						Centro.setText("");
						IDAmmissione.setText("");
						Data.setText("");
						Riammissione.doClick();
					}
					else {
						temp.setRiammissione("FALSE");
						Controller.ControllerPassaTartarugaFalse(temp);
						Controller.ScompareSetAmmissione();
						Controller.AppareSetTartarugaFalse();
						Controller.PassaPerIlAmmissioneDAO(temp);
						
						Centro.setText("");
						IDAmmissione.setText("");
						Data.setText("");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(343, 331, 205, 74);
		contentPane.add(btnNewButton);
	}
}
