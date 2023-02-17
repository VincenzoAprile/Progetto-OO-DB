package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.Documentazione;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SetDocumentazione extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField Veterinario;
	private JTextField Luogo;
	private JTextField Giorno;
	private JTextField Mese;
	private JTextField Anno;
	private JTextField IDDocumentazione;
	private JTextField Etichetta;
	
	Documentazione temp = new Documentazione();
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	

	/**
	 * Create the frame.
	 */
	public SetDocumentazione() {
		setResizable(false);
		setTitle("Aggiungi una cartella clinica");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetDocumentazione.class.getResource("/Textures/Tartaruga frame.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Veterinario = new JTextField();
		Veterinario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Veterinario.setBounds(1234, 143, 175, 48);
		contentPane.add(Veterinario);
		Veterinario.setColumns(10);
		
		Luogo = new JTextField();
		Luogo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Luogo.setBounds(1138, 251, 196, 40);
		contentPane.add(Luogo);
		Luogo.setColumns(10);
		
		Giorno = new JTextField();
		Giorno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Giorno.setBounds(189, 216, 35, 40);
		contentPane.add(Giorno);
		Giorno.setColumns(10);
		
		Mese = new JTextField();
		Mese.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Mese.setBounds(177, 284, 35, 40);
		contentPane.add(Mese);
		Mese.setColumns(10);
		
		Anno = new JTextField();
		Anno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Anno.setBounds(202, 349, 65, 40);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		IDDocumentazione = new JTextField();
		IDDocumentazione.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDDocumentazione.setBounds(458, 624, 167, 40);
		contentPane.add(IDDocumentazione);
		IDDocumentazione.setColumns(10);
		
		Etichetta = new JTextField();
		Etichetta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Etichetta.setBounds(259, 485, 225, 40);
		contentPane.add(Etichetta);
		Etichetta.setColumns(10);
		
		JButton btnNewButton = new JButton("Continua");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if(Anno.getText().equals("") || Mese.getText().equals("") || Giorno.getText().equals("") || 
				   Etichetta.getText().equals("") || IDDocumentazione.getText().equals("") || Luogo.getText().equals("") || 
				   Veterinario.getText().equals("")) {
						
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
					
					temp.setData(Anno.getText()+"-"+Mese.getText()+"-"+Giorno.getText());
					temp.setEtichetta(Etichetta.getText());
					temp.setIDDocumentazione(IDDocumentazione.getText());
					temp.setLuogoDiRitrovamento(Luogo.getText());
					temp.setVeterinario(Veterinario.getText());
					
					setVisible(false);
					controller.PassaPerIlDocumentazioneDAO(temp);
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(692, 751, 196, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetDocumentazione.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDipendenti();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1005, 428, 80, 80);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton_2.setIcon(new ImageIcon(SetDocumentazione.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDocumentazioniCartelleCliniche();
			}
		});
		btnNewButton_2.setBounds(1434, 332, 80, 80);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Inserisci le informazioni riguardanti la cartella clinica (Documentazione).");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 1111, 65);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Data di Documentazione:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(41, 142, 431, 48);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Giorno (DD):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(41, 215, 184, 40);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mese (MM):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(41, 284, 184, 40);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Anno (YYYY):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(41, 349, 184, 40);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("ID della tartaruga:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4_1.setBounds(41, 484, 288, 40);
		contentPane.add(lblNewLabel_4_1);
		
		lblNewLabel_5 = new JLabel("Identificativo della Documentazione:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(40, 623, 608, 40);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Matricola del medico veterinario della tartaruga:\r\n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(692, 145, 549, 40);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Luogo di documentazione della cartella:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(692, 250, 521, 40);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Visualizza gli ID di documentazione e le cartelle cliniche associate:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(692, 348, 742, 40);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Visualizza tutti i dipendenti:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(692, 449, 334, 40);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Torna indietro");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(1150, 751, 184, 40);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(SetDocumentazione.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAddNew();
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(1327, 737, 80, 80);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(SetDocumentazione.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_11.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_11);
	}
}
