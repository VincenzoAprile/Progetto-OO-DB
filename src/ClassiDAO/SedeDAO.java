package ClassiDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.Sede;
import PackageController.Controller;

public class SedeDAO {
	

	private SedeDAO() {}
	
	private static SedeDAO IstanzaSedeDAO = null;
	
	/*LOGICA DEL PATTERN SINGLETON*/
	public static SedeDAO GetIstanza() {
		if (IstanzaSedeDAO == null) {
			IstanzaSedeDAO = new SedeDAO();
		}
		return IstanzaSedeDAO;
	}
	
	
	Controller controller = Controller.GetIstanza();
	
	public void PushSede (Sede boh) {
		
		
		
		String query = "INSERT INTO CENTRO_TARTARUGHE_MARINE"
		+ " VALUES ('"+boh.getIndirizzo()+"','"+boh.getContatti()+"','"+boh.getNomeCentro()+"','"+boh.getIDCentro()+"');"; 
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
				System.out.println("Hai inserito un id già assegnato a un altro centro");
				controller.AppareErroreSpecifico("Già esiste una sede con quell'ID!");
			}
			else if (e.getSQLState().equals("02000")){
				System.out.println("Operazione avvenuta con successo");
			}
			else {
				controller.AppareErroreGenerico();
			}
		}
	
		
		
	}

	public ArrayList<Sede> ViewSedi() {
		ArrayList<Sede> dapassare = new ArrayList<Sede>();
		
		String query = "SELECT * FROM CENTRO_TARTARUGHE_MARINE"; 
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
				Sede temp = new Sede();
				temp.setIndirizzo(result.getString(1));
				temp.setContatti(result.getString(2));
				temp.setNomeCentro(result.getString(3));
				temp.setIDCentro(result.getString(4));
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
	
	public void DeleteSede(String boh) {
		String query1 = "DELETE FROM CENTRO_TARTARUGHE_MARINE WHERE ID_Centro = '"+boh+"';";
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


