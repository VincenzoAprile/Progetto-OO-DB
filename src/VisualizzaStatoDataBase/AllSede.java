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

import ClassiTabelle.Sede;
import java.awt.Window.Type;

public class AllSede extends JFrame {

	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public AllSede(ArrayList<Sede> temp) {
		setType(Type.UTILITY);
		setTitle("Sedi");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 912, 542);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Nome");
		model.addColumn("ID_Sede");
		model.addColumn("Indirizzo");
		model.addColumn("Contatti");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [4];
			boh[0] = temp.get(i).getNomeCentro();
			boh[1] = temp.get(i).getIDCentro();
			boh[2] = temp.get(i).getIndirizzo();
			boh[3] = temp.get(i).getContatti();
			
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
		
		
	}

}
