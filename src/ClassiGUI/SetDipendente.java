package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.Dipendente;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SetDipendente extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField Matricola;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Centro;
	private JComboBox Ruolo;
	
	private Dipendente temp = new Dipendente();
	private String Ruoli [] = {"", "Medico Veterinario", "Ricercatore", "Operatore", "Tecnico di laboratorio"};
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;


	/**
	 * Create the frame.
	 */
	public SetDipendente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetDipendente.class.getResource("/Textures/Tartaruga frame.jpg")));
		setResizable(false);
		setTitle("Aggiungi un dipendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Invio");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Matricola.getText().equals("") || Nome.getText().equals("") || Cognome.getText().equals("") 
				|| Ruolo.getItemAt(Ruolo.getSelectedIndex()).equals("") || Centro.getText().equals("")) {
					
					setVisible(false);
					controller.AppareMainGUI();
					controller.AppareErroreGenerico();
					
					
				}
				else {
					temp.setCentro(Centro.getText());
					temp.setCognome(Cognome.getText());
					temp.setMatricola(Matricola.getText());
					temp.setNome(Nome.getText());
					temp.setRuolo((String) Ruolo.getItemAt(Ruolo.getSelectedIndex()));
				
					setVisible(false);
					
					controller.AppareMainGUI();
				
					controller.PassaPerIlDipendenteDAO(temp);
				
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(660, 700, 222, 76);
		contentPane.add(btnNewButton);
		
		Matricola = new JTextField();
		Matricola.setBounds(167, 305, 222, 57);
		contentPane.add(Matricola);
		Matricola.setColumns(10);
		
		Nome = new JTextField();
		Nome.setColumns(10);
		Nome.setBounds(120, 121, 168, 57);
		contentPane.add(Nome);
		
		Cognome = new JTextField();
		Cognome.setColumns(10);
		Cognome.setBounds(167, 217, 182, 57);
		contentPane.add(Cognome);
		
		Centro = new JTextField();
		Centro.setColumns(10);
		Centro.setBounds(379, 412, 175, 57);
		contentPane.add(Centro);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetDipendente.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewSedi();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1410, 164, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(SetDipendente.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDipendenti();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(1410, 334, 80, 80);
		contentPane.add(btnNewButton_2);
		
		Ruolo = new JComboBox(Ruoli);
		Ruolo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Ruolo.setBounds(120, 507, 183, 57);
		contentPane.add(Ruolo);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(SetDipendente.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAddNew();
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(1410, 696, 80, 80);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Compila i seguenti campi e poi premi invio.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 948, 57);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(41, 121, 308, 57);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Cognome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(41, 211, 308, 57);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Matricola:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(41, 299, 308, 57);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Centro di appartenenza (ID):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(41, 406, 461, 57);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Ruolo:\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(41, 507, 308, 57);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel(" Visualizza tutte le sedi:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(1137, 174, 308, 57);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Visualizza tutti i dipendenti:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(1092, 343, 308, 57);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_9 = new JLabel("Torna indietro:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(1225, 712, 251, 48);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(SetDipendente.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_8.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_8);
		

	}
}
