package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAO.DocumentazioneDAO;
import ClassiTabelle.CartellaClinica;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SetCartellaClinica extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField Specie;
	private JTextField Lunghezza;
	private JTextField Larghezza;
	private JTextField Peso;
	private JTextField IDCartellaClinica;
	private String Stati [] = {"", "Compromesso", "Con ferite profonde", "Con ferite superficiali", "Buono", "Perfetto"};
	
	
	private CartellaClinica temp = new CartellaClinica();
	private static String Documentazione;
	private JComboBox Occhi;
	private JComboBox Testa;
	private JComboBox Naso;
	private JComboBox Becco;
	private JComboBox Collo;
	private JComboBox Pinne;
	private JComboBox Coda;
	private JButton btnNewButton_1;
	
	public String getDocumentazione() {
		return Documentazione;
	}

	public static void setDocumentazione(String documentazione) {
		Documentazione = documentazione;
	}
	
	/**
	 * Create the frame.
	 */
	public SetCartellaClinica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetCartellaClinica.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Aggiungi una cartella clinica\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Specie = new JTextField();
		Specie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Specie.setBounds(120, 115, 178, 48);
		contentPane.add(Specie);
		Specie.setColumns(10);
		
		Lunghezza = new JTextField();
		Lunghezza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Lunghezza.setColumns(10);
		Lunghezza.setBounds(158, 196, 111, 47);
		contentPane.add(Lunghezza);
		
		Larghezza = new JTextField();
		Larghezza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Larghezza.setColumns(10);
		Larghezza.setBounds(158, 280, 111, 47);
		contentPane.add(Larghezza);
		
		Peso = new JTextField();
		Peso.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Peso.setColumns(10);
		Peso.setBounds(98, 353, 140, 48);
		contentPane.add(Peso);
		
		IDCartellaClinica = new JTextField();
		IDCartellaClinica.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDCartellaClinica.setColumns(10);
		IDCartellaClinica.setBounds(294, 429, 140, 46);
		contentPane.add(IDCartellaClinica);
		
		JButton btnNewButton = new JButton("Invio");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if(Specie.getText().equals("") || IDCartellaClinica.getText().equals("") || Lunghezza.getText().equals("") || 
				   Larghezza.getText().equals("") || Peso.getText().equals("")) {
					
					setVisible(false);
					controller.AppareMainGUI();
					controller.AppareErroreGenerico();
					
					
					controller.DocumentazioneIndebita(Documentazione);
				}
				else {
					temp.setBecco((String) Becco.getItemAt(Becco.getSelectedIndex()));
					temp.setCoda((String) Coda.getItemAt(Coda.getSelectedIndex()));
					temp.setCollo((String) Collo.getItemAt(Collo.getSelectedIndex()));
					temp.setIDCartellaClinica(IDCartellaClinica.getText());
					temp.setLarghezza(Larghezza.getText());
					temp.setLunghezza(Lunghezza.getText());
					temp.setNaso((String) Naso.getItemAt(Naso.getSelectedIndex()));
					temp.setOcchi((String) Occhi.getItemAt(Occhi.getSelectedIndex()));
					temp.setPeso(Peso.getText());
					temp.setPinne((String) Pinne.getItemAt(Pinne.getSelectedIndex()));
					temp.setSpecie(Specie.getText());
					temp.setTesta((String) Testa.getItemAt(Testa.getSelectedIndex()));
					temp.setDocumentazione(Documentazione);
					
					setVisible(false);
					controller.AppareMainGUI();
					
					controller.PassaPerIlCartellaClinicaDAO(temp);
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(707, 740, 140, 73);
		contentPane.add(btnNewButton);
		
		Occhi = new JComboBox(Stati);
		Occhi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Occhi.setBounds(653, 195, 194, 48);
		contentPane.add(Occhi);
		
		Testa = new JComboBox(Stati);
		Testa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Testa.setBounds(653, 115, 194, 49);
		contentPane.add(Testa);
		
		Naso = new JComboBox(Stati);
		Naso.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Naso.setBounds(653, 280, 194, 47);
		contentPane.add(Naso);
		
		Becco = new JComboBox(Stati);
		Becco.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Becco.setBounds(653, 429, 194, 46);
		contentPane.add(Becco);
		
		Collo = new JComboBox(Stati);
		Collo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Collo.setBounds(653, 354, 194, 48);
		contentPane.add(Collo);
		
		Pinne = new JComboBox(Stati);
		Pinne.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Pinne.setBounds(653, 505, 194, 48);
		contentPane.add(Pinne);
		
		Coda = new JComboBox(Stati);
		Coda.setBounds(653, 583, 194, 48);
		contentPane.add(Coda);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetCartellaClinica.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDocumentazioniCartelleCliniche();
			}
		});
		btnNewButton_1.setBounds(1020, 651, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Inserire i dati nella cartella clinica.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 1354, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Specie:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(31, 114, 366, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lunghezza:\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(31, 196, 366, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Larghezza:\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(31, 279, 366, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Peso:\r\n");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(31, 348, 366, 48);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ID della cartella clinica:\r\n");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(31, 429, 366, 48);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Testa:\r\n");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(578, 114, 366, 48);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Occhi:\r\n");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_6.setBounds(578, 196, 366, 48);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Naso:\r\n");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_7.setBounds(578, 279, 366, 48);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Collo:\r\n");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_8.setBounds(578, 353, 366, 48);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Becco\r\n:\r\n");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_9.setBounds(578, 427, 366, 48);
		contentPane.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_10 = new JLabel("Pinne:\r\n");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_10.setBounds(578, 505, 366, 48);
		contentPane.add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_1_11 = new JLabel("Coda:\r\n");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_11.setBounds(578, 583, 366, 48);
		contentPane.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_2 = new JLabel("Visualizza gli ID delle tartarughe, documentazioni e cartelle cliniche associate tra di loro:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(31, 664, 1009, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SetCartellaClinica.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_3.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_3);
	}
}
