package edu.foothill.controller.gui;

import edu.foothill.model.MediaLibrary;
import edu.foothill.view.gui.MediaView;

/**
 * Object of this class runs the Media Library 
 * @author Shmuel
 *
 */
public class MediaLibraryProgram {


	public static void main(String[] args) {
		MediaView view = new MediaView();
		MediaLibrary mediaLibrary = new MediaLibrary();
		final String FILE_NAME= "mediaLibrary.ser";

		// adds the view to be an observer
		mediaLibrary.addObserver(view);

		Controller controller = new Controller(mediaLibrary, view, FILE_NAME);

		// registers the controller to be a listener of the button activator on
		// the view.
		view.addController(controller);

		controller.loadFile();

	}
}
