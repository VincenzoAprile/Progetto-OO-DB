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

import ClassiTabelle.Vasca;
import java.awt.Window.Type;

public class AllVasche extends JFrame {

	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public AllVasche(ArrayList<Vasca> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 656, 432);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("ID Vasca");
		model.addColumn("Tipo");
		model.addColumn("Lunghezza");
		model.addColumn("Larghezza");
		model.addColumn("Profondità");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [5];
			boh[0] = temp.get(i).getCodiceVasca();
			boh[1] = temp.get(i).getTipo();
			boh[2] = temp.get(i).getLunghezza();
			boh[3] = temp.get(i).getLarghezza();
			boh[4] = temp.get(i).getProfondità();
			
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
		
	}

}
