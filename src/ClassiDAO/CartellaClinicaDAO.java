package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.CartellaClinica;
import ClassiTabelle.Dipendente;
import PackageController.Controller;

public class CartellaClinicaDAO {
	public static void pushCartellaClinica (CartellaClinica boh) {
		

		
		String query1 = "INSERT INTO CARTELLA_CLINICA VALUES ('"  
				+boh.getSpecie()+"',"+boh.getLunghezza()+","+boh.getLarghezza()+","+boh.getPeso()+",'"+boh.getOcchi()+"','"
				+boh.getTesta()+"','"+boh.getNaso()+"','"+boh.getBecco()+"','"+boh.getCollo()+"','"+boh.getPinne()+"','"+boh.getCoda()
				+"','"+boh.getIDCartellaClinica()+"','"+boh.getDocumentazione()+"');";
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
					if (e.getSQLState().equals("02000")) {
						System.out.println("Tutto apposto");
					}
					else if (e.getSQLState().equals("23505")) {
						System.out.println("Esiste già una cartella clinica con quell'id");
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreSpecifico("Esiste già una cartella clinica con quell'id!");
					}
					else if (e.getSQLState().equals("42703")) {
						System.out.println("In Lunghezza, Larghezza e peso devi inserire dei valori validi!");
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreSpecifico("Per Lunghezza, Larghezza e Peso inserire valori validi! (int o float CON IL PUNTO)");
					}
					else if (e.getSQLState().equals("23514")) {
						System.out.println("Per favore nelle parti del corpo della tartaruga inserire solo espressioni valide");
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreSpecifico("Ogni parte della tartaruga deve essere associata ad uno stato! ");
					}
					else {
						System.out.println(e.getSQLState());
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreGenerico();
					}
					
				}
		
	}
	
	public static ArrayList <CartellaClinica> CartelleDiAmmissione(String boh){
		
		ArrayList<CartellaClinica> dapassare = new ArrayList<CartellaClinica>();
		
		String query = "SELECT * FROM Cartelle_Di_Una_Ammissione WHERE ID_Ammissione = '"+boh+"';";
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
				CartellaClinica temp = new CartellaClinica();
				temp.setSpecie(result.getString(1));
				temp.setLunghezza(result.getString(2));
				temp.setLarghezza(result.getString(3));
				temp.setPeso(result.getString(4));
				temp.setOcchi(result.getString(5));
				temp.setTesta(result.getString(6));
				temp.setNaso(result.getString(7));
				temp.setBecco(result.getString(8));
				temp.setCollo(result.getString(9));
				temp.setPinne(result.getString(10));
				temp.setCoda(result.getString(11));
				temp.setIDCartellaClinica(result.getString(12));
				temp.setDocumentazione(result.getString(13));
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
	
	public static ArrayList<CartellaClinica> StatAnnuali(String boh){

		ArrayList<CartellaClinica> dapassare = new ArrayList<CartellaClinica>();
		
		String query = "SELECT * FROM Cartelle_Data_Documentazione "
				+ "WHERE (SELECT date_part('year', Data_Di_Documentazione)) = '"+boh+"' "
				+ "ORDER BY Data_Di_Documentazione;";
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
				CartellaClinica temp = new CartellaClinica();
				temp.setSpecie(result.getString(1));
				temp.setLunghezza(result.getString(2));
				temp.setLarghezza(result.getString(3));
				temp.setPeso(result.getString(4));
				temp.setOcchi(result.getString(5));
				temp.setTesta(result.getString(6));
				temp.setNaso(result.getString(7));
				temp.setBecco(result.getString(8));
				temp.setCollo(result.getString(9));
				temp.setPinne(result.getString(10));
				temp.setCoda(result.getString(11));
				temp.setIDCartellaClinica(result.getString(12));
				temp.setDocumentazione(result.getString(14));
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
	
	public static ArrayList<CartellaClinica> StatMensili (String Mese, String Anno){
		
		ArrayList<CartellaClinica> dapassare = new ArrayList<CartellaClinica>();
		
		String query = "SELECT * FROM Cartelle_Data_Documentazione "
				+ "WHERE (SELECT date_part('year', Data_Di_Documentazione)) = '"+Anno+"' "
				+ "AND (SELECT date_part('month', Data_Di_Documentazione)) = '"+Mese+"' "
				+ "ORDER BY Data_Di_Documentazione;";
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
				CartellaClinica temp = new CartellaClinica();
				temp.setSpecie(result.getString(1));
				temp.setLunghezza(result.getString(2));
				temp.setLarghezza(result.getString(3));
				temp.setPeso(result.getString(4));
				temp.setOcchi(result.getString(5));
				temp.setTesta(result.getString(6));
				temp.setNaso(result.getString(7));
				temp.setBecco(result.getString(8));
				temp.setCollo(result.getString(9));
				temp.setPinne(result.getString(10));
				temp.setCoda(result.getString(11));
				temp.setIDCartellaClinica(result.getString(12));
				temp.setDocumentazione(result.getString(14));
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
