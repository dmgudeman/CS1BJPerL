package edu.foothill.controller.console;

import java.util.ArrayList;

import edu.foothill.model.Media;
import edu.foothill.model.MediaLibrary;
import edu.foothill.model.Persistence;
import edu.foothill.model.Song;
import edu.foothill.model.Book;
import edu.foothill.model.Video;
import edu.foothill.model.VideoGame;
import edu.foothill.view.console.ConsoleView;

/**
 * This class controls the operation of the media library list program.
 * 
 * Version 1: Author Shmuel 
 * Version 2: Implemented all of the methods required for Task Delivery 3, made modifications per reviewer's comments
 * 
 * 
 */
public class MyController {
	private static ConsoleView consoleView = new ConsoleView();
	private static MediaLibrary tempMediaLibrary = new MediaLibrary();
	private static MediaLibrary tempMediaLibrary1 = new MediaLibrary();
	private static final String MEDIA_LIBRARY_FILE_NAME = "MediaLibrary4.ser";
	private static Persistence diskHandler = new Persistence(MEDIA_LIBRARY_FILE_NAME);

	public static void main(String[] args) {

		int menuOptionSelection;
		ConsoleView consoleView;
		consoleView = new ConsoleView();
		MediaLibrary mediaLibrary;
		mediaLibrary = new MediaLibrary();


		boolean successfulDiskRead = diskHandler.readFromDisk();
		if (successfulDiskRead) {
			mediaLibrary = diskHandler.getDiskFileObject();
		}
		System.out.print("After reading from Disk \n" + mediaLibrary);

		menuOptionSelection = 1; // just to ensure we get into the while loop
		while (menuOptionSelection != 0) {
			menuOptionSelection = consoleView.displayMenu();
			switch (menuOptionSelection) {
			case 1:
				addBookToLibrary(mediaLibrary);
				break;
			case 2:
				addSongToLibrary(mediaLibrary);
				break;
			case 3:
				addVideoToLibrary(mediaLibrary);
				break;
			case 4:
				addVideoGameToLibrary(mediaLibrary);
				break;

			case 5:
				printMediaLibrary(mediaLibrary);
				break;
			case 6:
				printAllMediaOfSpecificType(mediaLibrary);

				break;
			case 7:
				printAllMediaByTitle(mediaLibrary);
				break;
			case 8:
				printMediaByTypeAndTitle(mediaLibrary);
				break;
			case 9:
				deleteMediaByTypeAndTitle(mediaLibrary);

				break;
			default:
				System.out
						.println("Thank you for using our media library program");
			}

		}

		diskHandler.writeToDisk(mediaLibrary);
		System.out.println("Exiting library program");
		System.exit(0);
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

	/**
	 * Method sorts the Media Library and prints the sorted version
	 * 
	 * @param mediaLibrary
	 */
	public static void printMediaLibrary(MediaLibrary mediaLibrary) {
		// System.out.println("Printing the whole library");
		mediaLibrary.sortByField();
		System.out.println(mediaLibrary);
	}

	/**
	 * Method prints media of specific type
	 */
	public static void printAllMediaOfSpecificType(MediaLibrary mediaLibrary) {
		String mediaType;
		System.out.println("Printing media of specific type");
		mediaType = consoleView.readTypeOfMedia();
		tempMediaLibrary = mediaLibrary.getLibraryByType(mediaType);
		System.out.println(tempMediaLibrary);
	}

	/**
	 * Method prints all media of specific title
	 */
	public static void printAllMediaByTitle(MediaLibrary mediaLibrary) {
		String mediaTitle;
		System.out.println("Printing media of specific title");
		mediaTitle = consoleView.readTypeOfMedia();
		tempMediaLibrary = mediaLibrary.getLibraryByTitle(mediaTitle);
		System.out.println(tempMediaLibrary);
	}

	/**
	 * Method prints all media of specific type & title
	 */
	public static void printMediaByTypeAndTitle(MediaLibrary mediaLibrary) {
		String mediaType;
		String mediaTitle;
		System.out.println("Printing the media of a specific type & title");
		mediaType = consoleView.readTypeOfMedia();
		tempMediaLibrary = mediaLibrary.getLibraryByType(mediaType);
		mediaTitle = consoleView.readTitle(true); // Title must be
													// entered
		tempMediaLibrary1 = tempMediaLibrary.getLibraryByTitle(mediaTitle);
		System.out.println(tempMediaLibrary1);

	}

	/**
	 * Method deletes media element(s)
	 */
	public static void deleteMediaByTypeAndTitle(MediaLibrary mediaLibrary) {
		String mediaType;
		String mediaTitle;
		boolean deletionConfirmation;
		System.out.println("Deleting an entry from the Personal Library.");
		consoleView.requestDeletionParameters();
		mediaType = consoleView.readTypeOfMedia();
		tempMediaLibrary = mediaLibrary.getLibraryByType(mediaType);
		mediaTitle = consoleView.readTitle(true); // Title must be
													// entered
		tempMediaLibrary1 = tempMediaLibrary.getLibraryByTitle(mediaTitle);
		deletionConfirmation = consoleView.requestDeletionConfirmation();
		System.out.println(tempMediaLibrary1);
		if (deletionConfirmation) {
			mediaLibrary.deleteEntries(mediaType, mediaTitle);
		}

	}
	/**
	 * Method saves media library to disk and exits the program
	 */
	public static void saveAndGoodby(MediaLibrary mediaLibrary){
		diskHandler.writeToDisk(mediaLibrary);
		System.out.println("Exiting library program");
		System.exit(0);
	}
	
}
/**
 * 
 ** Please see below the output of our run **
 ******************************************** 
 **/
