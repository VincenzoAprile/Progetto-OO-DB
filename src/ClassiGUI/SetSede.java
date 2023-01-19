package ClassiGUI;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAO.SedeDAO;
import ClassiTabelle.Sede;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;

public class SetSede extends JFrame {

	private JPanel contentPane;
	private JTextField txtIndirizzoContattiNomecentro;
	private JTextField TextIndirizzo;
	private JTextField TextContatti;
	private JTextField TextNomeCentro;
	private JTextField TextIDCentro;

	private Sede temp = new Sede();
	private JButton btnNewButton_1;
	ArrayList<Sede> prova = new ArrayList<Sede>();
	/**
	 * Create the frame.
	 */
	public SetSede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIndirizzoContattiNomecentro = new JTextField();
		txtIndirizzoContattiNomecentro.setEditable(false);
		txtIndirizzoContattiNomecentro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIndirizzoContattiNomecentro.setText("Indirizzo                  Contatti               Nomecentro               IDCentro   ");
		txtIndirizzoContattiNomecentro.setBounds(10, 10, 698, 51);
		contentPane.add(txtIndirizzoContattiNomecentro);
		txtIndirizzoContattiNomecentro.setColumns(10);
		
		TextIndirizzo = new JTextField();
		TextIndirizzo.setBounds(10, 122, 103, 51);
		contentPane.add(TextIndirizzo);
		TextIndirizzo.setColumns(10);
		
		TextContatti = new JTextField();
		TextContatti.setColumns(10);
		TextContatti.setBounds(178, 122, 103, 51);
		contentPane.add(TextContatti);
		
		TextNomeCentro = new JTextField();
		TextNomeCentro.setColumns(10);
		TextNomeCentro.setBounds(358, 122, 103, 51);
		contentPane.add(TextNomeCentro);
		
		TextIDCentro = new JTextField();
		TextIDCentro.setColumns(10);
		TextIDCentro.setBounds(554, 122, 103, 51);
		contentPane.add(TextIDCentro);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF VERIFICA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (TextIndirizzo.getText().equals("") || TextContatti.getText().equals("")
				|| TextNomeCentro.getText().equals("") || TextIDCentro.getText().equals("")) {
					setVisible(false);
					Controller.AppareMainGUI();
					Controller.AppareErroreGenerico();
					
				}
				else {
					temp.setContatti(TextContatti.getText());
					temp.setIDCentro(TextIDCentro.getText());
					temp.setIndirizzo(TextIndirizzo.getText());
					temp.setNomeCentro(TextNomeCentro.getText());
				
					setVisible(false);
					Controller.AppareMainGUI();
				
					Controller.PassaPerIlSedeDAO(temp);
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(30, 289, 254, 87);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Fammi vedere gli attuali centri");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(456, 308, 327, 51);
		contentPane.add(btnNewButton_1);
		
		
	}
}
