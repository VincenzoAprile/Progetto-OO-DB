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

public class AddNew extends JFrame {

	private JPanel contentPane;
	private JTextField txtCosaVuoiAggiungere;

	

	/**
	 * Create the frame.
	 */
	public AddNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCosaVuoiAggiungere = new JTextField();
		txtCosaVuoiAggiungere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScopareAddNew();
			}
		});
		txtCosaVuoiAggiungere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCosaVuoiAggiungere.setText("Cosa Vuoi Aggiungere?");
		txtCosaVuoiAggiungere.setBounds(62, 46, 257, 65);
		contentPane.add(txtCosaVuoiAggiungere);
		txtCosaVuoiAggiungere.setColumns(10);
		
		JButton btnNewButton = new JButton("Nuova Sede");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScopareAddNew();
				Controller.AppareSetSede();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(51, 259, 201, 93);
		contentPane.add(btnNewButton);
		
		JButton NuovoDipendente = new JButton("Nuovo Dipendente");
		NuovoDipendente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.ScopareAddNew();
				Controller.AppareSetDipendente();
			}
		});
		NuovoDipendente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NuovoDipendente.setBounds(362, 261, 176, 93);
		contentPane.add(NuovoDipendente);
	}
}
