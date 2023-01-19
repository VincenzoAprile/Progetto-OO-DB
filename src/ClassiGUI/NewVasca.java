package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.Vasca;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewVasca extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodiceVascaTipo;
	private JTextField CodiceVasca;
	private JTextField Tipo;
	private JTextField Lunghezza;
	private JTextField Larghezza;
	private JTextField Profondità;
	
	private Vasca temp = new Vasca();

	

	/**
	 * Create the frame.
	 */
	public NewVasca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodiceVascaTipo = new JTextField();
		txtCodiceVascaTipo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtCodiceVascaTipo.setText("Codice Vasca        Tipo        Lunghezza      Larghezza       Profondità");
		txtCodiceVascaTipo.setBounds(10, 20, 849, 91);
		contentPane.add(txtCodiceVascaTipo);
		txtCodiceVascaTipo.setColumns(10);
		
		CodiceVasca = new JTextField();
		CodiceVasca.setBounds(10, 182, 141, 49);
		contentPane.add(CodiceVasca);
		CodiceVasca.setColumns(10);
		
		Tipo = new JTextField();
		Tipo.setColumns(10);
		Tipo.setBounds(184, 182, 124, 49);
		contentPane.add(Tipo);
		
		Lunghezza = new JTextField();
		Lunghezza.setBounds(334, 182, 141, 49);
		contentPane.add(Lunghezza);
		Lunghezza.setColumns(10);
		
		Larghezza = new JTextField();
		Larghezza.setColumns(10);
		Larghezza.setBounds(509, 182, 141, 49);
		contentPane.add(Larghezza);
		
		Profondità = new JTextField();
		Profondità.setColumns(10);
		Profondità.setBounds(684, 182, 141, 49);
		contentPane.add(Profondità);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if(CodiceVasca.getText().equals("")  || Larghezza.getText().equals("")  || Lunghezza.getText().equals("")  || 
				   Profondità.getText().equals("")  || Tipo.getText().equals("")) {
				   
					Controller.AppareMainGUI();
					setVisible(false);
					Controller.AppareErroreGenerico();
					
					
				}
				else {
					temp.setCodiceVasca(CodiceVasca.getText());
					temp.setLarghezza(Larghezza.getText());
					temp.setLunghezza(Lunghezza.getText());
					temp.setProfondità(Profondità.getText());
					temp.setTipo(Tipo.getText());
					
					Controller.AppareMainGUI();
					setVisible(false);
					
					Controller.PassaPerIlVascaDAO(temp);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(323, 359, 161, 67);
		contentPane.add(btnNewButton);
	}

}
