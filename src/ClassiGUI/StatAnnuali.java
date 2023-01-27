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

public class StatAnnuali extends JFrame {

	private JPanel contentPane;
	private JTextField txtInserireLanno;
	private JTextField Anno;

	
	/**
	 * Create the frame.
	 */
	public StatAnnuali() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInserireLanno = new JTextField();
		txtInserireLanno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtInserireLanno.setText("Inserire l'anno");
		txtInserireLanno.setEditable(false);
		txtInserireLanno.setBounds(273, 30, 303, 62);
		contentPane.add(txtInserireLanno);
		txtInserireLanno.setColumns(10);
		
		Anno = new JTextField();
		Anno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Anno.setBounds(308, 160, 214, 54);
		contentPane.add(Anno);
		Anno.setColumns(10);
		
		JButton btnNewButton = new JButton("Numero Ammissioni");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.StatAmmissioniAnnueDAO(Anno.getText());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(57, 312, 214, 62);
		contentPane.add(btnNewButton);
	}
}
