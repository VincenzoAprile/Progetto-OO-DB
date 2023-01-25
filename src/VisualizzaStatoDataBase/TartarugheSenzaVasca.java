package VisualizzaStatoDataBase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ClassiTabelle.Tartaruga;
import java.awt.Window.Type;

public class TartarugheSenzaVasca extends JFrame {

	private JTable table;


	/**
	 * Create the frame.
	 */
	public TartarugheSenzaVasca(ArrayList<Tartaruga> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 655, 375);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Nome");
		model.addColumn("IDTartaruga");
		model.addColumn("Targhetta");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [3];
			boh[0] = temp.get(i).getNome();
			boh[1] = temp.get(i).getIDTartaruga();
			boh[2] = temp.get(i).getTarghetta();
			
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
		
	}

}
