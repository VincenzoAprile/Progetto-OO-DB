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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNew extends JFrame {
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public AddNew() {
		setResizable(false);
		setTitle("Aggiungi qualcosa");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNew.class.getResource("/Textures/Tartaruga frame.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Add Sede.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSetSede();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(241, 99, 80, 80);
		contentPane.add(btnNewButton);
		
		JButton NuovoDipendente = new JButton("");
		NuovoDipendente.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Add impiegato.png")));
		NuovoDipendente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSetDipendente();
				setVisible(false);
			}
		});
		NuovoDipendente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NuovoDipendente.setBounds(301, 210, 80, 80);
		contentPane.add(NuovoDipendente);
		
		JButton btnNuovaTartaruga = new JButton("");
		btnNuovaTartaruga.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Add tartaruga.png")));
		btnNuovaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuovaTartaruga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSetAmmissione();
				setVisible(false);
			}
		});
		btnNuovaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNuovaTartaruga.setBounds(290, 324, 80, 80);
		contentPane.add(btnNuovaTartaruga);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Add CartClin.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSetDocumentazione();
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(273, 455, 80, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Add acquario.png")));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareNewVasca();
				setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(253, 574, 80, 80);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Go-back-icon.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareMainGUI();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(1291, 718, 80, 80);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Cosa vuoi aggiungere?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(10, 0, 850, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Una nuova sede:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(51, 99, 222, 65);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Un nuovo dipendente:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(51, 223, 252, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Una nuova tartaruga:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(51, 339, 252, 41);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Una cartella clinica:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(51, 466, 240, 55);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Una nuova vasca:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(51, 583, 231, 55);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Torna indietro:\r\n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(1114, 734, 337, 48);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddNew.class.getResource("/Textures/Mare Dall'interno.jpg")));
		lblNewLabel.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel);
		

		

		
		
	}
}
