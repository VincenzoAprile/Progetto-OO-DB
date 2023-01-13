package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ClassiTabelle.AmmissioneTartaruga;
import PackageController.Controller;

public class AmmissioneTartarugaDAO {
	
	public static void pushAmmissione(AmmissioneTartaruga boh) {
		
		String query1 = "INSERT INTO AMMISSIONE"
				+ " VALUES ("+boh.getRiammissione()+",'"+boh.getDataDiAmmissione()+"','"+boh.getIDAmmissione()+"','"+boh.getCentro()+"');"; 
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
					if (e.getSQLState().equals("23505")) {
						System.out.println("Hai inserito un id già assegnato a un altro dipendente");
						
						Controller.ScompareSetTartarugaFalse();
						Controller.ScompareSetTartarugaTrue();
						Controller.AppareMainGUI();
						Controller.AppareErroreIDAmmissione();
					}
					else if (e.getSQLState().equals("23503")) {
						System.out.println(e.getSQLState());
						System.out.println("Il centro inserito non esiste");
						
						Controller.ScompareSetTartarugaFalse();
						Controller.ScompareSetTartarugaTrue();
						Controller.AppareMainGUI();
						Controller.AppareErroreCentroNonEsiste();
					}
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");	
					}
					else if (e.getSQLState().equals("22007")){
						System.out.println("Data Non Valida");
						
						Controller.ScompareSetTartarugaFalse();
						Controller.ScompareSetTartarugaTrue();
						Controller.AppareMainGUI();
						Controller.AppareErroreDataNonValida();
					}
					else {
						Controller.ScompareSetTartarugaFalse();
						Controller.ScompareSetTartarugaTrue();
						Controller.AppareMainGUI();
						Controller.AppareErroreGenerico();
					}
				}
	}
	
	public static void pushTartaruga(AmmissioneTartaruga boh) {


		
		String query1 = "INSERT INTO TARTARUGA"
				+ " VALUES ('"+boh.getNome()+"','"+boh.getTarghetta()+"','"+boh.getIDAmmissione()+"');"; 
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
					if (e.getSQLState().equals("23505")) {
						System.out.println("Hai inserito un id già assegnato a altra tartaruga");
						Controller.AppareErroreIDTartaruga();
						AmmissioneTartarugaDAO.CancellaAmmissioneIndebita(boh);
						
					}
		
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");	
					}
					
					else {
						e.printStackTrace();
						Controller.AppareErroreGenerico();
						AmmissioneTartarugaDAO.CancellaAmmissioneIndebita(boh);
						
					}
				}
		
	}
	
	public static void CancellaAmmissioneIndebita(AmmissioneTartaruga boh) {
		
		String query1 = "DELETE FROM AMMISSIONE WHERE ID_AMMISSIONE = '"+ boh.getIDAmmissione()+"';";
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
	public static String CercaNomeTartaruga (String boh) { 

		String query = "SELECT Nome FROM Tartaruga WHERE Targhetta = '"+boh+"';"; 
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
				return result.getString(1);
				
			}
			result.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}


