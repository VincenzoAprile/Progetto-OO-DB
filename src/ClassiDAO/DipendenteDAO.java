package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ClassiTabelle.Dipendente;
import PackageController.Controller;

public class DipendenteDAO {
	public static void PushDipendente (Dipendente boh) {
		
		
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
						Controller.AppareErroreDipendente();
					}
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");
					}
					else if (e.getSQLState().equals("23503")){
						System.out.println("Il centro inserito non esiste!");
						Controller.AppareErroreCentroNonEsiste();
					}
					else if (e.getSQLState().equals("23514")){
						System.out.println("Il ruolo inserito non esiste!");
						Controller.AppareErroreDipendenteRuolo();	
					}
					else {
						System.out.println("Errore!");
						Controller.AppareErroreGenerico();
					}
						
				}
	}

}
