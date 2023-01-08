package PackageController;
import ClassiDAO.SedeDAO;
import ClassiGUI.AddNew;
import ClassiGUI.ErroreGenerico;
import ClassiGUI.ErroreSede;
import ClassiGUI.MainGUI;
import ClassiGUI.SetSede;
import ClassiTabelle.Sede;

public class Controller {
	static MainGUI Principale = new MainGUI();
	static AddNew AddNew1 = new AddNew();
	static SetSede SetSede1 = new SetSede();
	static ErroreGenerico ErroreGenerico1 = new ErroreGenerico();
	static ErroreSede ErroreSede1 = new ErroreSede();
	
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
	
	
	//INSERIMENTO DI UNA CLASSE NEL DAO CORRISPONDENTE
	
	public static void PassaPerIlDAO(Sede foo) {
		SedeDAO.PushSede(foo);
	}
	
	
	
}
