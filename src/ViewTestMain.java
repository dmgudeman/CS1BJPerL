
import java.util.ArrayList;
import java.util.Collection;

public class ViewTestMain {
	/**
	 * Drives the program. It instantiates members of the Model, View and Controller 
	 * classes. It registers the view to be an observer and the controller
	 * to be a listener
	 */

	
	public static void main(String[] args) {
		MediaView mainModel = new MediaView();
		

		//ConvertView mainView = new ConvertView();
		//ConvertController mainControl = new ConvertController(mainModel, mainView);
		
		//adds the view to be an observer
		//mainModel.addObserver(mainView);
		
		// registers the controller to be a listener of the button activator on 
		// the view.
		//mainView.addController(mainControl);
	}
}