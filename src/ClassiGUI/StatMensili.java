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

public class StatMensili extends JFrame {

	private JPanel contentPane;
	private JTextField txtInserireMese;
	private JTextField txtInserireAnno;
	private JTextField Mese;
	private JTextField Anno;
	private JButton btnNewButton_1;

	

	/**
	 * Create the frame.
	 */
	public StatMensili() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInserireMese = new JTextField();
		txtInserireMese.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInserireMese.setText("Inserire Mese");
		txtInserireMese.setEditable(false);
		txtInserireMese.setBounds(60, 54, 262, 62);
		contentPane.add(txtInserireMese);
		txtInserireMese.setColumns(10);
		
		txtInserireAnno = new JTextField();
		txtInserireAnno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInserireAnno.setText("Inserire Anno");
		txtInserireAnno.setEditable(false);
		txtInserireAnno.setBounds(444, 54, 295, 62);
		contentPane.add(txtInserireAnno);
		txtInserireAnno.setColumns(10);
		
		Mese = new JTextField();
		Mese.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Mese.setBounds(60, 188, 122, 62);
		contentPane.add(Mese);
		Mese.setColumns(10);
		
		Anno = new JTextField();
		Anno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Anno.setBounds(444, 191, 122, 62);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		JButton btnNewButton = new JButton("Numero Ammissioni");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String temp = Mese.getText();
				if (temp.length() == 2) {
					char[] arraychar = temp.toCharArray();
					if(arraychar[0] == '0') {
						char end = arraychar[1];
						String Month = String.valueOf(end);
						Controller.StatAmmissioniMensiliDAO(Month, Anno.getText());
					}
				}
				else {
					Controller.StatAmmissioniMensiliDAO(Mese.getText(), Anno.getText());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(60, 340, 223, 62);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cartelle Cliniche");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.CartelleDiUnMese(Mese.getText(), Anno.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(431, 340, 235, 62);
		contentPane.add(btnNewButton_1);
	}

}
