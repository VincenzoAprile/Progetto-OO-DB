package PackageController;
import ClassiDAO.AmmissioneTartarugaDAO;
import ClassiDAO.DipendenteDAO;
import ClassiDAO.SedeDAO;
import ClassiGUI.AddNew;
import ClassiGUI.MainGUI;
import ClassiGUI.SetAmmissione;
import ClassiGUI.SetDipendente;
import ClassiGUI.SetSede;
import ClassiGUI.SetTartarugaFalse;
import ClassiGUI.SetTartarugaTrue;
import ClassiTabelle.AmmissioneTartaruga;
import ClassiTabelle.Dipendente;
import ClassiTabelle.Sede;
import Errori.ErroreDipendente;
import Errori.ErroreCentroNonEsiste;
import Errori.ErroreDataNonValida;
import Errori.ErroreDipendenteRuolo;
import Errori.ErroreGenerico;
import Errori.ErroreIDAmmissione;
import Errori.ErroreIDTartaruga;
import Errori.ErroreSede;

public class Controller {
	static MainGUI Principale = new MainGUI();
	static AddNew AddNew1 = new AddNew();
	static SetSede SetSede1 = new SetSede();
	static ErroreGenerico ErroreGenerico1 = new ErroreGenerico();
	static ErroreSede ErroreSede1 = new ErroreSede();
	static SetDipendente SetDipendente1 = new SetDipendente();
	static ErroreDipendente ErroreDipendente1 = new ErroreDipendente();
	static ErroreCentroNonEsiste ErroreCentroNonEsiste1 = new ErroreCentroNonEsiste();
	static ErroreDipendenteRuolo ErroreDipendenteRuolo1 = new ErroreDipendenteRuolo();
	static SetAmmissione SetAmmissione1 = new SetAmmissione();
	static SetTartarugaTrue SetTartarugaTrue1 = new SetTartarugaTrue();
	static SetTartarugaFalse SetTartarugaFalse1 = new SetTartarugaFalse();
	static ErroreIDAmmissione ErroreIDAmmissione1 = new ErroreIDAmmissione();
	static ErroreDataNonValida ErroreDataNonValida1 = new ErroreDataNonValida();
	static ErroreIDTartaruga ErroreIDTartaruga1 = new ErroreIDTartaruga();
	
	
	public static void main(String[] args) {
		
		
		AppareMainGUI();
		
	
		
		

	}
	//CREZIONE METODI PER FAR APPARIRE E SCOMPARIRE I VARI PEZZI DI GUI
	public static void AppareMainGUI(){
		Principale.setVisible(true); 
	}
	
	public static void ScopareMainGUI() {
		Principale.setVisible(false);
	}
	
	public static void AppareAddNew(){
		AddNew1.setVisible(true); 
	}
	public static void ScopareAddNew() {
		AddNew1.setVisible(false);
	}
	
	public static void AppareSetSede() {
		SetSede1.setVisible(true);
	}
	
	public static void ScompareSetSede() {
		SetSede1.setVisible(false);
	}
	
	public static void AppareErroreGenerico() {
		ErroreGenerico1.setVisible(true);
	}
	
	public static void ScompareErroreGenerico() {
		ErroreGenerico1.setVisible(false);
	}
	
	public static void ScompareErroreSede() {
		ErroreSede1.setVisible(false);
	}
	
	public static void AppareErroreSede() {
		ErroreSede1.setVisible(true);
	}
	
	public static void AppareSetDipendente() {
		SetDipendente1.setVisible(true);
	}
	
	public static void ScompareSetDipendente() {
		SetDipendente1.setVisible(false);
	}
	
	public static void AppareErroreDipendente() {
		ErroreDipendente1.setVisible(true);
	}
	
	public static void ScompareErroreDipendente() {
		ErroreDipendente1.setVisible(false);
	}
	
	public static void AppareErroreCentroNonEsiste() {
		ErroreCentroNonEsiste1.setVisible(true);
	}
	
	public static void ScompareErroreCentroNonEsiste() {
		ErroreCentroNonEsiste1.setVisible(false);
	}
	
	public static void AppareErroreDipendenteRuolo() {
		ErroreDipendenteRuolo1.setVisible(true);
	}
	
	public static void ScompareErroreDipendenteRuolo() {
		ErroreDipendenteRuolo1.setVisible(false);
	}
	
	public static void AppareSetAmmissione() {
		SetAmmissione1.setVisible(true);
	}
	
	public static void ScompareSetAmmissione() {
		SetAmmissione1.setVisible(false);
	}
	
	public static void AppareSetTartarugaTrue() {
		SetTartarugaTrue1.setVisible(true);
	}
	
	public static void ScompareSetTartarugaTrue() {
		SetTartarugaTrue1.setVisible(false);
	}
	
	public static void AppareSetTartarugaFalse() {
		SetTartarugaFalse1.setVisible(true);
	}
	
	public static void ScompareSetTartarugaFalse() {
		SetTartarugaFalse1.setVisible(false);
	}
	
	public static void AppareErroreIDAmmissione() {
		ErroreIDAmmissione1.setVisible(true);
	}
	
	public static void ScompareErroreIDAmmissione() {
		ErroreIDAmmissione1.setVisible(false);
	}
	
	public static void AppareErroreDataNonValida() {
		ErroreDataNonValida1.setVisible(true);
	}
	
	public static void ScompareErroreDataNonValida() {
		ErroreDataNonValida1.setVisible(false);
	}
	
	public static void AppareErroreIDTartaruga() {
		ErroreIDTartaruga1.setVisible(true);
	}
	
	public static void ScompareErroreIDTartaruga() {
		ErroreIDTartaruga1.setVisible(false);
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
	
	//METODO PER PASSARE NEI SETTARTARUGA FALSE\TRUE
	
	public static void ControllerPassaTartarugaTrue(AmmissioneTartaruga foo) {
		SetTartarugaTrue.PassaASetTartarugaTrue(foo);
	}
	
	public static void ControllerPassaTartarugaFalse(AmmissioneTartaruga foo) {
		SetTartarugaFalse.PassaASetTartarugaFalse(foo);
		
	}
	
}
