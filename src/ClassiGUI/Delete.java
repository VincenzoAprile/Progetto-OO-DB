package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField txtInserireLidDelloggetto;
	private JTextField ID;

	

	/**
	 * Create the frame.
	 */
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInserireLidDelloggetto = new JTextField();
		txtInserireLidDelloggetto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtInserireLidDelloggetto.setText("Inserire l'ID dell'oggetto da cancellare");
		txtInserireLidDelloggetto.setEditable(false);
		txtInserireLidDelloggetto.setBounds(88, 48, 681, 90);
		contentPane.add(txtInserireLidDelloggetto);
		txtInserireLidDelloggetto.setColumns(10);
		
		ID = new JTextField();
		ID.setBounds(286, 185, 275, 72);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JButton btnNewButton = new JButton("Sede\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.CancellaSede(ID.getText());
				Controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(37, 314, 163, 72);
		contentPane.add(btnNewButton);
		
		JButton btnDipendente = new JButton("Dipendente");
		btnDipendente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.CancellaDipendente(ID.getText());
				Controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnDipendente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDipendente.setBounds(254, 314, 163, 72);
		contentPane.add(btnDipendente);
		
		JButton btnTartaruga = new JButton("Tartaruga");
		btnTartaruga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.CancellaAmmissioneTartaruga(ID.getText());
				Controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTartaruga.setBounds(465, 314, 163, 72);
		contentPane.add(btnTartaruga);
		
		JButton btnCartellaClinica = new JButton("Cartella Clinica");
		btnCartellaClinica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.CancellaDocumentazioneCartellaClinica(ID.getText());
				Controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnCartellaClinica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCartellaClinica.setBounds(669, 314, 207, 72);
		contentPane.add(btnCartellaClinica);
	}
}
