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

public class MainGUI extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField txtQuestaLa;

	

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuestaLa = new JTextField();
		txtQuestaLa.setBackground(Color.CYAN);
		txtQuestaLa.setEditable(false);
		txtQuestaLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtQuestaLa.setText("Questa è la schermata principale\r\n");
		txtQuestaLa.setBounds(69, 39, 272, 80);
		contentPane.add(txtQuestaLa);
		txtQuestaLa.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi qualcosa");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAddNew();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(55, 186, 243, 73);
		contentPane.add(btnNewButton);
		
		JButton btnAssegnaUnaVasca = new JButton("Assegna una vasca a una tartaruga");
		btnAssegnaUnaVasca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareVascaTartaruga();
				setVisible(false);
			}
		});
		btnAssegnaUnaVasca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAssegnaUnaVasca.setBounds(424, 186, 346, 73);
		contentPane.add(btnAssegnaUnaVasca);
		
		JButton btnNewButton_1 = new JButton("Visualizza Tartarughe\r\n");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareSeeSediTartarughe();
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(55, 386, 243, 73);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Statistiche Mensili");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareStatMensili();
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(424, 386, 162, 62);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Statistiche Annuali");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareStatAnnuali();
				setVisible(false);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(656, 386, 162, 62);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Cancella Qualcosa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareDelete();
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(424, 49, 346, 70);
		contentPane.add(btnNewButton_3);
	}
}
