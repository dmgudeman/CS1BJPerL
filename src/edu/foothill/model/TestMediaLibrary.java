package edu.foothill.model;

import edu.foothill.controller.gui.Controller;
import edu.foothill.view.console.ConsoleView;
import edu.foothill.view.gui.MediaView;

public class TestMediaLibrary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MediaView view = new MediaView();
		MediaLibrary model = new MediaLibrary();
		
		final String FILE_NAME= "mediaLibrary.ser";

		// adds the view to be an observer
		model.addObserver(view);

		// testing	

		Controller controller = new Controller(model, view, "mediaLibrary.ser");
		
		// registers the controller to be a listener of the button activator on
		// the view.
		view.addController(controller);
		
		controller.loadFile();

	}

	/**
	 * Method adds a book entry to the media library
	 * 
	 * @param mediaLibrary
	 */
	public static void addBookToLibrary(MediaLibrary mediaLibrary) {
		ConsoleView consoleView;
		consoleView = new ConsoleView();
		Book newBook = new Book();
		System.out.println("Adding a new book to the library");
		newBook = consoleView.readBookInfo();
		// System.out.println("Book info: \n" + newBook);
		if (newBook.getTitle().equals("")) {
			// do not save book
		} else {
			mediaLibrary.addMedia((Media) newBook);
		}
	}

	/**
	 * Method adds a song entry to the media library
	 * 
	 * @param mediaLibrary
	 */
	public static void addSongToLibrary(MediaLibrary mediaLibrary) {
		ConsoleView consoleView;
		consoleView = new ConsoleView();
		Song newSong = new Song();
		System.out.println("Adding a new song to the library");
		newSong = consoleView.readSongInfo();
		// System.out.println("song info: \n" + newSong);
		if (newSong.getTitle().equals("")) {
			// do not save song
		} else {
			mediaLibrary.addMedia((Media) newSong);
		}
	}

	/**
	 * Method adds a video entry to the media library
	 * 
	 * @param mediaLibrary
	 */
	public static void addVideoToLibrary(MediaLibrary mediaLibrary) {
		ConsoleView consoleView;
		consoleView = new ConsoleView();
		Video newVideo = new Video();
		System.out.println("Adding a new video to the library");
		newVideo = consoleView.readVideoInfo();
		// System.out.println("video info: \n" + newVideo);
		if (newVideo.getTitle().equals("")) {
			// do not save video
		} else {
			mediaLibrary.addMedia((Media) newVideo);
		}
	}

	/**
	 * Method adds a video-game entry to the media library
	 * 
	 * @param mediaLibrary
	 */
	public static void addVideoGameToLibrary(MediaLibrary mediaLibrary) {
		ConsoleView consoleView;
		consoleView = new ConsoleView();
		VideoGame newVideoGame = new VideoGame();
		System.out.println("Adding a new video to the library");
		newVideoGame = consoleView.readVideoGameInfo();
		// System.out.println("video info: \n" + newVideo);
		if (newVideoGame.getTitle().equals("")) {
			// do not save Video-Game
		} else {
			mediaLibrary.addMedia((Media) newVideoGame);
		}
	}

}