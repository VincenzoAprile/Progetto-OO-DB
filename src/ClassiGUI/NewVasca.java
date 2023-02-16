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
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class NewVasca extends JFrame {

	private JPanel contentPane;
	private JTextField CodiceVasca;
	private JTextField Tipo;
	private JTextField Lunghezza;
	private JTextField Larghezza;
	private JTextField Profondità;
	
	private Vasca temp = new Vasca();
	private JButton btnNewButton_1;
	
	Controller controller = Controller.GetIstanza();

	

	/**
	 * Create the frame.
	 */
	public NewVasca() {
		setTitle("Aggiungi una vasca\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewVasca.class.getResource("/Textures/Tartaruga frame.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CodiceVasca = new JTextField();
		CodiceVasca.setFont(new Font("Tahoma", Font.PLAIN, 25));
		CodiceVasca.setBounds(246, 472, 186, 58);
		contentPane.add(CodiceVasca);
		CodiceVasca.setColumns(10);
		
		Tipo = new JTextField();
		Tipo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Tipo.setColumns(10);
		Tipo.setBounds(212, 131, 195, 49);
		contentPane.add(Tipo);
		
		Lunghezza = new JTextField();
		Lunghezza.setBounds(172, 204, 132, 58);
		contentPane.add(Lunghezza);
		Lunghezza.setColumns(10);
		
		Larghezza = new JTextField();
		Larghezza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Larghezza.setColumns(10);
		Larghezza.setBounds(172, 287, 132, 58);
		contentPane.add(Larghezza);
		
		Profondità = new JTextField();
		Profondità.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Profondità.setColumns(10);
		Profondità.setBounds(172, 378, 132, 58);
		contentPane.add(Profondità);
		
		JButton btnNewButton = new JButton("Invio");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//L'IF CONTROLLA CHE NON CI SIANO CASELLE LASCIATE VUOTE
				if(CodiceVasca.getText().equals("")  || Larghezza.getText().equals("")  || Lunghezza.getText().equals("")  || 
				   Profondità.getText().equals("")  || Tipo.getText().equals("")) {
				   
					controller.AppareMainGUI();
					setVisible(false);
					controller.AppareErroreGenerico();
					
					
				}
				else {
					temp.setCodiceVasca(CodiceVasca.getText());
					temp.setLarghezza(Larghezza.getText());
					temp.setLunghezza(Lunghezza.getText());
					temp.setProfondità(Profondità.getText());
					temp.setTipo(Tipo.getText());
					
					controller.AppareMainGUI();
					setVisible(false);
					
					controller.PassaPerIlVascaDAO(temp);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(683, 728, 161, 67);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(NewVasca.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewVasche();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(926, 120, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(NewVasca.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAddNew();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(1347, 727, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Compila i seguenti campi.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 904, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo di vasca:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(37, 120, 376, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lunghezza:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(37, 197, 376, 58);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Larghezza:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(37, 285, 376, 58);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Profondità:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(37, 376, 376, 58);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Codice vasca (ID):");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(37, 472, 376, 58);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Visualizza le vasche:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(694, 122, 376, 67);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Torna indietro:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_6.setBounds(1175, 728, 376, 67);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(NewVasca.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_2);
	}
}
