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

public class StatAnnuali extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField Anno;

	
	/**
	 * Create the frame.
	 */
	public StatAnnuali() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(StatAnnuali.class.getResource("/Textures/Tartaruga frame.jpg")));
		setTitle("Statistiche annuali");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Anno = new JTextField();
		Anno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Anno.setBounds(273, 157, 69, 48);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(StatAnnuali.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.StatAmmissioniAnnueDAO(Anno.getText());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(798, 201, 80, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(StatAnnuali.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CartelleDiUnAnno(Anno.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(861, 291, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Compilare i seguenti campi per ottenere il numero di ammissioni o le cartelle cliniche fatte in un certo anno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 1520, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserire l'anno qui:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(50, 157, 263, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quindi per ottenere il numero di ammissioni effettuate premere qui:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(50, 213, 863, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Se invece si vuole visualizzare le cartelle cliniche effettuate, premere qui:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(50, 307, 863, 48);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(StatAnnuali.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(1427, 681, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Torna indietro:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(1244, 695, 263, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(StatAnnuali.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_2);
	}
}
