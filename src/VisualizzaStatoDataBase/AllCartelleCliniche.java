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

import ClassiTabelle.CartellaClinica;

public class AllCartelleCliniche extends JFrame {

	private JTable table;


	public AllCartelleCliniche(ArrayList<CartellaClinica> temp) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 912, 542);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("ID Cartella Clinica");
		model.addColumn("Specie");
		model.addColumn("Lunghezza");
		model.addColumn("Larghezza");
		model.addColumn("Peso");
		model.addColumn("Occhi");
		model.addColumn("Testa");
		model.addColumn("Naso");
		model.addColumn("Becco");
		model.addColumn("Collo");
		model.addColumn("Pinne");
		model.addColumn("Coda");
		model.addColumn("Data");
		
		
		for (int i = 0; i < temp.size(); i++ ) {
			String[] boh = new String [13];
			boh[0] = temp.get(i).getIDCartellaClinica();
			boh[1] = temp.get(i).getSpecie();
			boh[2] = temp.get(i).getLunghezza();
			boh[3] = temp.get(i).getLarghezza();
			boh[4] = temp.get(i).getPeso();
			boh[5] = temp.get(i).getOcchi();
			boh[6] = temp.get(i).getTesta();
			boh[7] = temp.get(i).getNaso();
			boh[8] = temp.get(i).getBecco();
			boh[9] = temp.get(i).getCollo();
			boh[10] = temp.get(i).getPinne();
			boh[11] = temp.get(i).getCoda();
			boh[12] = temp.get(i).getDocumentazione();
			
			model.addRow(boh);
		}
		
		
		
		
		//BISOGNA DISATTIVARE LA FUNZIONALITà DI AUTO RESIZE DELLA TABLE PER RENDERLO SCORRIBILE IN ENTRABE LE DIREZIONI
		
		JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane, BorderLayout.CENTER);
	}

}
