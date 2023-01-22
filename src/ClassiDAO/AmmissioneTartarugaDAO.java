package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.AmmissioneTartaruga;
import ClassiTabelle.Sede;

public class AmmissioneTartarugaDAO {
	
	public static ArrayList ViewAmmissioniTartarughe() {
		ArrayList<AmmissioneTartaruga> dapassare = new ArrayList<AmmissioneTartaruga>();
		
		String query = "SELECT * FROM AMMISSIONE JOIN TARTARUGA ON FKAmmissione = ID_Ammissione ORDER BY Data_di_ammissione"; 
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
				AmmissioneTartaruga temp = new AmmissioneTartaruga();
				temp.setRiammissione(result.getString(1));
				if(result.getBoolean(1) == true) {
					temp.setRiammissione("Sì");
				}
				else {
					temp.setRiammissione("No");
				}
				
				temp.setDataDiAmmissione(result.getString(2));
				temp.setIDAmmissione(result.getString(3));
				temp.setCentro(result.getString(4));
				temp.setNome(result.getString(5));
				temp.setIDTartaruga(result.getString(6));
				temp.setTarghetta(result.getString(7));
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

}
