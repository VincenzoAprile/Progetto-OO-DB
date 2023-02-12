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
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SetAmmissione extends JFrame {

	private JPanel contentPane;
	private JTextField IDAmmissione;
	private JTextField Centro;
	private JRadioButton Riammissione;

	AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField Mese;
	private JTextField Anno;
	private JTextField Giorno;
	private JButton btnNewButton_1;
	
	Controller controller = Controller.GetIstanza();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	/**
	 * Create the frame.
	 */
	public SetAmmissione() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetAmmissione.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Aggiungi una tartaruga\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton Riammissione = new JRadioButton("");
		Riammissione.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Riammissione.setBounds(880, 105, 21, 21);
		contentPane.add(Riammissione);
		
		IDAmmissione = new JTextField();
		IDAmmissione.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDAmmissione.setBounds(620, 260, 185, 56);
		contentPane.add(IDAmmissione);
		IDAmmissione.setColumns(10);
		
		Centro = new JTextField();
		Centro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Centro.setBounds(736, 160, 190, 57);
		contentPane.add(Centro);
		Centro.setColumns(10);
		
		JButton btnNewButton = new JButton("Invio");
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
		btnNewButton.setBounds(566, 730, 205, 74);
		contentPane.add(btnNewButton);
		
		Mese = new JTextField();
		Mese.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Mese.setBounds(195, 307, 44, 52);
		contentPane.add(Mese);
		Mese.setColumns(10);
		
		Anno = new JTextField();
		Anno.setText("\r\n");
		Anno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Anno.setBounds(210, 387, 67, 52);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		Giorno = new JTextField();
		Giorno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Giorno.setBounds(195, 227, 44, 52);
		contentPane.add(Giorno);
		Giorno.setColumns(10);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetAmmissione.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewAmmissioniTartarughe();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(725, 566, 80, 80);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Inserire le informazioni riguardanti la ammissione della tartaruga.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 961, 52);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Data di ammissione:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(42, 164, 265, 41);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Giorno (DD):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(42, 226, 175, 52);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mese (MM):\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(42, 300, 175, 52);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Anno (YYYY):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(42, 387, 175, 52);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Sede di ammissione (ID):");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(436, 158, 304, 52);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("ID Ammissione:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(435, 261, 175, 52);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Visualizza tutte le ammissioni e le tartarughe corrispondenti:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(42, 579, 698, 52);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(SetAmmissione.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.setBounds(1409, 730, 80, 80);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_8 = new JLabel("Torna indietro:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(1237, 739, 252, 52);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_10 = new JLabel("Se la tartaruga è stata già ammessa in un centro di recupero, spuntare qui:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(42, 92, 884, 41);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(SetAmmissione.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_9.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_9);
		
	}
}
