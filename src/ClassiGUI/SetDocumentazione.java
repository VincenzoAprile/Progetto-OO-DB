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

public class SetDocumentazione extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField txtVeterinarioidLuogoDi;
	private JTextField Veterinario;
	private JTextField Luogo;
	private JTextField Giorno;
	private JTextField Mese;
	private JTextField Anno;
	private JTextField IDDocumentazione;
	private JTextField Etichetta;
	
	Documentazione temp = new Documentazione();
	private JButton btnNewButton_2;

	

	/**
	 * Create the frame.
	 */
	public SetDocumentazione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtVeterinarioidLuogoDi = new JTextField();
		txtVeterinarioidLuogoDi.setEditable(false);
		txtVeterinarioidLuogoDi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtVeterinarioidLuogoDi.setText("Veterinario(ID)     Luogo di Ritrovamento      Data      ID Documentazione        ID Della Tartaruga\r\n");
		txtVeterinarioidLuogoDi.setBounds(10, 10, 906, 55);
		contentPane.add(txtVeterinarioidLuogoDi);
		txtVeterinarioidLuogoDi.setColumns(10);
		
		Veterinario = new JTextField();
		Veterinario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Veterinario.setBounds(10, 228, 117, 55);
		contentPane.add(Veterinario);
		Veterinario.setColumns(10);
		
		Luogo = new JTextField();
		Luogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Luogo.setBounds(174, 114, 175, 55);
		contentPane.add(Luogo);
		Luogo.setColumns(10);
		
		Giorno = new JTextField();
		Giorno.setBounds(367, 205, 96, 34);
		contentPane.add(Giorno);
		Giorno.setColumns(10);
		
		Mese = new JTextField();
		Mese.setBounds(367, 274, 96, 34);
		contentPane.add(Mese);
		Mese.setColumns(10);
		
		Anno = new JTextField();
		Anno.setBounds(367, 342, 96, 34);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		IDDocumentazione = new JTextField();
		IDDocumentazione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IDDocumentazione.setBounds(459, 118, 167, 48);
		contentPane.add(IDDocumentazione);
		IDDocumentazione.setColumns(10);
		
		Etichetta = new JTextField();
		Etichetta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Etichetta.setBounds(651, 228, 225, 55);
		contentPane.add(Etichetta);
		Etichetta.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(653, 417, 167, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dipendenti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDipendenti();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 385, 130, 48);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("ID Documentazioni e cartelle cliniche");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDocumentazioniCartelleCliniche();
			}
		});
		btnNewButton_2.setBounds(200, 385, 210, 65);
		contentPane.add(btnNewButton_2);
	}
}
