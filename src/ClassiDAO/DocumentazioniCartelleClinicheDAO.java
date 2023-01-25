package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.AmmissioneTartaruga;
import ClassiTabelle.DocumentazioniCartelleCliniche;

public class DocumentazioniCartelleClinicheDAO {
	
	public static ArrayList<DocumentazioniCartelleCliniche> AllDocumentazioniCartelleCliniche () {
		ArrayList<DocumentazioniCartelleCliniche> dapassare = new ArrayList<DocumentazioniCartelleCliniche>();
		
		String query = "SELECT ID_Documentazione, FK_Tartaruga, ID_CartellaClinica "
				+ "FROM DOCUMENTAZIONE JOIN CARTELLA_CLINICA ON Documentazione = ID_Documentazione"; 
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
				DocumentazioniCartelleCliniche temp = new DocumentazioniCartelleCliniche();
				temp.setIDDocumentazione(result.getString(1));
				temp.setIDTartaruga(result.getString(2));
				temp.setIDCartellaClinica(result.getString(3));
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
