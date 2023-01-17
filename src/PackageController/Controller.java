package PackageController;
import ClassiDAO.AmmissioneTartarugaDAO;
import ClassiDAO.CartellaClinicaDAO;
import ClassiDAO.DipendenteDAO;
import ClassiDAO.DocumentazioneDAO;
import ClassiDAO.SedeDAO;
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
import Errori.ErroreDipendente;
import Errori.ErroreCentroNonEsiste;
import Errori.ErroreDataNonValida;
import Errori.ErroreDimesioneVasca;
import Errori.ErroreDipendenteRuolo;
import Errori.ErroreFloatCartellaClinica;
import Errori.ErroreGenerico;
import Errori.ErroreIDAmmissione;
import Errori.ErroreIDCartellaClinica;
import Errori.ErroreIDDocumentazione;
import Errori.ErroreIDTartaruga;
import Errori.ErroreIDVasca;
import Errori.ErroreSede;
import Errori.ErroreStatoTartaruga;
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
	
	public static void AppareErroreDipendente() {
		ErroreDipendente ErroreDipendente1 = new ErroreDipendente();
		ErroreDipendente1.setVisible(true);
	}
	
	public static void AppareErroreCentroNonEsiste() {
		ErroreCentroNonEsiste ErroreCentroNonEsiste1 = new ErroreCentroNonEsiste();
		ErroreCentroNonEsiste1.setVisible(true);
	}

	public static void AppareErroreDipendenteRuolo() {
		ErroreDipendenteRuolo ErroreDipendenteRuolo1 = new ErroreDipendenteRuolo();
		ErroreDipendenteRuolo1.setVisible(true);
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
	
	public static void AppareErroreIDAmmissione() {
		ErroreIDAmmissione ErroreIDAmmissione1 = new ErroreIDAmmissione();
		ErroreIDAmmissione1.setVisible(true);
	}
	
	public static void AppareErroreDataNonValida() {
		ErroreDataNonValida ErroreDataNonValida1 = new ErroreDataNonValida();
		ErroreDataNonValida1.setVisible(true);
	}
	
	public static void AppareErroreIDTartaruga() {
		ErroreIDTartaruga ErroreIDTartaruga1 = new ErroreIDTartaruga();
		ErroreIDTartaruga1.setVisible(true);
	}
	
	public static void AppareSetDocumentazione() {
		SetDocumentazione SetDocumentazione1 = new SetDocumentazione();
		SetDocumentazione1.setVisible(true);
	}
	
	public static void AppareErroreIDDocumentazione() {
		ErroreIDDocumentazione ErroreIDDocumentazione1 = new ErroreIDDocumentazione();
		ErroreIDDocumentazione1.setVisible(true);
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
	
	public static void AppareErroreIDCartellaClinica() {
		ErroreIDCartellaClinica ErroreIDCartellaClinica1 = new ErroreIDCartellaClinica(); 
		ErroreIDCartellaClinica1.setVisible(true);
	}
	
	public static void AppareErroreFloatCartellaClinica() {
		ErroreFloatCartellaClinica ErroreFloatCartellaClinica1 = new ErroreFloatCartellaClinica();
		ErroreFloatCartellaClinica1.setVisible(true);
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
	
	public static void AppareErroreDimesioneVasca() {
		ErroreDimesioneVasca ErroreDimesioneVasca1 = new ErroreDimesioneVasca();
		ErroreDimesioneVasca1.setVisible(true);
	}
	
	public static void AppareVascaTartaruga() {
		VascaTartaruga VascaTartaruga1 = new VascaTartaruga();
		VascaTartaruga1.setVisible(true);
	}
	
	public static void AppareErroreVascaTartaruga() {
		ErroreVascaTartaruga ErroreVascaTartaruga1 = new ErroreVascaTartaruga();
		ErroreVascaTartaruga1.setVisible(true);
	}
	
	//INSERIMENTO DI UNA CLASSE NEL DAO CORRISPONDENTE
	
	public static void PassaPerIlSedeDAO(Sede foo) {
		SedeDAO.PushSede(foo);
	}
	
	public static void PassaPerIlDipendenteDAO(Dipendente foo) {
		DipendenteDAO.PushDipendente(foo);
	}
	
	public static void PassaPerIlAmmissioneDAO(AmmissioneTartaruga foo) {
		AmmissioneTartarugaDAO.pushAmmissione(foo);
	}
	
	public static void PassaPerIlTartarugaDAO(AmmissioneTartaruga foo) {
		AmmissioneTartarugaDAO.pushTartaruga(foo);
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
		AmmissioneTartarugaDAO.CancellaAmmissioneIndebita(foo);
	}
	
	public static void DocumentazioneIndebita(String foo) {
		DocumentazioneDAO.CancellaDocumentazioneIndebita(foo);
	}
	
}
