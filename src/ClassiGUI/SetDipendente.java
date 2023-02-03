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

public class SetDipendente extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField txtMatricolaNomeCognome;
	private JTextField Matricola;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Centro;
	private JComboBox Ruolo;
	
	private Dipendente temp = new Dipendente();
	private String Ruoli [] = {"", "Medico Veterinario", "Ricercatore", "Operatore", "Tecnico di laboratorio"};


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
		btnNewButton.setBounds(297, 298, 222, 76);
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
		
		Centro = new JTextField();
		Centro.setColumns(10);
		Centro.setBounds(716, 145, 118, 45);
		contentPane.add(Centro);
		
		JButton btnNewButton_1 = new JButton("Visualizza le sedi");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewSedi();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 298, 183, 76);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Visualizza i dipendenti");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDipendenti();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(583, 302, 236, 72);
		contentPane.add(btnNewButton_2);
		
		Ruolo = new JComboBox(Ruoli);
		Ruolo.setBounds(534, 145, 144, 45);
		contentPane.add(Ruolo);
	}
}
