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
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SetTartarugaFalse extends JFrame {
	
	private static SetTartarugaFalse IstanzaSetTartarugaFalse = null;
	
	
	
	/*LOGICA DEL PATTERN SINGLETON*/
	public static SetTartarugaFalse GetIstanza() {
		if (IstanzaSetTartarugaFalse == null) {
			IstanzaSetTartarugaFalse = new SetTartarugaFalse();
		}
		return IstanzaSetTartarugaFalse;
	}
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	
	private static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField Nome;
	private JTextField Targhetta;
	private JTextField IDTartaruga;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	public static void PassaASetTartarugaFalse(AmmissioneTartaruga boh) {
		temp = boh;
	}


	/**
	 * Create the frame.
	 */
	private SetTartarugaFalse() {
		setTitle("Aggiungi le informazioni della tartaruga");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetTartarugaFalse.class.getResource("/Textures/Tartaruga frame.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Invio\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Nome.getText().equals("") || Targhetta.getText().equals("") || IDTartaruga.getText().equals("")) {
					controller.AppareMainGUI();
					setVisible(false);
					controller.AppareErroreGenerico();
					controller.AmmissioneIndebita(temp);
					
					Nome.setText("");
					Targhetta.setText("");
					IDTartaruga.setText("");
					
				}
				else {
					temp.setNome(Nome.getText());
					temp.setTarghetta(Targhetta.getText());
					temp.setIDTartaruga(IDTartaruga.getText());
					controller.AppareMainGUI();
					
					controller.PassaPerIlTartarugaDAO(temp);
					
					setVisible(false);
					
					Nome.setText("");
					Targhetta.setText("");
					IDTartaruga.setText("");
				}
			}
		});
		btnNewButton.setBounds(684, 734, 173, 70);
		contentPane.add(btnNewButton);
		
		Nome = new JTextField();
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Nome.setBounds(133, 121, 173, 58);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		Targhetta = new JTextField();
		Targhetta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Targhetta.setBounds(168, 213, 173, 58);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
		
		IDTartaruga = new JTextField();
		IDTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDTartaruga.setBounds(277, 304, 221, 58);
		contentPane.add(IDTartaruga);
		IDTartaruga.setColumns(10);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetTartarugaFalse.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewAmmissioniTartarughe();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(609, 483, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Compila le informazioni della tartaruga.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 878, 70);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nome:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(42, 120, 385, 58);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Targhetta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(42, 212, 385, 58);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ID della tartaruga:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(42, 304, 385, 58);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Visualizza le Tartarughe e le rispettive Ammissioni:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(42, 492, 656, 58);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(SetTartarugaFalse.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_5.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_5);
	}
}
