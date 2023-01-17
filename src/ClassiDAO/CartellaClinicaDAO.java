package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ClassiTabelle.CartellaClinica;
import PackageController.Controller;

public class CartellaClinicaDAO {
	public static void pushCartellaClinica (CartellaClinica boh) {
		

		
		String query1 = "INSERT INTO CARTELLA_CLINICA VALUES ('"  
				+boh.getSpecie()+"',"+boh.getLunghezza()+","+boh.getLarghezza()+","+boh.getPeso()+",'"+boh.getOcchi()+"','"
				+boh.getOcchi()+"','"+boh.getNaso()+"','"+boh.getBecco()+"','"+boh.getCollo()+"','"+boh.getPinne()+"','"+boh.getCoda()
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
						Controller.AppareErroreIDCartellaClinica();
					}
					else if (e.getSQLState().equals("42703")) {
						System.out.println("In Lunghezza, Larghezza e peso devi inserire dei valori validi!");
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreFloatCartellaClinica();
					}
					else if (e.getSQLState().equals("23514")) {
						System.out.println("Per favore nelle parti del corpo della tartaruga inserire solo espressioni valide");
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreStatoTartaruga();
					}
					else {
						System.out.println(e.getSQLState());
						Controller.DocumentazioneIndebita(boh.getDocumentazione());
						Controller.AppareErroreGenerico();
					}
					
				}
		
	}

}
