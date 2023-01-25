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

import ClassiTabelle.Dipendente;
import java.awt.Window.Type;

public class AllDipendenti extends JFrame {

	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public AllDipendenti(ArrayList<Dipendente> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 912, 542);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Matricola");
		model.addColumn("Nome");
		model.addColumn("Cognome");
		model.addColumn("Ruolo");
		model.addColumn("ID Centro");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [5];
			boh[0] = temp.get(i).getMatricola();
			boh[1] = temp.get(i).getNome();
			boh[2] = temp.get(i).getCognome();
			boh[3] = temp.get(i).getRuolo();
			boh[4] = temp.get(i).getCentro();
			
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
		
	}

}
