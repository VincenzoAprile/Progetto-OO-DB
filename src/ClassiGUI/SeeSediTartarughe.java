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

public class SeeSediTartarughe extends JFrame {
	
	Controller controller = Controller.GetIstanza();

	private JPanel contentPane;
	private JTextField IDSede;
	private JTextField Targhetta;
	private JTextField txtInserireLaTarghetta;

	
	/**
	 * Create the frame.
	 */
	public SeeSediTartarughe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Visualizza Le Sedi\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewSedi();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(23, 32, 205, 60);
		contentPane.add(btnNewButton);
		
		IDSede = new JTextField();
		IDSede.setBounds(23, 198, 205, 60);
		contentPane.add(IDSede);
		IDSede.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Visualizza Le Tartarughe");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ViewTartarugheCentro(IDSede.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(27, 337, 201, 60);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ulteriori informazioni");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.AppareAmmissioniCartelle(Targhetta.getText());
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(580, 335, 272, 60);
		contentPane.add(btnNewButton_2);
		
		Targhetta = new JTextField();
		Targhetta.setBounds(580, 198, 260, 60);
		contentPane.add(Targhetta);
		Targhetta.setColumns(10);
		
		txtInserireLaTarghetta = new JTextField();
		txtInserireLaTarghetta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInserireLaTarghetta.setText("Inserire la targhetta di una tartaruga di cui si vogliono più informazioni");
		txtInserireLaTarghetta.setEditable(false);
		txtInserireLaTarghetta.setBounds(446, 117, 532, 60);
		contentPane.add(txtInserireLaTarghetta);
		txtInserireLaTarghetta.setColumns(10);
	}
}
