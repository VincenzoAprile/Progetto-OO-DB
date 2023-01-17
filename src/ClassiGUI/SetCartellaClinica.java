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

public class SetCartellaClinica extends JFrame {

	private JPanel contentPane;
	private JTextField txtSpecieLunghezzaLarghezza;
	private JTextField Specie;
	private JTextField Lunghezza;
	private JTextField Larghezza;
	private JTextField Peso;
	private JTextField Occhi;
	private JTextField Testa;
	private JTextField Naso;
	private JTextField txtBeccoColloPinne;
	private JTextField Becco;
	private JTextField Collo;
	private JTextField Pinne;
	private JTextField Coda;
	private JTextField IDCartellaClinica;
	
	
	private CartellaClinica temp = new CartellaClinica();
	private static String Documentazione;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSpecieLunghezzaLarghezza = new JTextField();
		txtSpecieLunghezzaLarghezza.setText("Specie    Lunghezza     Larghezza     Peso     Occhi     Testa       Naso\r\n");
		txtSpecieLunghezzaLarghezza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSpecieLunghezzaLarghezza.setEditable(false);
		txtSpecieLunghezzaLarghezza.setBounds(10, 10, 855, 65);
		contentPane.add(txtSpecieLunghezzaLarghezza);
		txtSpecieLunghezzaLarghezza.setColumns(10);
		
		Specie = new JTextField();
		Specie.setBounds(0, 107, 96, 28);
		contentPane.add(Specie);
		Specie.setColumns(10);
		
		Lunghezza = new JTextField();
		Lunghezza.setColumns(10);
		Lunghezza.setBounds(125, 107, 96, 28);
		contentPane.add(Lunghezza);
		
		Larghezza = new JTextField();
		Larghezza.setColumns(10);
		Larghezza.setBounds(276, 111, 96, 28);
		contentPane.add(Larghezza);
		
		Peso = new JTextField();
		Peso.setColumns(10);
		Peso.setBounds(396, 111, 96, 28);
		contentPane.add(Peso);
		
		Occhi = new JTextField();
		Occhi.setColumns(10);
		Occhi.setBounds(502, 111, 96, 28);
		contentPane.add(Occhi);
		
		Testa = new JTextField();
		Testa.setColumns(10);
		Testa.setBounds(608, 111, 96, 28);
		contentPane.add(Testa);
		
		Naso = new JTextField();
		Naso.setColumns(10);
		Naso.setBounds(732, 111, 96, 28);
		contentPane.add(Naso);
		
		txtBeccoColloPinne = new JTextField();
		txtBeccoColloPinne.setText("Becco         Collo         Pinne         Coda            ID Cartella Clinica    ");
		txtBeccoColloPinne.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtBeccoColloPinne.setEditable(false);
		txtBeccoColloPinne.setBounds(10, 195, 865, 55);
		contentPane.add(txtBeccoColloPinne);
		txtBeccoColloPinne.setColumns(10);
		
		Becco = new JTextField();
		Becco.setColumns(10);
		Becco.setBounds(0, 290, 96, 28);
		contentPane.add(Becco);
		
		Collo = new JTextField();
		Collo.setColumns(10);
		Collo.setBounds(106, 290, 96, 28);
		contentPane.add(Collo);
		
		Pinne = new JTextField();
		Pinne.setColumns(10);
		Pinne.setBounds(262, 290, 96, 28);
		contentPane.add(Pinne);
		
		Coda = new JTextField();
		Coda.setColumns(10);
		Coda.setBounds(396, 290, 96, 28);
		contentPane.add(Coda);
		
		IDCartellaClinica = new JTextField();
		IDCartellaClinica.setColumns(10);
		IDCartellaClinica.setBounds(624, 290, 96, 28);
		contentPane.add(IDCartellaClinica);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if(Specie.getText().equals("") || IDCartellaClinica.getText().equals("") || Lunghezza.getText().equals("") || 
				   Larghezza.getText().equals("") || Peso.getText().equals("")) {
					
					setVisible(false);
					Controller.AppareMainGUI();
					Controller.AppareErroreGenerico();
					
					
					Controller.DocumentazioneIndebita(Documentazione);
				}
				else {
					temp.setBecco(Becco.getText());
					temp.setCoda(Coda.getText());
					temp.setCollo(Collo.getText());
					temp.setIDCartellaClinica(IDCartellaClinica.getText());
					temp.setLarghezza(Larghezza.getText());
					temp.setLunghezza(Lunghezza.getText());
					temp.setNaso(Naso.getText());
					temp.setOcchi(Occhi.getText());
					temp.setPeso(Peso.getText());
					temp.setPinne(Pinne.getText());
					temp.setSpecie(Specie.getText());
					temp.setTesta(Testa.getText());
					temp.setDocumentazione(Documentazione);
					
					setVisible(false);
					Controller.AppareMainGUI();
					
					Controller.PassaPerIlCartellaClinicaDAO(temp);
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(379, 364, 140, 73);
		contentPane.add(btnNewButton);
	}

}
