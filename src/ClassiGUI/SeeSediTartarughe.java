package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SeeSediTartarughe extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField IDSede;
	private JTextField Targhetta;

	
	/**
	 * Create the frame.
	 */
	public SeeSediTartarughe() {
		setTitle("Ottieni più informazioni");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeeSediTartarughe.class.getResource("/Textures/Tartaruga frame.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SeeSediTartarughe.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewSedi();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(240, 204, 80, 80);
		contentPane.add(btnNewButton);
		
		IDSede = new JTextField();
		IDSede.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IDSede.setBounds(322, 419, 205, 56);
		contentPane.add(IDSede);
		IDSede.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(SeeSediTartarughe.class.getResource("/Textures/TabellaDataBase.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewTartarugheCentro(IDSede.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(741, 409, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Continua");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAmmissioniCartelle(Targhetta.getText());
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(1151, 620, 137, 60);
		contentPane.add(btnNewButton_2);
		
		Targhetta = new JTextField();
		Targhetta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Targhetta.setBounds(790, 621, 205, 56);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ottieni informazioni riguardo le tartarughe ammesse in una sede.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 10, 894, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblOppureInserisciLa = new JLabel("Oppure inserisci la targhetta di una tartaruga per sapere di più delle sue ammissioni");
		lblOppureInserisciLa.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblOppureInserisciLa.setBounds(10, 55, 1520, 60);
		contentPane.add(lblOppureInserisciLa);
		
		JLabel lblEDelleSue = new JLabel("e delle sue cartelle cliniche.");
		lblEDelleSue.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblEDelleSue.setBounds(10, 102, 894, 60);
		contentPane.add(lblEDelleSue);
		
		JLabel lblNewLabel_1 = new JLabel("Visualizza le sedi:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(39, 216, 375, 53);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserisci l'ID di una sede:                            Quindi clicca qui:       ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(39, 420, 1130, 53);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Per ottenere gli ID e le targhette delle tartarughe ammesse in una sede\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(39, 351, 878, 53);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Per avere ulteriori informazioni riguardo una tartaruga");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(39, 572, 821, 53);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Inserire la targhetta della tartaruga di cui si vuole sapere di più qui:                            poi premere:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(39, 622, 1378, 53);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(SeeSediTartarughe.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_3.setBounds(1420, 733, 80, 80);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("Torna indietro:\r\n");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(1242, 744, 245, 53);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SeeSediTartarughe.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_2);
	}
}
