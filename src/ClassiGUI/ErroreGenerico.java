package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PackageController.Controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ErroreGenerico extends JFrame {

	private JPanel contentPane;
	private JTextField txtQualcosaAndato;

	
	/**
	 * Create the frame.
	 */
	public ErroreGenerico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScompareErroreGenerico();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(267, 266, 119, 38);
		contentPane.add(btnNewButton);
		
		txtQualcosaAndato = new JTextField();
		txtQualcosaAndato.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtQualcosaAndato.setText("Qualcosa è andato storto!");
		txtQualcosaAndato.setBounds(99, 94, 468, 101);
		contentPane.add(txtQualcosaAndato);
		txtQualcosaAndato.setColumns(10);
	}
}
