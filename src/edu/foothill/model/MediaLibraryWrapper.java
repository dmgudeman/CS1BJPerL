package edu.foothill.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/**
 * Main class to hold the data for the MediaLibrary.  Wrapper class for data is needed because
 * in observer/Observable pattern, you cannot pass a list (only an Object) so this class
 * creates a wrapper to wrap lists in an object.
 * This creates ArrayLists for each of the four media types. 4 lists allows
 * more efficient searching of the various media groups. Faciliates
 * populating the search bar in the various views.
 * David Gudeman
 */
public class MediaLibraryWrapper extends Observable implements Serializable {
	private static final long serialVersionUID = 1L;
    
	//creates four array lists based on media type. makes manipulation
	// in the media types as a group more efficient for sorting and presenting
	// and populating the textAreas in the the various 4 media type GUIs. DG
	private List<Song> songs = new ArrayList<Song>();
	private List<Book> books = new ArrayList<Book>();
	private List<Video> videos = new ArrayList<Video>();
	private List<VideoGame> videogames = new ArrayList<VideoGame>();

	// getter for the various Lists DG
	public List<Song> getSongs() {
		return songs;
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public List<VideoGame> getVideogames() {
		return videogames;
	}
    // toString function for entire library DG
	public String toString() {
		String libraryString = "Library as a printable string";
		if (!(songs.isEmpty() && books.isEmpty() && videos.isEmpty() && videogames
				.isEmpty())) {
			libraryString = "There are no items in the library";
		} else {
			libraryString = "Your library contains:" + "\n";
		}
		for (int i = 0; i < songs.size(); i++) {
			libraryString += songs.get(i) + "\n";
		}
		for (int i = 0; i < books.size(); i++) {
			libraryString += books.get(i) + "\n";
		}
		for (int i = 0; i < videos.size(); i++) {
			libraryString += videos.get(i) + "\n";
		}
		for (int i = 0; i < videogames.size(); i++) {
			libraryString += videogames.get(i) + "\n";
		}
		return (libraryString);
	}
    // toString for Songs DG
	public String toStringSongs() {
		String libraryString = "Songs as a printable string";
		if (songs.isEmpty()) {
			libraryString = "There are no items in the library";
		} else {
			libraryString = "Your Song library contains:" + "\n";

			for (int i = 0; i < songs.size(); i++) {
				libraryString += songs.get(i) + "\n";
			}
		}
		return (libraryString);
	} 
}
