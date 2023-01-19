package PackageController;
import ClassiDAO.AmmissioneDAO;
import ClassiDAO.CartellaClinicaDAO;
import ClassiDAO.DipendenteDAO;
import ClassiDAO.DocumentazioneDAO;
import ClassiDAO.SedeDAO;
import ClassiDAO.TartarugaDAO;
import ClassiDAO.VascaDAO;
import ClassiGUI.AddNew;
import ClassiGUI.MainGUI;
import ClassiGUI.NewVasca;
import ClassiGUI.SetAmmissione;
import ClassiGUI.SetCartellaClinica;
import ClassiGUI.SetDipendente;
import ClassiGUI.SetDocumentazione;
import ClassiGUI.SetSede;
import ClassiGUI.SetTartarugaFalse;
import ClassiGUI.SetTartarugaTrue;
import ClassiGUI.VascaTartaruga;
import ClassiTabelle.AmmissioneTartaruga;
import ClassiTabelle.CartellaClinica;
import ClassiTabelle.Dipendente;
import ClassiTabelle.Documentazione;
import ClassiTabelle.Sede;
import ClassiTabelle.Vasca;
import Errori.ErroreGenerico;
import Errori.ErroreIDTartaruga;
import Errori.ErroreIDVasca;
import Errori.ErroreSede;
import Errori.ErroreSpecifico;
import Errori.ErroreStatoTartaruga;
import Errori.ErroreTarghettaEsistente;
import Errori.ErroreTarghettaNonTrovata;
import Errori.ErroreTartarugaNonEsiste;
import Errori.ErroreVascaTartaruga;
import Errori.ErroreVeterinarioOrData;

public class Controller {
	
	static SetTartarugaFalse SetTartarugaFalse1 = new SetTartarugaFalse();
	static SetTartarugaTrue SetTartarugaTrue1 = new SetTartarugaTrue();
	
	//IL MAIN FA PARTIRE IL PROGRAMMA
	public static void main(String[] args) {
		
		
		AppareMainGUI();
		

	}
	
	//CREZIONE METODI PER FAR APPARIRE I VARI PEZZI DI GUI
	public static void AppareMainGUI(){
		MainGUI MainGUI1 = new MainGUI();
		MainGUI1.setVisible(true); 
	}
	
	public static void AppareAddNew(){
		AddNew AddNew1 = new AddNew();
		AddNew1.setVisible(true); 
	}
	
	public static void AppareSetSede() {
		SetSede SetSede1 = new SetSede();
		SetSede1.setVisible(true);
	}
	
	public static void AppareErroreGenerico() {
		ErroreGenerico ErroreGenerico1 = new ErroreGenerico ();
		ErroreGenerico1.setVisible(true);
	}
	
	public static void AppareErroreSede() {
		ErroreSede ErroreSede1 = new ErroreSede(); 
		ErroreSede1.setVisible(true);
	}
	
	public static void AppareSetDipendente() {
		SetDipendente SetDipendente1 = new SetDipendente();
		SetDipendente1.setVisible(true);
	}
	
	public static void AppareSetAmmissione() {
		SetAmmissione SetAmmissione1 = new SetAmmissione();
		SetAmmissione1.setVisible(true);
	}
	
	public static void AppareSetTartarugaTrue() {
		SetTartarugaTrue1.setVisible(true);
	}
	
	public static void ScompareSetTartarugaTrue() {
		SetTartarugaTrue1.setVisible(false);
	}
	
	public static void ScompareSetTartarugaFalse() {
		SetTartarugaFalse1.setVisible(false);
	}
	
	public static void AppareSetTartarugaFalse() {
		SetTartarugaFalse1.setVisible(true);
	}
	
	public static void AppareErroreIDTartaruga() {
		ErroreIDTartaruga ErroreIDTartaruga1 = new ErroreIDTartaruga();
		ErroreIDTartaruga1.setVisible(true);
	}
	
	public static void AppareSetDocumentazione() {
		SetDocumentazione SetDocumentazione1 = new SetDocumentazione();
		SetDocumentazione1.setVisible(true);
	}
	
	public static void AppareErroreVeterinarioOrData() {
		ErroreVeterinarioOrData ErroreVeterinarioOrData1 = new ErroreVeterinarioOrData();
		ErroreVeterinarioOrData1.setVisible(true);
	}
	
	public static void AppareErroreTartarugaNonEsiste() {
		ErroreTartarugaNonEsiste ErroreTartarugaNonEsiste1 = new ErroreTartarugaNonEsiste();
		ErroreTartarugaNonEsiste1.setVisible(true);
	}
	
	public static void AppareSetCartellaClinica() {
		SetCartellaClinica SetCartellaClinica1 = new SetCartellaClinica();
		SetCartellaClinica1.setVisible(true);
	}
	
	public static void AppareErroreStatoTartaruga() {
		ErroreStatoTartaruga ErroreStatoTartaruga1 = new ErroreStatoTartaruga();
		ErroreStatoTartaruga1.setVisible(true);
	}
	
	public static void AppareNewVasca() {
		NewVasca NewVasca1 = new NewVasca();
		NewVasca1.setVisible(true);
	}
	
	public static void AppareErroreIDVasca() {
		ErroreIDVasca ErroreIDVasca1 = new ErroreIDVasca();
		ErroreIDVasca1.setVisible(true);
	}
	
	public static void AppareVascaTartaruga() {
		VascaTartaruga VascaTartaruga1 = new VascaTartaruga();
		VascaTartaruga1.setVisible(true);
	}
	
	public static void AppareErroreVascaTartaruga() {
		ErroreVascaTartaruga ErroreVascaTartaruga1 = new ErroreVascaTartaruga();
		ErroreVascaTartaruga1.setVisible(true);
	}
	
	public static void AppareErroreTarghettaNonTrovata() {
		ErroreTarghettaNonTrovata ErroreTarghettaNonTrovata1 = new ErroreTarghettaNonTrovata();
		ErroreTarghettaNonTrovata1.setVisible(true);
	}
	
	public static void AppareErroreTarghettaEsistente() {
		ErroreTarghettaEsistente ErroreTarghettaEsistente1 = new ErroreTarghettaEsistente();
		ErroreTarghettaEsistente1.setVisible(true);
	}
	
	/**IL METODO ERRORE SPECIFICO PRENDE COME INPUT UNA STRINGA DA VISUALIZZARE COME ERRORE 
	 * E MOSTRA AUTOMATICAMENTE UNA SCHERMATA CHE LO VISUALIZZA
	 * @param String UN MESSAGGIO DI ERRORE*/
	public static void AppareErroreSpecifico(String foo) {
		ErroreSpecifico ErroreSpecifico1 = new ErroreSpecifico(foo);
		ErroreSpecifico1.setVisible(true);
	}
	
	//INSERIMENTO DI UNA CLASSE NEL DAO CORRISPONDENTE
	
	public static void PassaPerIlSedeDAO(Sede foo) {
		SedeDAO.PushSede(foo);
	}
	
	public static void PassaPerIlDipendenteDAO(Dipendente foo) {
		DipendenteDAO.PushDipendente(foo);
	}
	
	public static void PassaPerIlAmmissioneDAO(AmmissioneTartaruga foo) {
		AmmissioneDAO.pushAmmissione(foo);
	}
	
	public static void PassaPerIlTartarugaDAO(AmmissioneTartaruga foo) {
		TartarugaDAO.pushTartaruga(foo);
	}
	
	public static void PassaPerIlDocumentazioneDAO(Documentazione foo) {
		DocumentazioneDAO.pushDocumentazione(foo);
	}
	
	public static void PassaPerIlCartellaClinicaDAO(CartellaClinica foo) {
		CartellaClinicaDAO.pushCartellaClinica(foo);
	}
	
	public static void PassaPerIlVascaDAO(Vasca foo) {
		VascaDAO.pushVasca(foo);
	}
	
	public static void PassaPerIlVascaTartarugaDAO(String V, String T) {
		VascaDAO.assegnaVascaTartaruga(V, T);
	}
	
	
	
	//METODO PER PASSARE NEI SETTARTARUGA FALSE\TRUE
	
	public static void ControllerPassaTartarugaTrue(AmmissioneTartaruga foo) {
		SetTartarugaTrue.PassaASetTartarugaTrue(foo);
	}
	
	public static void ControllerPassaTartarugaFalse(AmmissioneTartaruga foo) {
		SetTartarugaFalse.PassaASetTartarugaFalse(foo);
		
	}
	
	//METODI PER LA CANCELLAZIONE DI INSERT INDEBITI
	
	public static void AmmissioneIndebita(AmmissioneTartaruga foo) {
		AmmissioneDAO.CancellaAmmissioneIndebita(foo);
	}
	
	public static void DocumentazioneIndebita(String foo) {
		DocumentazioneDAO.CancellaDocumentazioneIndebita(foo);
	}
	
	//TROVA IL NOME DELLA TARTARUGA	
	public static String TrovaNomeTartaruga(String foo) {
		return TartarugaDAO.CercaNomeTartaruga(foo);
	}
}
