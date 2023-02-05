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
	private JTextField IDAmmissione;
	private JTextField Centro;
	private JRadioButton Riammissione;

	AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField Mese;
	private JTextField Anno;
	private JTextField Giorno;
	private JButton btnNewButton_1;
	
	Controller controller = Controller.GetIstanza();
	
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
				if (Centro.getText().equals("") || IDAmmissione.getText().equals("") || Anno.getText().equals("") || 
					Mese.getText().equals("") || Giorno.getText().equals("")) {
					
					setVisible(false);
					controller.AppareMainGUI();
					controller.AppareErroreGenerico();
					
					
				}
				else {
					if (Mese.getText().length() == 1) {
						Mese.setText("0"+Mese.getText());
					}                                          //QUESTI DUE IF CORREGGONO IL FORMATO DEL MESE E DEL GIORNO IN CASO SIA STATO
					if (Giorno.getText().length() == 1) {      //INSERITO COME ESEMPIO: 3 AL POSTO DI 03 
						Giorno.setText("0"+Giorno.getText());
					}
					
					temp.setDataDiAmmissione(Anno.getText()+"-"+Mese.getText()+"-"+Giorno.getText());
					temp.setIDAmmissione(IDAmmissione.getText());
					temp.setCentro(Centro.getText());
					
					
					if (Riammissione.isSelected()) {
						temp.setRiammissione("TRUE");
						controller.ControllerPassaTartarugaTrue(temp);
						setVisible(false);
						controller.AppareSetTartarugaTrue();
						controller.PassaPerIlAmmissioneDAO(temp);
						
					}
					else {
						temp.setRiammissione("FALSE");
						controller.ControllerPassaTartarugaFalse(temp);
						setVisible(false);
						controller.AppareSetTartarugaFalse();
						controller.PassaPerIlAmmissioneDAO(temp);
						
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(116, 349, 205, 74);
		contentPane.add(btnNewButton);
		
		Mese = new JTextField();
		Mese.setBounds(261, 204, 170, 52);
		contentPane.add(Mese);
		Mese.setColumns(10);
		
		Anno = new JTextField();
		Anno.setBounds(261, 266, 170, 52);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		Giorno = new JTextField();
		Giorno.setBounds(261, 132, 170, 52);
		contentPane.add(Giorno);
		Giorno.setColumns(10);
		
		btnNewButton_1 = new JButton("Ammissioni e Tartarughe");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewAmmissioniTartarughe();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(544, 349, 304, 74);
		contentPane.add(btnNewButton_1);
	}
}
