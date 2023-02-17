package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AmmissioniCartelle extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField IDAmmissione;
	private JLabel lblNewLabel;
	private JLabel lblCompilareISeguenti;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_4;

	

	/**
	 * Create the frame.
	 */
	public AmmissioniCartelle(String boh) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AmmissioniCartelle.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Ottieni più informazioni");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AmmissioniCartelle.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AmmissioniTarghetta(boh);
			}
		});
		btnNewButton.setBounds(1315, 366, 80, 80);
		contentPane.add(btnNewButton);
		
		IDAmmissione = new JTextField();
		IDAmmissione.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDAmmissione.setBounds(873, 159, 202, 57);
		contentPane.add(IDAmmissione);
		IDAmmissione.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(AmmissioniCartelle.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CartelleDiAmmissione(IDAmmissione.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(250, 204, 80, 80);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Per vedere le cartelle cliniche fatte a una tartaruga durante una specifica ammissione");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 1520, 57);
		contentPane.add(lblNewLabel);
		
		lblCompilareISeguenti = new JLabel("compilare i seguenti campi:");
		lblCompilareISeguenti.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblCompilareISeguenti.setBounds(10, 52, 1520, 57);
		contentPane.add(lblCompilareISeguenti);
		
		lblNewLabel_1 = new JLabel("Inserisci l'ID dell'ammissione di cui vuoi conoscere le cartelle cliniche qui:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(54, 159, 1021, 57);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Quindi clicca qui:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(54, 212, 1021, 57);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Per vedere le ammissioni della tartaruga la cui targhetta è stata inserita nella schemata precedente, premere qui:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(54, 377, 1350, 57);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(AmmissioniCartelle.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSeeSediTartarughe();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(1439, 732, 80, 80);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_4 = new JLabel("Torna indietro:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(1263, 740, 180, 57);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(AmmissioniCartelle.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_5.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_5);
	}
}
