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
		AssegnaVasca.setBounds(466, 666, 80, 80);
		contentPane.add(AssegnaVasca);
		
		JButton Visualizza = new JButton("");
		Visualizza.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/tartaruga icona.jpg")));
		Visualizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSeeSediTartarughe();
				setVisible(false);
			}
		});
		Visualizza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Visualizza.setBounds(348, 335, 80, 80);
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
		StatMensili.setBounds(348, 438, 80, 80);
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
		StatAnnuali.setBounds(348, 549, 80, 80);
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
		Cancella.setBounds(455, 225, 80, 80);
		contentPane.add(Cancella);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/Textures/MainGui3.PNG")));
		lblNewLabel.setBounds(0, 0, 1550, 845);
		contentPane.add(lblNewLabel);
		
		
	}
}
