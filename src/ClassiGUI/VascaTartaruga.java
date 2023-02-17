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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VascaTartaruga extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField IDTartaruga;
	private JTextField IDVasca;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	

	/**
	 * Create the frame.
	 */
	public VascaTartaruga() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VascaTartaruga.class.getResource("/Textures/Tartaruga frame.jpg")));
		setResizable(false);
		setTitle("Assegna una tartaruga a una vasca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDTartaruga = new JTextField();
		IDTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDTartaruga.setBounds(412, 249, 159, 48);
		contentPane.add(IDTartaruga);
		IDTartaruga.setColumns(10);
		
		IDVasca = new JTextField();
		IDVasca.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDVasca.setBounds(380, 140, 159, 45);
		contentPane.add(IDVasca);
		IDVasca.setColumns(10);
		
		JButton btnNewButton = new JButton("Invio");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(IDTartaruga.getText().equals("") || IDVasca.getText().equals("")) {
					controller.AppareMainGUI();
					setVisible(false);
					controller.AppareErroreGenerico();
					
				}
				else {
					controller.AppareMainGUI();
					setVisible(false);
					
					controller.PassaPerIlVascaTartarugaDAO(IDVasca.getText(), IDTartaruga.getText());
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(589, 756, 159, 56);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(VascaTartaruga.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewVasche();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(281, 338, 80, 80);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(VascaTartaruga.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.TartarugheSenzaVasca();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(463, 458, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Compila i seguenti campi, poi premi invio.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 905, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci l'ID della vasca qui:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(53, 137, 402, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserisci l'ID della tartaruga qui:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(53, 248, 402, 48);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Visualizza le vasche:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(53, 352, 402, 48);
		contentPane.add(lblNewLabel_1_2);
		
		lblNewLabel_2 = new JLabel("Visualizza le tartarughe senza vasca:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(53, 469, 424, 48);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Torna indietro:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(1182, 760, 204, 48);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(VascaTartaruga.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(1353, 743, 80, 80);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VascaTartaruga.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_4);
	}
}
