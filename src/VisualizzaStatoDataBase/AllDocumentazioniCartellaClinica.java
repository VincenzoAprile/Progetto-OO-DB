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

import ClassiTabelle.DocumentazioniCartelleCliniche;

public class AllDocumentazioniCartellaClinica extends JFrame {

	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public AllDocumentazioniCartellaClinica(ArrayList<DocumentazioniCartelleCliniche> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 620, 399);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("ID Tartaruga");
		model.addColumn("ID Documentazione");
		model.addColumn("ID Cartella Clinica");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [3];
			boh[0] = temp.get(i).getIDTartaruga();
			boh[1] = temp.get(i).getIDDocumentazione();
			boh[2] = temp.get(i).getIDCartellaClinica();
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
	}

}
