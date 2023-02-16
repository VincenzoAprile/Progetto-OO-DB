package ClassiGUI;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;
import PackageController.Main;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class MainGUI extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setTitle("Schermata Principale");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/Textures/Tartaruga frame.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Aggiungi = new JButton("");
		Aggiungi.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/Add 2.png")));
		Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 5));
		Aggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAddNew();
				setVisible(false);
			}
		});
		Aggiungi.setBounds(455, 125, 80, 80);
		contentPane.add(Aggiungi);
		
		JButton AssegnaVasca = new JButton("");
		AssegnaVasca.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/Assegnazione.png")));
		AssegnaVasca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareVascaTartaruga();
				setVisible(false);
			}
		});
		AssegnaVasca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AssegnaVasca.setBounds(455, 657, 80, 80);
		contentPane.add(AssegnaVasca);
		
		JButton Visualizza = new JButton("");
		Visualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Visualizza.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/tartaruga icona.jpg")));
		Visualizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSeeSediTartarughe();
				setVisible(false);
			}
		});
		Visualizza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Visualizza.setBounds(612, 341, 80, 80);
		contentPane.add(Visualizza);
		
		JButton StatMensili = new JButton("");
		StatMensili.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/Icona Mese.jpg")));
		StatMensili.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareStatMensili();
				setVisible(false);
			}
		});
		StatMensili.setFont(new Font("Tahoma", Font.PLAIN, 15));
		StatMensili.setBounds(326, 450, 80, 80);
		contentPane.add(StatMensili);
		
		JButton StatAnnuali = new JButton("");
		StatAnnuali.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/Icona Anno.jpg")));
		StatAnnuali.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareStatAnnuali();
				setVisible(false);
			}
		});
		StatAnnuali.setFont(new Font("Tahoma", Font.PLAIN, 15));
		StatAnnuali.setBounds(522, 554, 80, 80);
		contentPane.add(StatAnnuali);
		
		JButton Cancella = new JButton("");
		Cancella.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/Delete icon.png")));
		Cancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cancella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareDelete();
				setVisible(false);
			}
		});
		Cancella.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Cancella.setBounds(424, 233, 80, 80);
		contentPane.add(Cancella);
		
		JLabel lblNewLabel_1 = new JLabel("Questo è il programma di gestione DataBase dei centri di recupero nazionali per le tartarughe marine.\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(10, 0, 1530, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPregoSelezionareLa = new JLabel("Prego Selezionare la funzionalità che si vuole utilizzare.\r\n");
		lblPregoSelezionareLa.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblPregoSelezionareLa.setBounds(10, 53, 1378, 51);
		contentPane.add(lblPregoSelezionareLa);
		
		JLabel lblNewLabel_2 = new JLabel("Aggiungere un elemento al DataBase:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(32, 136, 438, 57);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Elimina un elemento dal DataBase:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(32, 243, 400, 51);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Visualizza tartarughe, ammissioni e cartelle cliniche:\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(32, 352, 676, 51);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vedere statistiche mensili\r\n:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(32, 464, 328, 53);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Vedere statistiche annuali:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(227, 567, 389, 50);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Assegnare una tartaruga a una vasca:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(32, 666, 483, 51);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Progetto creato da");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_8.setBounds(1254, 680, 301, 57);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Donato Bastione e\r\n");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_9.setBounds(1254, 709, 318, 85);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Vincenzo Aprile");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_10.setBounds(1254, 757, 244, 66);
		contentPane.add(lblNewLabel_10);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/SfondoTartaruga.png")));
		lblNewLabel.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel);
		


		

		
	}
}
