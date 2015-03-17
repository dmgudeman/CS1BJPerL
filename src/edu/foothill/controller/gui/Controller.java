package edu.foothill.controller.gui;


import edu.foothill.model.Command;
import edu.foothill.model.MediaLibrary;
import edu.foothill.model.Persistence;
import edu.foothill.model.Type;
import edu.foothill.view.gui.MediaView;


/**
 * Controller Class. Drives the program and communicates between the View (GUI)
 * and the Model Classes (Media and its subclasses). Author: DG
 */

public class Controller implements ViewListener {
	private MediaLibrary mediaLibrary;
	private MediaView mediaView;
	private Persistence persistence;

	/**
	 * parameterized Constructor for this controller class that takes both the
	 * model (mediaLibrary) and the view (mediaView) and an obhect from the
	 * Persistence class
	 * V1 Shaffer
	 * V2 Gudeman
	 */
	public Controller(MediaLibrary mediaLibrary, MediaView mediaView,
			String filename) {
		this.mediaLibrary = mediaLibrary;
		this.mediaView = mediaView;
		this.persistence = new Persistence(filename);
	}

	// reads binary file from the Persistence class Shaffer
	public void loadFile() {
		if (persistence.readFromDisk()) {
			mediaLibrary
					.setMediaLibraryWrapper(persistence.getDiskFileObject());
			mediaLibrary.notifyObservers();
		}

	}
	/**
	 * A method to call the appropriate method when an event occurs in
	 * one of the views
	 * V1 Shaffer
	 * V2 Gudeman
	 */
	@Override
	public void viewEventOccured(ViewEvent event) {
		if (event.getCommand().equals(Command.SAVE)) {
			System.out.println("We saved");
			persistence.writeToDisk(mediaLibrary.getMediaLibraryWrapper());
			persistence.readFromDisk();
			System.out.println("writing from disk");
			System.out.println(persistence.getDiskFileObject().toString());
		} else if (event.getCommand().equals(Command.DELETE)) {
			mediaLibrary.removeMedia(event.getMedia());
		} else if (event.getCommand().equals(Command.DELETE_WITH_SORT)){
			mediaLibrary.removeMediaWithSortByTitle(event.getMedia());	
		} else if (event.getCommand().equals(Command.PRINT)) {
			mediaLibrary.sortByTitle(Type.Song);
			mediaLibrary.sortByTitle(Type.Book);
			mediaLibrary.sortByTitle(Type.Video);
			mediaLibrary.sortByTitle(Type.VideoGame);
			System.out.println(mediaLibrary.toString());
		} else if(event.getCommand().equals(Command.PRINT_SONGS)) {
			mediaLibrary.sortByTitle(Type.Song);
			System.out.println(mediaLibrary.toStringSongs());
		} else if(event.getCommand().equals(Command.PRINT_BOOKS)) {
			mediaLibrary.sortByTitle(Type.Book);
			System.out.println(mediaLibrary.toStringBooks());
		} else if(event.getCommand().equals(Command.PRINT_VIDEOS)) {
			mediaLibrary.sortByTitle(Type.Video);
			System.out.println(mediaLibrary.toStringVideoGames());
		} else if(event.getCommand().equals(Command.PRINT_VIDEO_GAMES)) {
				mediaLibrary.sortByTitle(Type.VideoGame);
				System.out.println(mediaLibrary.toStringBooks());
		} else if (event.getCommand().equals(Command.ADD_WITH_SORT)) {
			mediaLibrary.addMediaWithSortByTitle(event.getMedia());
		} else if (event.getCommand().equals(Command.ADD)) {
			mediaLibrary.addMedia(event.getMedia());
		}
	}
}