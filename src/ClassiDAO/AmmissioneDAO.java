package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.Ammissione;
import ClassiTabelle.AmmissioneTartaruga;
import PackageController.Controller;

public class AmmissioneDAO {
	
	private AmmissioneDAO() {}
	
	private static AmmissioneDAO IstanzaAmmissioneDAO = null;
	
	/*LOGICA DEL PATTERN SINGLETON*/
	public static AmmissioneDAO GetIstanza() {
		if (IstanzaAmmissioneDAO == null) {
			IstanzaAmmissioneDAO = new AmmissioneDAO();
		}
		return IstanzaAmmissioneDAO;
	}
	
	
	Controller controller = Controller.GetIstanza();
	
	
	
	public ArrayList<Ammissione> AmmissionePerTarghetta(String boh){
		
		ArrayList<Ammissione> dapassare = new ArrayList<Ammissione>();
		
		String query = "SELECT * FROM Ammissioni_Di_Una_Targhetta WHERE Targhetta = '"+boh+"';"; 
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Non trovato");
		}
		try {
			Properties props = new Properties(); 
			props.setProperty("user", "postgres");
			props.setProperty("password", "tantomelascordo");
			props.setProperty("ssl", "false");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProvaO", props);  
			Statement statement = con.createStatement();  
			ResultSet result = statement.executeQuery(query);  
			
			while (result.next()) {
				Ammissione temp = new Ammissione();
				if(result.getBoolean(1) == true) {
					temp.setRiammissione("Sì");
				}
				else {
					temp.setRiammissione("No");
				}
				temp.setDataDiAmmissione(result.getString(2));
				temp.setIDAmmissione(result.getString(3));
				temp.setCentro(result.getString(4));
				dapassare.add(temp);
				
			}
			result.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dapassare;
	}
	
	public String StatisticaAmmissioniAnnue(String Anno) {
		
		String dapassare = null;
		
		String query = "SELECT * FROM Numero_Tartarughe_Ammesse_Anno('"+Anno+"');";
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Non trovato");
		}
		try {
			Properties props = new Properties(); 
			props.setProperty("user", "postgres");
			props.setProperty("password", "tantomelascordo");
			props.setProperty("ssl", "false");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProvaO", props);  
			Statement statement = con.createStatement();  
			ResultSet result = statement.executeQuery(query);  
			
			while (result.next()) {
				dapassare = result.getString(1);
			}
			result.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dapassare;
		
	}
	
	public String StatisticheAmmissioniMensili(String Mese, String Anno) {

		
		String dapassare = null;
		
		String query = "SELECT * FROM Numero_Tartarughe_Ammesse_Anno_Mese('"+Anno+"','"+Mese+"');";
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Non trovato");
		}
		try {
			Properties props = new Properties(); 
			props.setProperty("user", "postgres");
			props.setProperty("password", "tantomelascordo");
			props.setProperty("ssl", "false");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProvaO", props);  
			Statement statement = con.createStatement();  
			ResultSet result = statement.executeQuery(query);  
			
			while (result.next()) {
				dapassare = result.getString(1);
			}
			result.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dapassare;
		
	
	}
}


