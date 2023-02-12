package PackageController;
import ClassiDAO.AmmissioneDAO;

import ClassiDAO.AmmissioneTartarugaDAO;
import ClassiDAO.CartellaClinicaDAO;
import ClassiDAO.DipendenteDAO;
import ClassiDAO.DocumentazioneDAO;
import ClassiDAO.DocumentazioniCartelleClinicheDAO;
import ClassiDAO.SedeDAO;
import ClassiDAO.TartarugaDAO;
import ClassiDAO.VascaDAO;
import ClassiGUI.AddNew;
import ClassiGUI.AmmissioniCartelle;
import ClassiGUI.Delete;
import ClassiGUI.MainGUI;
import ClassiGUI.NewVasca;
import ClassiGUI.SetAmmissione;
import ClassiGUI.SetCartellaClinica;
import ClassiGUI.SetDipendente;
import ClassiGUI.SetDocumentazione;
import ClassiGUI.SetSede;
import ClassiGUI.SetTartarugaFalse;
import ClassiGUI.SetTartarugaTrue;
import ClassiGUI.StatAmmissioni;
import ClassiGUI.StatAnnuali;
import ClassiGUI.StatMensili;
import ClassiGUI.VascaTartaruga;
import ClassiGUI.SeeSediTartarughe;
import ClassiTabelle.AmmissioneTartaruga;
import ClassiTabelle.CartellaClinica;
import ClassiTabelle.Dipendente;
import ClassiTabelle.Documentazione;
import ClassiTabelle.Sede;
import ClassiTabelle.Vasca;
import Errori.ErroreGenerico;
import Errori.ErroreSpecifico;
import Errori.ErroreVeterinarioOrData;
import VisualizzaStatoDataBase.AllAmmissione;
import VisualizzaStatoDataBase.AllAmmissioniTartarughe;
import VisualizzaStatoDataBase.AllCartelleCliniche;
import VisualizzaStatoDataBase.AllDipendenti;
import VisualizzaStatoDataBase.AllDocumentazioniCartellaClinica;
import VisualizzaStatoDataBase.AllSede;
import VisualizzaStatoDataBase.AllTartarughe;
import VisualizzaStatoDataBase.AllVasche;
import VisualizzaStatoDataBase.TartarugheSenzaVasca;

public class Controller {
	
	private static Controller IstanzaController = null;
	
	
	private Controller() {}
	
	
	/*LOGICA DEL PATTERN SINGLETON*/
	public static Controller GetIstanza() {
		if (IstanzaController == null) {
			IstanzaController = new Controller();
		}
		return IstanzaController;
	}
	
	
	//CREZIONE METODI PER FAR APPARIRE I VARI PEZZI DI GUI
	public void AppareMainGUI(){
		MainGUI MainGUI1 = new MainGUI();
		MainGUI1.setVisible(true); 
	}
	
	public void AppareAddNew(){
		AddNew AddNew1 = new AddNew();
		AddNew1.setVisible(true); 
	}
	
	public void AppareSetSede() {
		SetSede SetSede1 = new SetSede();
		SetSede1.setVisible(true);
	}
	
	public void AppareErroreGenerico() {
		ErroreGenerico ErroreGenerico1 = new ErroreGenerico ();
		ErroreGenerico1.setVisible(true);
	}
	
	public void AppareSetDipendente() {
		SetDipendente SetDipendente1 = new SetDipendente();
		SetDipendente1.setVisible(true);
	}
	
	public void AppareSetAmmissione() {
		SetAmmissione SetAmmissione1 = new SetAmmissione();
		SetAmmissione1.setVisible(true);
	}
	
	public void AppareSetTartarugaTrue() {
		SetTartarugaTrue SetTartarugaTrue1 = SetTartarugaTrue.GetIstanza();
		SetTartarugaTrue1.setVisible(true);
	}
	
	public void ScompareSetTartarugaTrue() {
		SetTartarugaTrue SetTartarugaTrue1 = SetTartarugaTrue.GetIstanza();
		SetTartarugaTrue1.setVisible(false);
	}
	
	public void ScompareSetTartarugaFalse() {
		SetTartarugaFalse SetTartarugaFalse1 = SetTartarugaFalse.GetIstanza();
		SetTartarugaFalse1.setVisible(false);
	}
	
	public void AppareSetTartarugaFalse() {
		SetTartarugaFalse SetTartarugaFalse1 = SetTartarugaFalse.GetIstanza();
		SetTartarugaFalse1.setVisible(true);
	}
	
	
	public void AppareSetDocumentazione() {
		SetDocumentazione SetDocumentazione1 = new SetDocumentazione();
		SetDocumentazione1.setVisible(true);
	}
	
	public void AppareErroreVeterinarioOrData() {
		ErroreVeterinarioOrData ErroreVeterinarioOrData1 = new ErroreVeterinarioOrData();
		ErroreVeterinarioOrData1.setVisible(true);
	}
	
	
	public void AppareSetCartellaClinica() {
		SetCartellaClinica SetCartellaClinica1 = new SetCartellaClinica();
		SetCartellaClinica1.setVisible(true);
	}
	
	
	public void AppareNewVasca() {
		NewVasca NewVasca1 = new NewVasca();
		NewVasca1.setVisible(true);
	}
	
	public void AppareVascaTartaruga() {
		VascaTartaruga VascaTartaruga1 = new VascaTartaruga();
		VascaTartaruga1.setVisible(true);
	}
	
	public void AppareSeeSediTartarughe() {
		SeeSediTartarughe SeeSediTartarughe1 = new SeeSediTartarughe();
		SeeSediTartarughe1.setVisible(true);
	}
	
	public void AppareAmmissioniCartelle(String foo) {
		AmmissioniCartelle AmmissioniCartelle1 = new AmmissioniCartelle(foo);
		AmmissioniCartelle1.setVisible(true);
	}
	
	public void AppareStatAnnuali() {
		StatAnnuali StatAnnuali1 = new StatAnnuali();
		StatAnnuali1.setVisible(true);
	}
	
	public void AppareStatMensili() {
		StatMensili StatMensili1 = new StatMensili();
		StatMensili1.setVisible(true);
	}
	
	public void AppareStatAmmissioni(String foo) {
		StatAmmissioni StatAmmissioni1 = new StatAmmissioni(foo);
		StatAmmissioni1.setVisible(true);
	}
	
	public void AppareDelete() {
		Delete Delete1 = new Delete();
		Delete1.setVisible(true);
	}
	
	
	/**IL METODO ERRORE SPECIFICO PRENDE COME INPUT UNA STRINGA DA VISUALIZZARE COME ERRORE 
	 * E MOSTRA AUTOMATICAMENTE UNA SCHERMATA CHE LO VISUALIZZA
	 * @param String UN MESSAGGIO DI ERRORE*/
	public void AppareErroreSpecifico(String foo) {
		ErroreSpecifico ErroreSpecifico1 = new ErroreSpecifico(foo);
		ErroreSpecifico1.setVisible(true);
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//INSERIMENTO DI UNA CLASSE NEL DAO CORRISPONDENTE
	
	public void PassaPerIlSedeDAO(Sede foo) {
		SedeDAO SedeDAO1 = SedeDAO.GetIstanza() ; 
		SedeDAO1.PushSede(foo);
	}
	
	public void PassaPerIlDipendenteDAO(Dipendente foo) {
		DipendenteDAO DipendenteDAO1 = DipendenteDAO.GetIstanza() ;
		DipendenteDAO1.PushDipendente(foo);
	}
	
	public void PassaPerIlAmmissioneDAO(AmmissioneTartaruga foo) {
		AmmissioneTartarugaDAO AmmissioneTartarugaDAO1 = AmmissioneTartarugaDAO.GetIstanza();
		AmmissioneTartarugaDAO1.pushAmmissione(foo);
	}
	
	public void PassaPerIlTartarugaDAO(AmmissioneTartaruga foo) {
		TartarugaDAO TartarugaDAO1 = TartarugaDAO.GetIstanza();
		TartarugaDAO1.pushTartaruga(foo);
	}
	
	public void PassaPerIlDocumentazioneDAO(Documentazione foo) {
		DocumentazioneDAO DocumentazioneDAO1 = DocumentazioneDAO.GetIstanza();
		DocumentazioneDAO1.pushDocumentazione(foo);
	}
	
	public void PassaPerIlCartellaClinicaDAO(CartellaClinica foo) {
		CartellaClinicaDAO CartellaClinicaDAO1 = CartellaClinicaDAO.GetIstanza();
		CartellaClinicaDAO1.pushCartellaClinica(foo);
	}
	
	public void PassaPerIlVascaDAO(Vasca foo) {
		VascaDAO VascaDAO1 = VascaDAO.GetIstanza();
		VascaDAO1.pushVasca(foo);
	}
	
	public void PassaPerIlVascaTartarugaDAO(String Vasca, String Tartaruga) {
		VascaDAO VascaDAO1 = VascaDAO.GetIstanza();
		VascaDAO1.assegnaVascaTartaruga(Vasca, Tartaruga);
	}
	
	public void StatAmmissioniAnnueDAO(String foo) {
		AmmissioneDAO AmmissioneDAO1 = AmmissioneDAO.GetIstanza();
		AppareStatAmmissioni(AmmissioneDAO1.StatisticaAmmissioniAnnue(foo));
	}
	
	public void StatAmmissioniMensiliDAO(String foo, String boo) {
		AmmissioneDAO AmmissioneDAO1 = AmmissioneDAO.GetIstanza();
		AppareStatAmmissioni(AmmissioneDAO1.StatisticheAmmissioniMensili(foo, boo));
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//METODO PER PASSARE NEI SETTARTARUGA FALSE\TRUE
	
	public void ControllerPassaTartarugaTrue(AmmissioneTartaruga foo) {
		SetTartarugaTrue.PassaASetTartarugaTrue(foo);
	}
	
	public void ControllerPassaTartarugaFalse(AmmissioneTartaruga foo) {
		SetTartarugaFalse.PassaASetTartarugaFalse(foo);
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//METODI PER LA CANCELLAZIONE DI INSERT INDEBITI E PER LA DELETE
	
	public void AmmissioneIndebita(AmmissioneTartaruga foo) {
		AmmissioneTartarugaDAO AmmissioneTartarugaDAO1 = AmmissioneTartarugaDAO.GetIstanza();
		AmmissioneTartarugaDAO1.CancellaAmmissioneIndebita(foo);
	}
	
	public void DocumentazioneIndebita(String foo) {
		DocumentazioneDAO DocumentazioneDAO1 = DocumentazioneDAO.GetIstanza();
		DocumentazioneDAO1.CancellaDocumentazioneIndebita(foo);
	}
	
	public void CancellaAmmissioneTartaruga(String foo) {
		AmmissioneTartarugaDAO AmmissioneTartarugaDAO1 = AmmissioneTartarugaDAO.GetIstanza();
		AmmissioneTartarugaDAO1.DeleteAmmissioneTartaruga(foo);
	}
	
	public void CancellaDocumentazioneCartellaClinica(String foo) {
		DocumentazioniCartelleClinicheDAO DocumentazioniCartelleClinicheDAO1 = DocumentazioniCartelleClinicheDAO.GetIstanza();
		DocumentazioniCartelleClinicheDAO1.DeleteDocumentazioneCartellaClinica(foo);
	}
	
	public void CancellaDipendente(String foo) {
		DipendenteDAO DipendenteDAO1 = DipendenteDAO.GetIstanza();
		DipendenteDAO1.DeleteDipendente(foo);
	}
	
	public void CancellaSede(String foo) {
		SedeDAO SedeDAO1 = SedeDAO.GetIstanza();
		SedeDAO1.DeleteSede(foo);
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//TROVA IL NOME DELLA TARTARUGA	
	public String TrovaNomeTartaruga(String foo) {
		TartarugaDAO TartarugaDAO1 = TartarugaDAO.GetIstanza();
		return TartarugaDAO1.CercaNomeTartaruga(foo);
	}
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//METODI PER VISUALIZZARE LE TABELLE AGGIORNATE
	public void ViewSedi() {
		SedeDAO SedeDAO1 = SedeDAO.GetIstanza();
		AllSede boh = new AllSede(SedeDAO1.ViewSedi());
		boh.setVisible(true);
	}
	
	public void ViewDipendenti() {
		DipendenteDAO DipendenteDAO1 = DipendenteDAO.GetIstanza();
		AllDipendenti boh = new AllDipendenti(DipendenteDAO1.ViewDipendenti());
		boh.setVisible(true);
	}
	
	public void ViewAmmissioniTartarughe() {
		AmmissioneTartarugaDAO AmmissioneTartarugaDAO1 = AmmissioneTartarugaDAO.GetIstanza();
		AllAmmissioniTartarughe boh = new AllAmmissioniTartarughe(AmmissioneTartarugaDAO1.ViewAmmissioniTartarughe());
		boh.setVisible(true);
	}
	
	public void ViewDocumentazioniCartelleCliniche() {
		DocumentazioniCartelleClinicheDAO DocumentazioniCartelleClinicheDAO1 = DocumentazioniCartelleClinicheDAO.GetIstanza();
		AllDocumentazioniCartellaClinica boh = new AllDocumentazioniCartellaClinica(DocumentazioniCartelleClinicheDAO1.AllDocumentazioniCartelleCliniche());
		boh.setVisible(true);
	}
	
	public void ViewVasche() {
		VascaDAO VascaDAO1 = VascaDAO.GetIstanza();
		AllVasche boh = new AllVasche(VascaDAO1.AllVasche());
		boh.setVisible(true);
	}
	
	public void TartarugheSenzaVasca() {
		TartarugaDAO TartarugaDAO1 = TartarugaDAO.GetIstanza();
		TartarugheSenzaVasca boh = new TartarugheSenzaVasca(TartarugaDAO1.TartarugheSenzaVasca());
		boh.setVisible(true);
	}
	
	public void ViewTartarugheCentro(String foo) {
		TartarugaDAO TartarugaDAO1 = TartarugaDAO.GetIstanza();
		AllTartarughe boh = new AllTartarughe(TartarugaDAO1.TartarugheDiUnCentro(foo));
		boh.setVisible(true);
	}
	
	public void AmmissioniTarghetta(String foo) {
		AmmissioneDAO AmmissioneDAO1 = AmmissioneDAO.GetIstanza();
		AllAmmissione boh = new AllAmmissione(AmmissioneDAO1.AmmissionePerTarghetta(foo));
		boh.setVisible(true);
	}
	
	public void CartelleDiAmmissione(String foo) {
		CartellaClinicaDAO CartellaClinicaDAO1 = CartellaClinicaDAO.GetIstanza();
		AllCartelleCliniche boh = new AllCartelleCliniche(CartellaClinicaDAO1.CartelleDiAmmissione(foo));
		boh.setVisible(true);
	}
	
	public void CartelleDiUnAnno(String foo) {
		CartellaClinicaDAO CartellaClinicaDAO1 = CartellaClinicaDAO.GetIstanza();
		AllCartelleCliniche boh = new AllCartelleCliniche(CartellaClinicaDAO1.StatAnnuali(foo));
		boh.setVisible(true);
	}
	
	public void CartelleDiUnMese(String Mese, String Anno) {
		CartellaClinicaDAO CartellaClinicaDAO1 =  CartellaClinicaDAO.GetIstanza();
		AllCartelleCliniche boh = new AllCartelleCliniche(CartellaClinicaDAO1.StatMensili(Mese, Anno));
		boh.setVisible(true);
	}

}
