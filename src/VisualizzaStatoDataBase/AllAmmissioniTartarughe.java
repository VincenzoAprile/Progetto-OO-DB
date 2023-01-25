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

import ClassiTabelle.AmmissioneTartaruga;
import java.awt.Window.Type;

public class AllAmmissioniTartarughe extends JFrame {

	private JTable table;

	
	
	/**
	 * Create the frame.
	 */
	public AllAmmissioniTartarughe(ArrayList<AmmissioneTartaruga> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 912, 542);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Nome");
		model.addColumn("Targhetta");
		model.addColumn("ID Tartaruga");
		model.addColumn("ID Ammissione");
		model.addColumn("Riammissione");
		model.addColumn("Data Di Ammissione");
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [6];
			boh[0] = temp.get(i).getNome();
			boh[1] = temp.get(i).getTarghetta();
			boh[2] = temp.get(i).getIDTartaruga();
			boh[3] = temp.get(i).getIDAmmissione();
			boh[4] = temp.get(i).getRiammissione();
			boh[5] = temp.get(i).getDataDiAmmissione();
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
	}

}
