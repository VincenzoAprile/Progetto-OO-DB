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
	
	public ArrayList<DocumentazioniCartelleCliniche> AllDocumentazioniCartelleCliniche () {
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
	
	public void DeleteDocumentazioneCartellaClinica(String boh) {
		
		String query1 = "DELETE FROM DOCUMENTAZIONE WHERE ID_Documentazione = "
				+"(SELECT ID_Documentazione FROM Documentazione JOIN CARTELLA_CLINICA ON Documentazione = ID_Documentazione "
				+ "WHERE ID_CartellaClinica = '"+boh+"')";
		//DEFINIZIONE DELLA QUERY
		try {
			Class.forName("org.postgresql.Driver"); // APERTURA DRIVER JDBC (DA ISTALLARE PRIMA IN JAVA BUILD PATH)
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Non trovato");
		}
		try {
			Properties props = new Properties(); //DEFINIZIONE DELLA CLASSE PER INSERIRE USER, PASSWORD E SSL
			props.setProperty("user", "postgres");
			props.setProperty("password", "tantomelascordo");
			props.setProperty("ssl", "false");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProvaO", props);  //PER STABILIRE LA CONNESSIONE CON IL DATABASE
			Statement statement = con.createStatement();    //PER INIZIARE UNA SERIE DI QUERY
			statement.executeQuery(query1);  //PER ESEGUIRE UNA QUERY
			
			
			statement.close();
			con.close();  //PER TERMINARE QUERY E LA CONNESSIONE
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
