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

public class AmmissioniCartelle extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField txtPerVedereLe;
	private JTextField IDAmmissione;
	private JTextField txtInserisciLidAmmissione;

	

	/**
	 * Create the frame.
	 */
	public AmmissioniCartelle(String boh) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPerVedereLe = new JTextField();
		txtPerVedereLe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPerVedereLe.setText("Per vedere le ammissioni");
		txtPerVedereLe.setEditable(false);
		txtPerVedereLe.setBounds(10, 107, 279, 57);
		contentPane.add(txtPerVedereLe);
		txtPerVedereLe.setColumns(10);
		
		JButton btnNewButton = new JButton("Ammissioni");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AmmissioniTarghetta(boh);
			}
		});
		btnNewButton.setBounds(32, 228, 152, 57);
		contentPane.add(btnNewButton);
		
		IDAmmissione = new JTextField();
		IDAmmissione.setBounds(525, 119, 182, 45);
		contentPane.add(IDAmmissione);
		IDAmmissione.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Visualizza Cartelle");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CartelleDiAmmissione(IDAmmissione.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(536, 228, 152, 57);
		contentPane.add(btnNewButton_1);
		
		txtInserisciLidAmmissione = new JTextField();
		txtInserisciLidAmmissione.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtInserisciLidAmmissione.setText("Inserisci l'ID Ammissione\r\n");
		txtInserisciLidAmmissione.setEditable(false);
		txtInserisciLidAmmissione.setBounds(400, 39, 307, 51);
		contentPane.add(txtInserisciLidAmmissione);
		txtInserisciLidAmmissione.setColumns(10);
	}
}
