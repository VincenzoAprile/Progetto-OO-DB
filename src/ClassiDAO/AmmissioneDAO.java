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
	
	public void pushAmmissione(AmmissioneTartaruga boh) {
		
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
						System.out.println("Hai inserito un id già assegnato a un altra ammissione");
						
						controller.ScompareSetTartarugaFalse();
						controller.ScompareSetTartarugaTrue();
						controller.AppareMainGUI();
						controller.AppareErroreSpecifico("Già esiste un'ammissione con quell'id!");
					}
					else if (e.getSQLState().equals("23503")) {
						System.out.println(e.getSQLState());
						System.out.println("Il centro inserito non esiste");
						
						controller.ScompareSetTartarugaFalse();
						controller.ScompareSetTartarugaTrue();
						controller.AppareMainGUI();
						controller.AppareErroreSpecifico("Il centro inserito non esiste!");
					}
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");	
					}
					else if (e.getSQLState().equals("22007")){
						System.out.println("Data Non Valida");
						
						controller.ScompareSetTartarugaFalse();
						controller.ScompareSetTartarugaTrue();
						controller.AppareMainGUI();
						controller.AppareErroreSpecifico("Data inserita non valida!");
					}
					else {
						controller.ScompareSetTartarugaFalse();
						controller.ScompareSetTartarugaTrue();
						controller.AppareMainGUI();
						controller.AppareErroreGenerico();
					}
				}
	}
	
	public void CancellaAmmissioneIndebita(AmmissioneTartaruga boh) {
		
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


