package edu.foothill.model;

import edu.foothill.controller.gui.Controller;
import edu.foothill.view.gui.MediaView;

/**
 * Object of this class runs the Media Library 
 * V1 Shaffer
 * V2 Gudeman
 * 
 */
public class MediaProgramLibrary {

	
	public static void main(String[] args) {
		MediaView mediaView = new MediaView();
		MediaLibrary mediaLibrary = new MediaLibrary();

		// adds the view to be an observer
		mediaLibrary.addObserver(mediaView);

		Controller controller = new Controller(mediaLibrary, mediaView, "mediaLibrary.ser");
		
		// registers the controller to be a listener of the button activator on
		// the view.
		mediaView.addController(controller);
		
		controller.loadFile();

	}

}