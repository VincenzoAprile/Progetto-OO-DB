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

public class SetDipendente extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricolaNomeCognome;
	private JTextField Matricola;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Ruolo;
	private JTextField Centro;
	
	private Dipendente temp = new Dipendente();


	/**
	 * Create the frame.
	 */
	public SetDipendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMatricolaNomeCognome = new JTextField();
		txtMatricolaNomeCognome.setEditable(false);
		txtMatricolaNomeCognome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtMatricolaNomeCognome.setText("Matricola         Nome        Cognome       Ruolo       Centro");
		txtMatricolaNomeCognome.setBounds(26, 34, 806, 56);
		contentPane.add(txtMatricolaNomeCognome);
		txtMatricolaNomeCognome.setColumns(10);
		
		JButton btnNewButton = new JButton("Invia\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (Matricola.getText().equals("") || Nome.getText().equals("") || Cognome.getText().equals("") 
				|| Ruolo.getText().equals("") || Centro.getText().equals("")) {
					
					setVisible(false);
					Controller.AppareMainGUI();
					Controller.AppareErroreGenerico();
					
					
				}
				else {
					temp.setCentro(Centro.getText());
					temp.setCognome(Cognome.getText());
					temp.setMatricola(Matricola.getText());
					temp.setNome(Nome.getText());
					temp.setRuolo(Ruolo.getText());
				
					setVisible(false);
					
					Controller.AppareMainGUI();
				
					Controller.PassaPerIlDipendenteDAO(temp);
				
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(275, 303, 222, 76);
		contentPane.add(btnNewButton);
		
		Matricola = new JTextField();
		Matricola.setBounds(26, 145, 118, 45);
		contentPane.add(Matricola);
		Matricola.setColumns(10);
		
		Nome = new JTextField();
		Nome.setColumns(10);
		Nome.setBounds(207, 145, 118, 45);
		contentPane.add(Nome);
		
		Cognome = new JTextField();
		Cognome.setColumns(10);
		Cognome.setBounds(381, 145, 118, 45);
		contentPane.add(Cognome);
		
		Ruolo = new JTextField();
		Ruolo.setColumns(10);
		Ruolo.setBounds(550, 145, 118, 45);
		contentPane.add(Ruolo);
		
		Centro = new JTextField();
		Centro.setColumns(10);
		Centro.setBounds(716, 145, 118, 45);
		contentPane.add(Centro);
	}
}
