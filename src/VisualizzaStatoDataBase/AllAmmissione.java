package VisualizzaStatoDataBase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ClassiTabelle.Ammissione;

public class AllAmmissione extends JFrame {

	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public AllAmmissione(ArrayList<Ammissione> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 912, 542);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("ID Ammissione");
		model.addColumn("Riammissione");
		model.addColumn("Data Di Ammissione");
		model.addColumn("Centro");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [6];
			boh[0] = temp.get(i).getIDAmmissione();
			boh[1] = temp.get(i).getRiammissione();
			boh[2] = temp.get(i).getDataDiAmmissione();
			boh[3] = temp.get(i).getCentro();
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
	}

}
