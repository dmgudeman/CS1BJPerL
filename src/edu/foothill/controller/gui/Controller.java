package edu.foothill.controller.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import edu.foothill.model.Command;
import edu.foothill.model.MediaLibrary;
import edu.foothill.model.MediaLibraryWrapper;
import edu.foothill.model.Persistence;
import edu.foothill.model.Type;
import edu.foothill.view.gui.AddSubViewBook;
import edu.foothill.view.gui.AddSubViewSong;
import edu.foothill.view.gui.MediaView;
import edu.foothill.view.gui.SongView;

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
	 * model (ConvertModel) and the view (ConvertView). Allows the
	 * actionPerformed method of the ActionListener to be called from this class
	 */
	public Controller(MediaLibrary mediaLibrary, MediaView mediaView,
			String filename) {
		this.mediaLibrary = mediaLibrary;
		this.mediaView = mediaView;
		this.persistence = new Persistence(filename);
	}

	public void loadFile() {
		if (persistence.readFromDisk()) {
			mediaLibrary
					.setMediaLibraryWrapper(persistence.getDiskFileObject());
			mediaLibrary.notifyObservers();
		}

	}

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
		} else if (event.getSource() == AddSubViewSong.class) {
			System.out.println(event.getCommand());
			if (event.getCommand().equals(Command.ADD)) {
				mediaLibrary.addMedia(event.getMedia());

			} else if (event.getCommand().equals(Command.PRINT)) {
				mediaLibrary.sortByTitle(Type.Song);
				System.out.println(mediaLibrary.toStringSongs());
			}
		} else if (event.getSource() == SongView.class) {

		}

	}
}