package ClassiTabelle;

public class Documentazione {
	
	private String Veterinario;
	private String LuogoDiRitrovamento;
	private String Data;
	private String IDDocumentazione;
	private String Etichetta;
	
	//Setter
	public void setVeterinario(String Veterinario) {
		this.Veterinario = Veterinario;
	}
	
	public void setLuogoDiRitrovamento(String LuogoDiRitrovamento) {
		this.LuogoDiRitrovamento = LuogoDiRitrovamento;
	}
	
	public void setData(String Data) {
		this.Data = Data;
	}
	
	public void setIDDocumentazione(String IDDocumentazione) {
		this.IDDocumentazione = IDDocumentazione;
	}
	
	public void setEtichetta(String Etichetta) {
		this.Etichetta = Etichetta;
	}
	
	//Getter
	public String getVeterinario() {
		return Veterinario;
	}
	
	public String getLuogoDiRitrovamento() {
		return LuogoDiRitrovamento;
	}
	
	public String getData() {
		return Data;
	}
	
	public String getIDDocumentazione() {
		return IDDocumentazione;
	}
	
	public String getEtichetta() {
		return Etichetta;
	}
}
