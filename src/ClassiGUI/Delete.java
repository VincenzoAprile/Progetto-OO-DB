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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	
	Controller controller = Controller.GetIstanza();

	

	/**
	 * Create the frame.
	 */
	public Delete() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Cancella qualcosa\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ID = new JTextField();
		ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ID.setBounds(493, 181, 275, 72);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Delete.class.getResource("/Textures/Delete sede.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CancellaSede(ID.getText());
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(254, 299, 80, 80);
		contentPane.add(btnNewButton);
		
		JButton btnDipendente = new JButton("");
		btnDipendente.setIcon(new ImageIcon(Delete.class.getResource("/Textures/delete dipendente.jpg")));
		btnDipendente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CancellaDipendente(ID.getText());
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnDipendente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDipendente.setBounds(312, 389, 80, 80);
		contentPane.add(btnDipendente);
		
		JButton btnTartaruga = new JButton("");
		btnTartaruga.setIcon(new ImageIcon(Delete.class.getResource("/Textures/Delete tartaruga.png")));
		btnTartaruga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CancellaAmmissioneTartaruga(ID.getText());
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTartaruga.setBounds(312, 493, 80, 80);
		contentPane.add(btnTartaruga);
		
		JButton btnCartellaClinica = new JButton("");
		btnCartellaClinica.setIcon(new ImageIcon(Delete.class.getResource("/Textures/delete cartella clinica.png")));
		btnCartellaClinica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CancellaDocumentazioneCartellaClinica(ID.getText());
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnCartellaClinica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCartellaClinica.setBounds(364, 603, 80, 80);
		contentPane.add(btnCartellaClinica);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Delete.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_1.setBounds(1325, 689, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Inserire l'ID dell'oggetto che si vuole eliminare e poi cliccare il pulsante corrispondente.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 1205, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cancella una sede: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(39, 309, 291, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cancella un dipendente:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(39, 400, 291, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cancella una tartaruga:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(43, 503, 291, 50);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cancella una cartella clinica:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(43, 617, 357, 50);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("(Attenzione! Cancellare un oggetto comporta anche la cancellazione di tutti gli oggetti che dipendono da esso!)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 79, 1270, 72);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Torna indietro:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(1145, 689, 284, 80);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Delete.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewSedi();
			}
		});
		btnNewButton_2.setBounds(984, 299, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Delete.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDipendenti();
			}
		});
		btnNewButton_3.setBounds(1035, 389, 80, 80);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Delete.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewTartarugheCentro("%");
			}
		});
		btnNewButton_4.setBounds(1049, 493, 80, 80);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Delete.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewDocumentazioniCartelleCliniche();
			}
		});
		btnNewButton_5.setBounds(1100, 603, 80, 80);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1_4 = new JLabel("Visualizza le sedi: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(775, 309, 291, 50);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Visualizza i dipendenti:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(775, 400, 291, 50);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Visualizza le tartarughe:\r\n");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_6.setBounds(775, 503, 291, 50);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Visualizza le cartelle cliniche:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_7.setBounds(775, 617, 396, 50);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Inserire l'ID qui prima di continure:");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_8.setBounds(39, 185, 479, 50);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Delete.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_4);
	}
}
