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

public class VascaTartaruga extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField txtTarghettaDellaTartaruga;
	private JTextField Targhetta;
	private JTextField IDVasca;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	

	/**
	 * Create the frame.
	 */
	public VascaTartaruga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTarghettaDellaTartaruga = new JTextField();
		txtTarghettaDellaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTarghettaDellaTartaruga.setText("    ID Vasca                           ID Tartaruga");
		txtTarghettaDellaTartaruga.setEditable(false);
		txtTarghettaDellaTartaruga.setBounds(10, 26, 825, 82);
		contentPane.add(txtTarghettaDellaTartaruga);
		txtTarghettaDellaTartaruga.setColumns(10);
		
		Targhetta = new JTextField();
		Targhetta.setBounds(395, 169, 259, 62);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
		
		IDVasca = new JTextField();
		IDVasca.setBounds(49, 172, 159, 55);
		contentPane.add(IDVasca);
		IDVasca.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(Targhetta.getText().equals("") || IDVasca.getText().equals("")) {
					controller.AppareMainGUI();
					setVisible(false);
					controller.AppareErroreGenerico();
					
				}
				else {
					controller.AppareMainGUI();
					setVisible(false);
					
					controller.PassaPerIlVascaTartarugaDAO(IDVasca.getText(), Targhetta.getText());
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(667, 347, 168, 62);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Vasche");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewVasche();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(49, 318, 186, 91);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Tartarughe senza Vasca");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.TartarugheSenzaVasca();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(310, 318, 274, 91);
		contentPane.add(btnNewButton_2);
	}
}
