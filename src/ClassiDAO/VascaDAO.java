package ClassiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ClassiTabelle.Vasca;
import PackageController.Controller;

public class VascaDAO {
	public static void pushVasca(Vasca boh) {
		String query = "INSERT INTO VASCA VALUES ('"+boh.getCodiceVasca()+"','"+boh.getTipo()+"',"+boh.getLunghezza()+","+
						boh.getLarghezza()+","+boh.getProfondità()+");";
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
						System.out.println("Hai inserito un id già assegnato a un'altra vasca");
						Controller.AppareErroreIDVasca();
					}
					else if (e.getSQLState().equals("02000")){
						System.out.println("Operazione avvenuta con successo");
					}
					else if (e.getSQLState().equals("42703")) {
						System.out.println("Hai inserito nelle dimensioni vasca un valore non valido");
						Controller.AppareErroreSpecifico("In uno delle dimensioni della vasca hai inserito un dato non valido!");
					}
					else {
						System.out.println(e.getSQLState());
					}
				}
			
				
	}

	public static void assegnaVascaTartaruga(String Vasca, String Targhetta) {
		
		String query = "INSERT INTO VASCHE_TARTARUGHE VALUES ('"
				+Vasca+"','"+Targhetta+"');";
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
			if (e.getSQLState().equals("02000")){
				System.out.println("Operazione avvenuta con successo");
			}
			else if (e.getSQLState().equals("23503")) {
				System.out.println("La targhetta o l'id della vasca non sono stati inseriti correttamente");
				Controller.AppareErroreVascaTartaruga();
			}
			else {
				System.out.println(e.getSQLState());
			}
		}
	}
}
