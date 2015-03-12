package edu.foothill.model;

import java.util.ArrayList;
import java.util.Collection;

import edu.foothill.controller.gui.Controller;
import edu.foothill.view.gui.MediaView;

public class ViewTestMain {
	/**
	 * Drives the program. It instantiates members of the Model, View and Controller 
	 * classes. It registers the view to be an observer and the controller
	 * to be a listener
	 */

	
	public static void main(String[] args) {
		MediaView view = new MediaView();
		MediaLibrary model = new MediaLibrary();

		Controller controller = new Controller(model, view);
		
		//adds the view to be an observer
		model.addObserver(view);
		
		// registers the controller to be a listener of the button activator on 
		// the view.
		view.addController(controller);
	}
}