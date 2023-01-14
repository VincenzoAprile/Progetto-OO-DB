package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ClassiGUI.SetCartellaClinica;
import ClassiTabelle.Documentazione;
import PackageController.Controller;

public class DocumentazioneDAO {
	
	public static void pushDocumentazione(Documentazione boh) {
		
		String query = "INSERT INTO DOCUMENTAZIONE VALUES "
					+ "('"+boh.getVeterinario()+"','"+boh.getLuogoDiRitrovamento()+"','"+boh.getData()+"','"+boh.getIDDocumentazione()+"','"
					+boh.getEtichetta()+"');";
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
						System.out.println("Hai inserito un id già assegnato a un altra documentazione");
						Controller.AppareMainGUI();
						Controller.AppareErroreIDDocumentazione();
					}
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");
						Controller.AppareSetCartellaClinica();
						SetCartellaClinica.setDocumentazione(boh.getIDDocumentazione());
					}
					else if (e.getSQLState().equals("23503")) {
						System.out.println("Quella tartaruga non esiste");
						Controller.AppareMainGUI();
						Controller.AppareErroreTartarugaNonEsiste();
					}
					else if (e.getSQLState().equals("P0001")) {
						System.out.println("Il Veterinario inserito non corrisponde a un veterinario presente nella sede corrispondente");
						System.out.println("Oppure la data inserita non è valida (Deve essere SUCCESSIVA alla data di ammissione della tartaruga corrispondente)");
						Controller.AppareMainGUI();
						Controller.AppareErroreVeterinarioOrData();
					}
					else {
						Controller.AppareMainGUI();
						Controller.AppareErroreGenerico();
					}
				}
	}
	
	public static void CancellaDocumentazioneIndebita (String IDDocumentazione) {
		String query1 = "DELETE FROM Documentazione WHERE ID_Documentazione = '"+IDDocumentazione+"';";
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
