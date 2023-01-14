package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class SetCartellaClinica extends JFrame {

	private JPanel contentPane;
	private JTextField txtSpecieLunghezzaLarghezza;
	private JTextField txtNasoBeccoCollo;
	private JTextField Specie;
	private JTextField Lunghezza;
	private JTextField Larghezza;
	private JTextField Peso;
	private JTextField Occhi;
	private JTextField Testa;
	private JTextField Naso;
	private JTextField Becco;
	private JTextField Collo;
	private JTextField Pinne;
	private JTextField Coda;
	private JTextField IDCartellaClinica;
	private JTextField Documentazione;



	public SetCartellaClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSpecieLunghezzaLarghezza = new JTextField();
		txtSpecieLunghezzaLarghezza.setEditable(false);
		txtSpecieLunghezzaLarghezza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSpecieLunghezzaLarghezza.setText("Specie        Lunghezza        Larghezza        Peso       Occhi       Testa");
		txtSpecieLunghezzaLarghezza.setBounds(51, 10, 677, 47);
		contentPane.add(txtSpecieLunghezzaLarghezza);
		txtSpecieLunghezzaLarghezza.setColumns(10);
		
		txtNasoBeccoCollo = new JTextField();
		txtNasoBeccoCollo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNasoBeccoCollo.setText("Naso   Becco   Collo   Pinne   Coda   IDCartellaClinica   Documentazione ");
		txtNasoBeccoCollo.setEditable(false);
		txtNasoBeccoCollo.setBounds(51, 193, 677, 47);
		contentPane.add(txtNasoBeccoCollo);
		txtNasoBeccoCollo.setColumns(10);
		
		Specie = new JTextField();
		Specie.setBounds(51, 99, 130, 47);
		contentPane.add(Specie);
		Specie.setColumns(10);
		
		Lunghezza = new JTextField();
		Lunghezza.setBounds(191, 99, 95, 47);
		contentPane.add(Lunghezza);
		Lunghezza.setColumns(10);
		
		Larghezza = new JTextField();
		Larghezza.setBounds(296, 99, 81, 47);
		contentPane.add(Larghezza);
		Larghezza.setColumns(10);
		
		Peso = new JTextField();
		Peso.setBounds(409, 99, 96, 47);
		contentPane.add(Peso);
		Peso.setColumns(10);
		
		Occhi = new JTextField();
		Occhi.setBounds(515, 99, 96, 47);
		contentPane.add(Occhi);
		Occhi.setColumns(10);
		
		Testa = new JTextField();
		Testa.setBounds(632, 99, 96, 47);
		contentPane.add(Testa);
		Testa.setColumns(10);
		
		Naso = new JTextField();
		Naso.setBounds(10, 323, 81, 34);
		contentPane.add(Naso);
		Naso.setColumns(10);
		
		Becco = new JTextField();
		Becco.setBounds(89, 275, 96, 34);
		contentPane.add(Becco);
		Becco.setColumns(10);
		
		Collo = new JTextField();
		Collo.setBounds(172, 323, 96, 34);
		contentPane.add(Collo);
		Collo.setColumns(10);
		
		Pinne = new JTextField();
		Pinne.setBounds(238, 275, 96, 34);
		contentPane.add(Pinne);
		Pinne.setColumns(10);
		
		Coda = new JTextField();
		Coda.setBounds(315, 323, 96, 34);
		contentPane.add(Coda);
		Coda.setColumns(10);
		
		IDCartellaClinica = new JTextField();
		IDCartellaClinica.setBounds(409, 275, 118, 34);
		contentPane.add(IDCartellaClinica);
		IDCartellaClinica.setColumns(10);
		
		Documentazione = new JTextField();
		Documentazione.setBounds(536, 323, 118, 34);
		contentPane.add(Documentazione);
		Documentazione.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(326, 397, 96, 60);
		contentPane.add(btnNewButton);
	}
}
