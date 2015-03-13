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

		Controller controller = new Controller(model, view, "mediaLibrary.ser");

		// adds the view to be an observer
		model.addObserver(view);

		// registers the controller to be a listener of the button activator on
		// the view.
		view.addController(controller);

//		int menuOptionSelection;
//		ConsoleView consoleView;
//		consoleView = new ConsoleView();
//		MediaLibrary mediaLibrary;
//		mediaLibrary = new MediaLibrary();
//		MediaLibrary tempMediaLibrary;
//		tempMediaLibrary = new MediaLibrary();
//		MediaLibrary tempMediaLibrary1;
//		tempMediaLibrary1 = new MediaLibrary();
//
//		boolean successfulDiskRead;
//		final String MEDIA_LIBRARY_FILE_NAME = "MediaLibrary7.ser";
//		Persistence diskHandler = new Persistence(MEDIA_LIBRARY_FILE_NAME);
//		successfulDiskRead = diskHandler.readFromDisk();
//		System.out.println("successfulDiskRead =" + successfulDiskRead);
//		if (successfulDiskRead) {
//			mediaLibrary = diskHandler.getDiskFileObject();
//			System.out.println("Media LIbrary exists on disk");
//
//			// printList();
//
//		} else {
//			// System.out.println("Directory file does not exist on disk");
//
//		}
//
//		System.out.println("After reading from Disk \n" + mediaLibrary);
//		// //////
////		Video newVideo = new Video("Video7", "location1", "format1", "notes1",
////				"star1");
////		mediaLibrary.addMedia((Media) newVideo);
////
////		Book newBook = new Book("Book1", "location1", "format1", "notes1",
////				"author1");
////		mediaLibrary.addMedia((Media) newBook);
//
//		Song newSong = new Song("Song1", "location1", "format1", "notes1",
//				"artist1", " genre1");
//		mediaLibrary.addMedia((Media) newSong);
//		
//		newSong = new Song("Abe", "location1", "format1", "notes1",
//				"artist1", " genre1");
//		mediaLibrary.addMedia((Media) newSong);
//		
//		newSong = new Song("Zib", "location1", "format1", "notes1",
//				"artist1", " genre1");
//		mediaLibrary.addMedia((Media) newSong);
//
////		Video newVideo1 = new Video("Video1", "location1", "format1", "notes1",
////				"star1");
////		mediaLibrary.addMedia((Media) newVideo1);
////
////		VideoGame newVideoGame = new VideoGame("VideoGame1", "location1",
////				"format1", "notes1");
////		mediaLibrary.addMedia((Media) newVideoGame);
////
////		Video newVideo3 = new Video("Video3", "location1", "format1", "notes1",
////				"star1");
////		mediaLibrary.addMedia((Media) newVideo3);
////		Book newBook7 = new Book("Book7", "location1", "format1", "notes1",
////				"author1");
////		mediaLibrary.addMedia((Media) newBook7);
////		Book newBook3 = new Book("Book3", "location1", "format1", "notes1",
////				"author1");
////		mediaLibrary.addMedia((Media) newBook3);
//
//		System.out.println("Printing the whole library");
//		System.out.println(mediaLibrary);
//		mediaLibrary.sortByTitle(Type.Song);
//		// System.out.println("Printing the whole SORTED library");
//		// System.out.println(mediaLibrary);
//		System.out.println("Sorting Songs");
//		System.out.println(mediaLibrary.toStringSongs());
//		diskHandler.writeToDisk(mediaLibrary);
//		// ////////
//		String mediaType;
//		String mediaTitle;
//		Boolean deletionConfirmation = false;
//
//		menuOptionSelection = 1; // just to ensure we get into the while loop
//		while (menuOptionSelection != 0) {
//			menuOptionSelection = consoleView.displayMenu();
//
//			switch (menuOptionSelection) {
//			case 1:
//				addBookToLibrary(mediaLibrary);
//				break;
//			case 2:
//				addSongToLibrary(mediaLibrary);
//				break;
//			case 3:
//				addVideoToLibrary(mediaLibrary);
//				break;
//			case 4:
//				addVideoGameToLibrary(mediaLibrary);
//				break;
//
//			case 5:
//				System.out.println("Printing the whole library");
//				System.out.println(mediaLibrary);
//				break;
//			case 6:
//				System.out.println("Printing media of specific type");
//				mediaType = consoleView.readTypeOfMedia();
//				tempMediaLibrary = mediaLibrary.getLibraryByType(mediaType);
//				System.out.println(tempMediaLibrary);
//				break;
//			case 7:
//				System.out.println("Printing media of specific title");
//				mediaTitle = consoleView.readTitle(true); // Title must be
//															// entered
//				tempMediaLibrary = mediaLibrary.getLibraryByTitle(mediaTitle);
//				System.out.println(tempMediaLibrary);
//				break;
//			case 8:
//				System.out
//						.println("Printing the media of a specific type & title");
//				mediaType = consoleView.readTypeOfMedia();
//				tempMediaLibrary = mediaLibrary.getLibraryByType(mediaType);
//				mediaTitle = consoleView.readTitle(true); // Title must be
//															// entered
//				tempMediaLibrary1 = tempMediaLibrary
//						.getLibraryByTitle(mediaTitle);
//				System.out.println(tempMediaLibrary1);
//				break;
//			case 9:
//				System.out
//						.println("Deleting an entry from the Personal Library.");
//				consoleView.requestDeletionParameters();
//				mediaType = consoleView.readTypeOfMedia();
//				tempMediaLibrary = mediaLibrary.getLibraryByType(mediaType);
//				mediaTitle = consoleView.readTitle(true); // Title must be
//															// entered
//				tempMediaLibrary1 = tempMediaLibrary
//						.getLibraryByTitle(mediaTitle);
//				deletionConfirmation = consoleView
//						.requestDeletionConfirmation();
//				System.out.println(tempMediaLibrary1);
//				if (deletionConfirmation) {
//					mediaLibrary.deleteEntries(mediaType, mediaTitle);
//				}
//				break;
//			default:
//				System.out
//						.println("Thank you for using our media library program");
//			}
//
//		}
//
//		diskHandler.writeToDisk(mediaLibrary);
//		System.out.println("Exiting library program");
//		System.exit(0);
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