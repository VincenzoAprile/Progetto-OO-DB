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

	private JPanel contentPane;
	private JTextField txtTarghettaDellaTartaruga;
	private JTextField Targhetta;
	private JTextField IDVasca;

	

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
		txtTarghettaDellaTartaruga.setText("    ID Vasca                     Targhetta della Tartaruga ");
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
					Controller.AppareMainGUI();
					setVisible(false);
					Controller.AppareErroreGenerico();
					
				}
				else {
					Controller.AppareMainGUI();
					setVisible(false);
					
					Controller.PassaPerIlVascaTartarugaDAO(IDVasca.getText(), Targhetta.getText());
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(360, 358, 168, 62);
		contentPane.add(btnNewButton);
	}
}
