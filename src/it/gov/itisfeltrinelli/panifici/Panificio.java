package it.gov.itisfeltrinelli.panifici;

public class Panificio {
	private String citta;
	private String provincia;
	private String regione;
	private String panetteria;
	
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getPanetteria() {
		return panetteria;
	}

	public void setPanetteria(String panetteria) {
		this.panetteria = panetteria;
	}

	Panificio(String c, String p, String r, String pan){
		citta=c;
		provincia=p;
		regione=r;
		panetteria=pan;
	}
}
