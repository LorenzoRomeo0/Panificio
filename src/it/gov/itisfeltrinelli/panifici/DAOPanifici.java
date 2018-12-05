package it.gov.itisfeltrinelli.panifici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		citta = new ArrayList<String>();
		provincia = new ArrayList<String>();
		regione = new ArrayList<String>();
		panetteria = new ArrayList<String>();
		
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
			for(;result.next();) 
				citta.add(result.getString("Citta"));
			
			String query1="select provincia from panifici";
			ResultSet result1=statement.executeQuery(query1);
			for(;result1.next();)  
				provincia.add(result1.getString("provincia"));
			
			String query2="select regione from panifici";
			ResultSet result2=statement.executeQuery(query2);
			for(;result2.next();) 
				regione.add(result2.getString("regione"));
			
			String query3="select panetteria from panifici";
			ResultSet result3=statement.executeQuery(query3);
			for(;result3.next();)  
				panetteria.add(result3.getString("panetteria"));
			
			for(int i=0; i<citta.size(); i++) {
				panifici.add(new Panificio(citta.get(i), provincia.get(i), regione.get(i), panetteria.get(i)));
			}
		}catch(Exception e) {
			System.out.println("Errore nell'inizializzazione array ");
			e.printStackTrace();
		}
		return panifici;
	}
		
	public ArrayList<String> getProvince(){
		ArrayList<String> province= new ArrayList<String>();
		return province;
	}

	public ArrayList<Panificio> getPanifici() {
		return panifici;
	}

	public void setPanifici(ArrayList<Panificio> panifici) {
		this.panifici = panifici;
	}

	public ArrayList<String> getProvincia() {
		return provincia;
	}

	public void setProvincia(ArrayList<String> provincia) {
		this.provincia = provincia;
	}

	public ArrayList<String> getRegione() {
		return regione;
	}

	public void setRegione(ArrayList<String> regione) {
		this.regione = regione;
	}

	public ArrayList<String> getPanetteria() {
		return panetteria;
	}

	public void setPanetteria(ArrayList<String> panetteria) {
		this.panetteria = panetteria;
	}

	
	public List<String> getCitta(String provincia) {
		List<String> lp=new ArrayList<String>();
		try {
			PreparedStatement s=c.prepareStatement("SELECT DISTINCT Citta FROM panifici WHERE Provincia=? ORDER BY 1 ASC");
			s.setString(1, provincia);
			ResultSet rs=s.executeQuery();
			while (rs.next()) {
				lp.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lp;
	}

	public void closeDB() {
		try {
			c.close();
			c=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
