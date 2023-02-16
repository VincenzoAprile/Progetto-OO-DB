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
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SetTartarugaTrue extends JFrame {
	
	private static SetTartarugaTrue IstanzaSetTartarugaTrue = null;
	
	/*LOGICA DEL PATTERN SINGLETON*/
	public static SetTartarugaTrue GetIstanza() {
		if (IstanzaSetTartarugaTrue == null) {
			IstanzaSetTartarugaTrue = new SetTartarugaTrue();
		}
		return IstanzaSetTartarugaTrue;
	}
	
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;

	static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField Targhetta;
	private JTextField IDTartaruga;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	public static void PassaASetTartarugaTrue(AmmissioneTartaruga boh) {
		temp = boh;
	}

	/**
	 * Create the frame.
	 */
	public SetTartarugaTrue() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetTartarugaTrue.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Aggiungi le informazioni della tartaruga");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Targhetta = new JTextField();
		Targhetta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Targhetta.setBounds(162, 145, 193, 49);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
		
		IDTartaruga = new JTextField();
		IDTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IDTartaruga.setBounds(330, 250, 212, 49);
		contentPane.add(IDTartaruga);
		IDTartaruga.setColumns(10);
		
		JButton btnNewButton = new JButton("Invio");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Targhetta.getText().equals("") || IDTartaruga.getText().equals("")) {
					controller.AppareMainGUI();
					setVisible(false);
					controller.AppareErroreGenerico();
					controller.AmmissioneIndebita(temp);
					
					Targhetta.setText("");
					IDTartaruga.setText("");
				}
				else {
					temp.setTarghetta(Targhetta.getText());
					temp.setIDTartaruga(IDTartaruga.getText());
					temp.setNome(controller.TrovaNomeTartaruga(Targhetta.getText()));
					
					controller.AppareMainGUI();
					
					if (temp.getNome() == null) {
						controller.AmmissioneIndebita(temp);  //CERCANOMETARTARUGA RESTITUISCE NULL SE NON TROVA NIENTE O FA ERRORE
						controller.AppareErroreSpecifico("La targhetta non esiste nel database!");
						System.out.println("La targhetta inserita non esiste nel database");
					}
					else {
						controller.PassaPerIlTartarugaDAO(temp);
					}
					setVisible(false);
					
					Targhetta.setText("");
					IDTartaruga.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(680, 679, 168, 80);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetTartarugaTrue.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(615, 444, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Compila le informazioni della tartaruga.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 1020, 64);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Targhetta:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(41, 146, 226, 48);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nuovo ID della tartaruga:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(41, 248, 298, 48);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Visualizza le Tartarughe e le rispettive Ammissioni:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(41, 454, 615, 48);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SetTartarugaTrue.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_4);
	}
}
