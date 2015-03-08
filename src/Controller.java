import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Controller Class. Drives the program and communicates between the View (GUI) and 
 * the Model Classes (Media and its subclasses).
 * Author: DG 
 */

public class Controller implements ActionListener {
	private MediaLibrary mediaLibrary;
	private OpenDashboardView openDashboardView;
	private AllMediaView allMediaView;
	private BookView bookView;
	private AddSubViewBook addSubViewBook;
	private DeleteSubView deleteSubView;
	

	/**
	 * parameterized Constructor for this controller class that takes both the
	 * model (ConvertModel) and the view (ConvertView). Allows the
	 * actionPerformed method of the ActionListener to be called from this class
	 */
	public Controller(MediaLibrary mediaLibrary, OpenDashboardView openDashboardView) {
		this.mediaLibrary= mediaLibrary;
		this.openDashboardView = openDashboardView;
	}

	public Controller(MediaLibrary mediaLibrary2, OldMediaView mainView) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is called when there is an action initiated from the
	 * ActionListener. This methods takes the Fahrenheit input from the view and
	 * directs the model convert it to Celsius converted to Celsius
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//e.getSource();
		System.out.println(e.getSource());
	}

}