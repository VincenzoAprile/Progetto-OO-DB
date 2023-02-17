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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;

public class SetSede extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField TextIndirizzo;
	private JTextField TextContatti;
	private JTextField TextNomeCentro;
	private JTextField TextIDCentro;

	private Sede temp = new Sede();
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel label;
	
	/**
	 * Create the frame.
	 */
	public SetSede() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetSede.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Aggiungi una sede");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextIndirizzo = new JTextField();
		TextIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TextIndirizzo.setBounds(169, 215, 458, 40);
		contentPane.add(TextIndirizzo);
		TextIndirizzo.setColumns(10);
		
		TextContatti = new JTextField();
		TextContatti.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TextContatti.setColumns(10);
		TextContatti.setBounds(169, 450, 382, 40);
		contentPane.add(TextContatti);
		
		TextNomeCentro = new JTextField();
		TextNomeCentro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TextNomeCentro.setColumns(10);
		TextNomeCentro.setBounds(255, 110, 372, 40);
		contentPane.add(TextNomeCentro);
		
		TextIDCentro = new JTextField();
		TextIDCentro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TextIDCentro.setColumns(10);
		TextIDCentro.setBounds(150, 328, 580, 40);
		contentPane.add(TextIDCentro);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF VERIFICA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if (TextIndirizzo.getText().equals("") || TextContatti.getText().equals("")
				|| TextNomeCentro.getText().equals("") || TextIDCentro.getText().equals("")) {
					controller.AppareMainGUI();
					controller.AppareErroreGenerico();
					setVisible(false);
					
				}
				else {
					temp.setContatti(TextContatti.getText());
					temp.setIDCentro(TextIDCentro.getText());
					temp.setIndirizzo(TextIndirizzo.getText());
					temp.setNomeCentro(TextNomeCentro.getText());
				
					controller.AppareMainGUI();
					controller.PassaPerIlSedeDAO(temp);
					setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(691, 725, 164, 80);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SetSede.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewSedi();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(312, 568, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(SetSede.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAddNew();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(1400, 725, 80, 80);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("Nome della sede:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(44, 109, 445, 40);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Visualizza tutte le sedi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(44, 579, 292, 60);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Contatti:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(44, 327, 154, 40);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("ID Centro:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(44, 450, 184, 40);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Compila i seguenti campi.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_5.setBounds(10, 10, 1492, 80);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Torna indietro:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(1224, 712, 207, 95);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Indirizzo:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(44, 215, 197, 40);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SetSede.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("New label");
		label.setBounds(343, 256, 45, 13);
		contentPane.add(label);
		

		

		
		
	}
}
