package Errori;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ErroreSpecifico extends JFrame {

	private JPanel contentPane;
	private JTextField MessaggioDiErrore;
	private JLabel lblNewLabel;
	

	/**
	 * Create the frame.
	 */
	public ErroreSpecifico(String Errore) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ErroreSpecifico.class.getResource("/Textures/icona errore.png")));
		setType(Type.UTILITY);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(441, 344, 149, 71);
		contentPane.add(btnNewButton);
		
		MessaggioDiErrore = new JTextField();
		MessaggioDiErrore.setBackground(Color.WHITE);
		MessaggioDiErrore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MessaggioDiErrore.setEditable(false);
		MessaggioDiErrore.setBounds(10, 45, 638, 89);
		contentPane.add(MessaggioDiErrore);
		MessaggioDiErrore.setColumns(10);
		MessaggioDiErrore.setText(Errore);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ErroreSpecifico.class.getResource("/Textures/Errore Specifico.png")));
		lblNewLabel.setBounds(0, 0, 900, 500);
		contentPane.add(lblNewLabel);
	}
}
