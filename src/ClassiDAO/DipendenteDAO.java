package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.Dipendente;
import ClassiTabelle.Sede;
import PackageController.Controller;

public class DipendenteDAO {
	

	private DipendenteDAO() {}
	
	private static DipendenteDAO IstanzaDipendenteDAO = null;
	
	/*LOGICA DEL PATTERN SINGLETON*/
	public static DipendenteDAO GetIstanza() {
		if (IstanzaDipendenteDAO == null) {
			IstanzaDipendenteDAO = new DipendenteDAO();
		}
		return IstanzaDipendenteDAO;
	}
	
	
	Controller controller = Controller.GetIstanza();
	
	public void PushDipendente (Dipendente boh) {
		
		
		String query = "INSERT INTO PERSONALE"
				+ " VALUES ('"+boh.getMatricola()+"','"+boh.getNome()+"','"+boh.getCognome()+"','"+boh.getRuolo()+"','"+boh.getCentro()+"');"; 
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
					statement.executeQuery(query);  //PER ESEGUIRE UNA QUERY
					
					
					statement.close();
					con.close();  //PER TERMINARE QUERY E LA CONNESSIONE
				} catch (SQLException e) {
					if (e.getSQLState().equals("23505")) {
						System.out.println("Hai inserito un id già assegnato a un altro dipendente");
						controller.AppareErroreSpecifico("Già esiste un dipendente con quell'id!");
					}
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");
					}
					else if (e.getSQLState().equals("23503")){
						System.out.println("Il centro inserito non esiste!");
						controller.AppareErroreSpecifico("Il centro inserito non esiste!");
					}
					else if (e.getSQLState().equals("23514")){
						System.out.println("Il ruolo inserito non esiste!");
						controller.AppareErroreSpecifico("Il ruolo inserito non esiste!");	
					}
					else {
						System.out.println("Errore!");
						controller.AppareErroreGenerico();
					}
						
				}
	}
	
	public ArrayList<Dipendente> ViewDipendenti() {
		ArrayList<Dipendente> dapassare = new ArrayList<Dipendente>();
		
		String query = "SELECT * FROM PERSONALE"; 
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
				Dipendente temp = new Dipendente();
				temp.setMatricola(result.getString(1));
				temp.setNome(result.getString(2));
				temp.setCognome(result.getString(3));
				temp.setRuolo(result.getString(4));
				temp.setCentro(result.getString(5));
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
	
	public void DeleteDipendente (String boh) {

		String query1 = "DELETE FROM PERSONALE WHERE Matricola = '"+boh+"';";
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
