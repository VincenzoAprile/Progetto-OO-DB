package ClassiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiTabelle.AmmissioneTartaruga;

public class SetTartarugaTrue extends JFrame {

	private JPanel contentPane;

	static AmmissioneTartaruga temp = new AmmissioneTartaruga();
	
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
	}

}
