package ClassiTabelle;

public class Dipendente {
	
	private String Matricola;
	private String Nome;
	private String Cognome;
	private String Ruolo;
	private String Centro;
	
	//SETTER
	
	public void setMatricola(String Matricola) {
		this.Matricola = Matricola;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}
	
	public void setRuolo(String Ruolo) {
		this.Ruolo = Ruolo;
	}
	
	public void setCentro(String Centro) {
		this.Centro = Centro;
	}
	
	//GETTER
	
	public String getMatricola() {
		return Matricola;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public String getCognome() {
		return Cognome;
	}
	
	public String getRuolo() {
		return Ruolo;
	}
	
	public String getCentro() {
		return Centro;
	}

}
