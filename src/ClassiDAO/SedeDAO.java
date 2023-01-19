package ClassiDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import ClassiTabelle.Sede;
import PackageController.Controller;

public class SedeDAO {
	public static void PushSede (Sede boh) {
		
		
		
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
				Controller.AppareErroreSpecifico("Già esiste una sede con quell'ID!");
			}
			else if (e.getSQLState().equals("02000")){
				System.out.println("Operazione avvenuta con successo");
			}
			else {
				Controller.AppareErroreGenerico();
			}
		}
	
		
		
	}

	public static ArrayList ViewSedi() {
		ArrayList<Sede> temp = new ArrayList<Sede>();
		Sede sede1 = new Sede();
		Sede sede2 = new Sede();
		sede1.setContatti("boh");
		sede1.setIDCentro("bah");
		sede1.setIndirizzo("beh");
		sede1.setNomeCentro("buh");
		sede2.setContatti("qui");
		sede2.setIDCentro("quo");
		sede2.setIndirizzo("qua");
		sede2.setNomeCentro("paperino");
		
		temp.add(sede1);
		temp.add(sede2);
		
		return temp;
	}
}


