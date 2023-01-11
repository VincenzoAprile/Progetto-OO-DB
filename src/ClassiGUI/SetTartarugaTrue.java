package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.AmmissioneTartaruga;
import javax.swing.JTextField;
import java.awt.Font;

public class SetTartarugaTrue extends JFrame {

	private JPanel contentPane;

	static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	private JTextField txtVecchiaTarghettaNuova;
	
	public static void PassaASetTartarugaTrue(AmmissioneTartaruga boh) {
		boh = temp;
	}

	/**
	 * Create the frame.
	 */
	public SetTartarugaTrue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtVecchiaTarghettaNuova = new JTextField();
		txtVecchiaTarghettaNuova.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtVecchiaTarghettaNuova.setText("Vecchia targhetta                      Nuova targhetta");
		txtVecchiaTarghettaNuova.setEditable(false);
		txtVecchiaTarghettaNuova.setBounds(10, 10, 803, 59);
		contentPane.add(txtVecchiaTarghettaNuova);
		txtVecchiaTarghettaNuova.setColumns(10);
	}

}
