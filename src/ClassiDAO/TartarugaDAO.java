package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.AmmissioneTartaruga;
import ClassiTabelle.Dipendente;
import ClassiTabelle.Tartaruga;
import PackageController.Controller;

public class TartarugaDAO {
	
	public static String CercaNomeTartaruga (String boh) { 


		String query = "SELECT Nome FROM Tartaruga WHERE Targhetta = '"+boh+"' GROUP BY Nome;"; 
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
	
	public static void pushTartaruga(AmmissioneTartaruga boh) {


		
		String query1 = "INSERT INTO TARTARUGA"
				+ " VALUES ('"+boh.getNome()+"','"+boh.getIDTartaruga()+"','"+boh.getTarghetta()+"','"+boh.getIDAmmissione()+"');"; 
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
						Controller.AppareErroreSpecifico("Già esiste una tartaruga con quell'id!");
						AmmissioneDAO.CancellaAmmissioneIndebita(boh);
						
					}
		
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");	
					}
					else if(e.getSQLState().equals("P0001")) {
						System.out.println("La targhetta è già presente nel database");
						Controller.AppareErroreSpecifico("Esiste già una tartaruga con quella targhetta nel database!");
						AmmissioneDAO.CancellaAmmissioneIndebita(boh);
					}
					else {
						System.out.println(e.getSQLState());
						AmmissioneDAO.CancellaAmmissioneIndebita(boh);
					}
				}
		
	}

	public static ArrayList<Tartaruga> TartarugheSenzaVasca(){
		
ArrayList<Tartaruga> dapassare = new ArrayList<Tartaruga>();
		
		String query = "SELECT * FROM Tartarughe_Senza_Vasca;"; 
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
				Tartaruga temp = new Tartaruga();
				temp.setNome(result.getString(1));
				temp.setIDTartaruga(result.getString(2));
				temp.setTarghetta(result.getString(3));
				temp.setFKAmmissione(result.getString(4));
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
