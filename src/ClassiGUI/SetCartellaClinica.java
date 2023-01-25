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

public class SetCartellaClinica extends JFrame {

	private JPanel contentPane;
	private JTextField txtSpecieLunghezzaLarghezza;
	private JTextField Specie;
	private JTextField Lunghezza;
	private JTextField Larghezza;
	private JTextField Peso;
	private JTextField IDCartellaClinica;
	private String Stati [] = {"", "Compromesso", "Con ferite profonde", "Con ferite superficiali", "Buono", "Perfetto"};
	
	
	private CartellaClinica temp = new CartellaClinica();
	private static String Documentazione;
	private JTextField txtOcchi;
	private JComboBox Occhi;
	private JTextField txtTesta;
	private JComboBox Testa;
	private JTextField txtNaso;
	private JComboBox Naso;
	private JTextField txtBecco;
	private JComboBox Becco;
	private JTextField txtCollo;
	private JComboBox Collo;
	private JTextField txtPinne;
	private JComboBox Pinne;
	private JTextField txtCoda;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSpecieLunghezzaLarghezza = new JTextField();
		txtSpecieLunghezzaLarghezza.setText("Specie    Lunghezza     Larghezza     Peso        ID Cartella Clinica\r\n\r\n");
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
		
		IDCartellaClinica = new JTextField();
		IDCartellaClinica.setColumns(10);
		IDCartellaClinica.setBounds(547, 107, 96, 28);
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
					Controller.AppareMainGUI();
					
					Controller.PassaPerIlCartellaClinicaDAO(temp);
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(440, 387, 140, 73);
		contentPane.add(btnNewButton);
		
		txtOcchi = new JTextField();
		txtOcchi.setText("Occhi");
		txtOcchi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOcchi.setEditable(false);
		txtOcchi.setBounds(10, 196, 70, 39);
		contentPane.add(txtOcchi);
		txtOcchi.setColumns(10);
		
		Occhi = new JComboBox(Stati);
		Occhi.setBounds(90, 196, 172, 39);
		contentPane.add(Occhi);
		
		txtTesta = new JTextField();
		txtTesta.setText("Testa");
		txtTesta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTesta.setEditable(false);
		txtTesta.setColumns(10);
		txtTesta.setBounds(10, 256, 70, 39);
		contentPane.add(txtTesta);
		
		Testa = new JComboBox(Stati);
		Testa.setBounds(90, 256, 172, 39);
		contentPane.add(Testa);
		
		txtNaso = new JTextField();
		txtNaso.setText("Naso");
		txtNaso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNaso.setEditable(false);
		txtNaso.setColumns(10);
		txtNaso.setBounds(10, 315, 70, 39);
		contentPane.add(txtNaso);
		
		Naso = new JComboBox(Stati);
		Naso.setBounds(90, 315, 172, 39);
		contentPane.add(Naso);
		
		txtBecco = new JTextField();
		txtBecco.setText("Becco");
		txtBecco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBecco.setEditable(false);
		txtBecco.setColumns(10);
		txtBecco.setBounds(346, 196, 70, 39);
		contentPane.add(txtBecco);
		
		Becco = new JComboBox(Stati);
		Becco.setBounds(426, 196, 172, 39);
		contentPane.add(Becco);
		
		txtCollo = new JTextField();
		txtCollo.setText("Collo");
		txtCollo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCollo.setEditable(false);
		txtCollo.setColumns(10);
		txtCollo.setBounds(346, 256, 70, 39);
		contentPane.add(txtCollo);
		
		Collo = new JComboBox(Stati);
		Collo.setBounds(426, 256, 172, 39);
		contentPane.add(Collo);
		
		txtPinne = new JTextField();
		txtPinne.setText("Pinne");
		txtPinne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPinne.setEditable(false);
		txtPinne.setColumns(10);
		txtPinne.setBounds(346, 315, 70, 39);
		contentPane.add(txtPinne);
		
		Pinne = new JComboBox(Stati);
		Pinne.setBounds(426, 315, 172, 39);
		contentPane.add(Pinne);
		
		txtCoda = new JTextField();
		txtCoda.setText("Coda\r\n");
		txtCoda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCoda.setEditable(false);
		txtCoda.setColumns(10);
		txtCoda.setBounds(10, 374, 70, 39);
		contentPane.add(txtCoda);
		
		Coda = new JComboBox(Stati);
		Coda.setBounds(90, 374, 172, 39);
		contentPane.add(Coda);
		
		btnNewButton_1 = new JButton("ID Documentazioni e cartelle");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ViewDocumentazioniCartelleCliniche();
			}
		});
		btnNewButton_1.setBounds(680, 196, 185, 78);
		contentPane.add(btnNewButton_1);
	}
}
