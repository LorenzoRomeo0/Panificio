package it.gov.itisfeltrinelli.panifici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOPanifici {
	Connection c;
	Statement statement;
	private ArrayList<Panificio> panifici;
	private ArrayList<String> citta;
	private ArrayList<String> provincia;
	private ArrayList<String> regione;
	private ArrayList<String> panetteria;
	
	
	
	
	DAOPanifici(){
		try {
		connection("jdbc:mysql://localhost/Panifici?serverTimezone=UTC","root","");
		statement=c.createStatement();
		panifici = new ArrayList<Panificio>();
		getFromDb();
		}catch(Exception e) {
			System.out.println("Errore nell'inizializzazione");
		}
	}
	
	private void connection(String conn, String user, String pw){
		try {
		c= DriverManager.getConnection(conn,user,pw);
		System.out.println("Connessione a "+ conn+" eseguita");
		}catch(Exception e) {
			System.out.println("Errore collegamento");
		}
	}
	
	public void close(){
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Panificio> getFromDb(){
		try {
		ArrayList<Panificio> panifici=new ArrayList<Panificio>();
		String query="select citta from panifici";
		ResultSet result=statement.executeQuery(query);
		for(int i=0; result.next(); i++) 
			citta.add(result.getString(i));
		
		String query1="select provincia from panifici";
		ResultSet result1=statement.executeQuery(query1);
		for(int i=0; result1.next(); i++) 
			provincia.add(result1.getString(i));
		
		String query2="select regione from panifici";
		ResultSet result2=statement.executeQuery(query2);
		for(int i=0; result2.next(); i++) 
			regione.add(result2.getString(i));
		
		String query3="select panetteria from panifici";
		ResultSet result3=statement.executeQuery(query3);
		for(int i=0; result3.next(); i++) 
			panetteria.add(result3.getString(i));
		
		
		for(int i=0; i<citta.size(); i++) {
			panifici.add(new Panificio(citta.get(i), provincia.get(i), regione.get(i), panetteria.get(i)));
			System.out.println(panifici.get(i).citta);
		}
		
		}catch(Exception e) {
			System.out.println("Errore nell'inizializzazione array");
		}
		return panifici;
	}
	
	
	public ArrayList<String> getProvince(){
		ArrayList<String> province= new ArrayList<String>();
		return province;
	}
}
