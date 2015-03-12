package edu.foothill.view.console;

import java.util.Scanner;

import edu.foothill.model.Media;
import edu.foothill.model.Song;
import edu.foothill.model.Video;
import edu.foothill.model.VideoGame;
import edu.foothill.model.Book;

/**
 * Methods of this class interact with the user. This is implementation of the
 * Viewer in the MVC paradigm. We will attempt to replace this viewer by a
 * JFrame viewer.
 * 
 * @author Version 1: author Shmuel
 * 
 */
public class ConsoleView {
	private static int MAX_TRYS=3;
	/**
	 * Method prompts the viewer to select media library function
	 * 
	 * @return
	 */
	public static int displayMenu() {
		int selection;
		Scanner console = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter 1 to add a new book to the library");
		System.out.println("Enter 2 to add a new song to the library");
		System.out.println("Enter 3 to add a new video to the library");
		System.out.println("Enter 4 to add a new video game to the library");
		System.out.println("Enter 5 to print the content of the library");
		System.out.println("Enter 6 to print all media of a certain type");
		System.out.println("Enter 7 to print all media with a certain title");
		System.out
				.println("Enter 8 to print all media  of a specific type & title");
		System.out.println("Enter 9 to delete media");
		System.out.println("Enter other number to exit the application");
		String input = console.nextLine();
		try {
			selection = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Closing the program: You must enter a number");
			selection = 0;

		}
		return selection;
	}

	/**
	 * Method populates book object with info entered by the user
	 * 
	 * @param
	 * @return Book object populated with user entered info
	 */

	public static Book readBookInfo() {
		Book book = new Book();
	        book.setTitle(readTitle(true)); // Book title must be entered
		if (book.getTitle().equals("")) {
			System.out.println("Book without title will not be saved in library");
		}else{
			book.setAuthor(readAuthor());
			book.setFormat(readFormat());
			book.setLocation(readLocation());
			book.setNotes(readNotes());
			System.out.println("Done populating the book info");

		}
		return book;

	}

	/**
	 * Method populates song object with info entered by the user.
	 * 
	 * @return Song object populated with user entered info
	 * 
	 */

	public static Song readSongInfo() {
		Song song = new Song();
		song.setTitle(readTitle(true)); // song title must be entered
		if (song.getTitle().equals("")) {
			System.out.println("Song without title will not be saved in library");
		}else{
		song.setArtist(readArtist());
		song.setFormat(readFormat());
		song.setLocation(readLocation());
		song.setNotes(readNotes());
		song.setGenre(readGenre());
		System.out.println("Done populating the song info");
		}
		return song;

	}

	/**
	 * Method populates video object with info entered by the user.
	 * 
	 */

	public static Video readVideoInfo() {
		Video video = new Video();
		video.setTitle(readTitle(true)); // Video title/name must be entered
		if (video.getTitle().equals("")) {
			System.out
					.println("Video without title will not be saved in library");
		} else {
			video.setStar(readStar());
			video.setFormat(readFormat());
			video.setLocation(readLocation());

			video.setNotes(readNotes());
			System.out.println("Done populating the song info");
		}
		return video;
	}

	/**
	 * Method populates video game object with info entered by the user.
	 * 
	 */

	public static VideoGame readVideoGameInfo() {
		VideoGame videoGame = new VideoGame();
		videoGame.setTitle(readTitle(true)); // Video game title must be entered
		if (videoGame.getTitle().equals("")) {
			System.out
					.println("Video-game without title will not be saved in library");
		} else {
			videoGame.setFormat(readFormat());
			videoGame.setLocation(readLocation());
			videoGame.setNotes(readNotes());
		System.out.println("Done populating the video game info");
		}
		return videoGame;
	}

	/**
	 * method reads star name from console and returns the corresponding string
	 * 
	 * @return
	 */
	public static String readStar() {
		System.out.println("Please enter Star's name:");
		Scanner console = new Scanner(System.in);
		String star = console.nextLine();
		return star;
	}

	/**
	 * method reads song genre from console and returns the corresponding string
	 * 
	 * @return
	 */
	public static String readGenre() {
		System.out.println("Please enter genre:");
		Scanner console = new Scanner(System.in);
		String genre = console.nextLine();
		return genre;
	}

	/**
	 * method reads Artist name from console and returns the corresponding
	 * string
	 * 
	 * @return
	 */
	public static String readArtist() {
		
		System.out.println("Please enter artist's name:");
		Scanner console = new Scanner(System.in);
		String artist = console.nextLine();
		return artist;
	}

	/**
	 * Method returns user's input regarding type of media
	 */
	public static String readTypeOfMedia() {
		System.out.println("Please enter media type:");
		Scanner console = new Scanner(System.in);
		String mediaType = console.nextLine();
		return mediaType;
	}

	/**
	 * Method returns user's input regarding title of media
	 */
	public static String readTitle(boolean mustEnter) {
		int numberOfTries = 0;
		String mediaTitle = "";
		boolean requestInput = true;
		while (requestInput) {
			requestInput=false;
			System.out.println("Please enter media title:");
			Scanner console = new Scanner(System.in);
			mediaTitle = console.nextLine();
			if(mediaTitle.equals("") && numberOfTries< MAX_TRYS && mustEnter){
				++numberOfTries;
				requestInput=true;
				
			}
		}
		return mediaTitle;
	}

	/**
	 * Method requests confirmation for deleting media elements from library
	 */
	public static boolean requestDeletionConfirmation() {
		Boolean requestApproved = false;
		System.out
				.println("Please enter \"Y\" to confirm deletion of these media element(s):");
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		if(input.equals("Y") || input.equals("y")){
			requestApproved = true;
		}
		return requestApproved;
	}

	/**
	 * Method informs user that deletion parameters will be requested
	 */
	public static void requestDeletionParameters() {
		System.out.println("Please enter deletion parameters");
	}


	/**
	 * method reads location from console and returns the corresponding string
	 * 
	 * @return
	 */
	public static String readLocation() {
		
		System.out.println("Please enter location:");
		Scanner console = new Scanner(System.in);
		String location = console.nextLine();
		return location;
	}

	/**
	 * method reads format from console and returns the corresponding string
	 * 
	 * @return
	 */
	public static String readFormat() {
		System.out.println("Please enter format:");
		Scanner console = new Scanner(System.in);
		String format = console.nextLine();
		return format;
	}

	/**
	 * method reads notes from console and returns the corresponding string
	 * 
	 * @return
	 */
	public static String readNotes() {
		
		System.out.println("Please enter notes:");
		Scanner console = new Scanner(System.in);
		String notes = console.nextLine();
		return notes;
	}

	/**
	 * method reads author name from console and returns the corresponding
	 * string
	 * 
	 * @return
	 */
	public static String readAuthor() {
		System.out.println("Please enter author's name:");
		Scanner console = new Scanner(System.in);
		String author = console.nextLine();
		return author;
	}
}
