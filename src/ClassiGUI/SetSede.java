package ClassiGUI;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.Sede;
import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SetSede extends JFrame {

	private JPanel contentPane;
	private JTextField txtIndirizzoContattiNomecentro;
	private JTextField TextIndirizzo;
	private JTextField TextContatti;
	private JTextField TextNomeCentro;
	private JTextField TextIDCentro;

	private Sede temp = new Sede();
	/**
	 * Create the frame.
	 */
	public SetSede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 494);
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
					Controller.ScompareSetSede();
					Controller.AppareMainGUI();
					Controller.AppareErroreGenerico();
					
					TextIndirizzo.setText("");
					TextContatti.setText("");
					TextNomeCentro.setText("");
					TextIDCentro.setText("");
				}
				else {
					temp.setContatti(TextContatti.getText());
					temp.setIDCentro(TextIDCentro.getText());
					temp.setIndirizzo(TextIndirizzo.getText());
					temp.setNomeCentro(TextNomeCentro.getText());
				
					Controller.ScompareSetSede();
					Controller.AppareMainGUI();
				
					Controller.PassaPerIlSedeDAO(temp);
				
					TextIndirizzo.setText("");
					TextContatti.setText("");
					TextNomeCentro.setText("");
					TextIDCentro.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(223, 295, 254, 87);
		contentPane.add(btnNewButton);
	}

}
