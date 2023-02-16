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
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StatMensili extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField Mese;
	private JTextField Anno;
	private JButton btnNewButton_1;

	

	/**
	 * Create the frame.
	 */
	public StatMensili() {
		setResizable(false);
		setTitle("Ammissioni mensili");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StatMensili.class.getResource("/Textures/Tartaruga frame.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Mese = new JTextField();
		Mese.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Mese.setBounds(236, 124, 42, 56);
		contentPane.add(Mese);
		Mese.setColumns(10);
		
		Anno = new JTextField();
		Anno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Anno.setBounds(389, 121, 65, 59);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(StatMensili.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String temp = Mese.getText();
				if (temp.length() == 2) {
					char[] arraychar = temp.toCharArray();
					if(arraychar[0] == '0') {
						char end = arraychar[1];
						String Month = String.valueOf(end);
						controller.StatAmmissioniMensiliDAO(Month, Anno.getText());
					}
				}
				else {
					controller.StatAmmissioniMensiliDAO(Mese.getText(), Anno.getText());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(814, 201, 80, 80);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(StatMensili.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CartelleDiUnMese(Mese.getText(), Anno.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(874, 299, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JLabel lblCompilareISeguenti = new JLabel("Compilare i seguenti campi per ottenere il numero di ammissioni o le cartelle cliniche fatte in un certo mese");
		lblCompilareISeguenti.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblCompilareISeguenti.setBounds(10, 10, 1520, 62);
		contentPane.add(lblCompilareISeguenti);
		
		JLabel lblNewLabel = new JLabel("Inserire il mese:      e l'anno:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(55, 125, 844, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quindi per ottenere il numero di ammissioni effettuate premere qui:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(55, 215, 863, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Se invece si vuole visualizzare le cartelle cliniche effettuate, premere qui:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(55, 311, 863, 48);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Torna indietro:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(1218, 745, 263, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(StatMensili.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.setBounds(1407, 732, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StatMensili.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_1);
		
	}
}
