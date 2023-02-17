package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StatAmmissioni extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	

	/**
	 * Create the frame.
	 */
	public StatAmmissioni(String temp) {
		setTitle("Numero ammissioni");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Continua");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(369, 352, 144, 68);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Le ammissioni effettuate nel periodo scelto sono:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(68, 109, 699, 74);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(742, 108, 144, 74);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1.setText(temp);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(StatAmmissioni.class.getResource("/Textures/Sfondo ammissioni.jpg")));
		lblNewLabel_2.setBounds(0, 0, 900, 500);
		contentPane.add(lblNewLabel_2);
	}
}
