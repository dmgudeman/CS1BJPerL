package edu.foothill.model;

import java.io.Serializable;
/**
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * One object of MediaLibrary Class represents the library of the various media.
 * one list of the Media Objects. Version 1: Author DG Version 2: Shmuel removed
 * references to Collection interface. Added the following methods:addMedia,
 * getLibraryByType, getLibraryByTitle,  Mainly used for business logic.
 */

public class MediaLibrary extends Observable implements Serializable {
	private static final long serialVersionUID = 1L;

	private MediaLibraryWrapper mediaLibraryWrapper = new MediaLibraryWrapper();
	private List<Observer> observers = new ArrayList<Observer>();

	/**
	 * Default Constructor for List Class Author DG
	 */
	public MediaLibrary() {

	}

	/**
	 * Method adds media to the library - Author Shmuel
	 */
	public void addMedia(Media media) {
		switch (media.getType()) {
		case Book:
			mediaLibraryWrapper.getBooks().add((Book) media);
			break;
		case Song:
			mediaLibraryWrapper.getSongs().add((Song) media);
			break;
		case Video:
			mediaLibraryWrapper.getVideos().add((Video) media);
			break;
		case VideoGame:
			mediaLibraryWrapper.getVideogames().add((VideoGame) media);
			break;
		default:
			break;
		}

		System.out.println("Added " + media.getType() + " to library");
		System.out.println(mediaLibraryWrapper.toString());

		notifyObservers(mediaLibraryWrapper);
	}

	/**
	 * Method returns a library object with all of the media elements of a
	 * certain type -Author Shmuel
	 */
	public MediaLibrary getLibraryByType(String mediaType) {
		MediaLibrary tempLibrary = new MediaLibrary();
		System.out
				.println(" Method populates temp library with elements of a specific type");
		return tempLibrary;
	}

	/**
	 * Method returns library object with all of the media elements of a certain
	 * title. Author - Shmuel
	 */
	public MediaLibrary getLibraryByTitle(String mediaTitle) {
		MediaLibrary tempLibrary = new MediaLibrary();
		System.out
				.println(" Method populates temp library with elements of a specific title");
		return tempLibrary;
	}

	/**
	 * Method returns a printable string containing all of the elements in the
	 * library - Author Shmuel
	 * 
	 */
	@Override
	public String toString() {
		return mediaLibraryWrapper.toString();
	}
	
	public String toStringSongs() {
		return mediaLibraryWrapper.toStringSongs();
	}

	/**
	 * Method deletes entries with the specified media type and media title from
	 * the media library - Author Shmuel
	 * 
	 * @param mediaType
	 * @param mediaTitle
	 */

	public void deleteEntries(String mediaType, String mediaTitle) {
		// TODO Auto-generated method stub
		System.out.println("Deleted specific entries from the media library");
	}

	/**
	 * The is a method of the class Observable that allows the model to be
	 * observed.
	 */
	public void addObserver(Observer observe) {
		observers.add(observe);
	}

	/**
	 * This method notifies the observer view object to call update and show the
	 * result in the output textField
	 */
	public void notifyObservers(Object mediaLibraryWrapper) {
		for (Observer observer : observers) {
			observer.update(this, mediaLibraryWrapper);
		}
		clearChanged();
	}

	public void sortByTitle(Type type) {
		if (type.equals(Type.Book)) {
			Collections.sort(mediaLibraryWrapper.getBooks(),
					new Comparator<Book>() {
						@Override
						public int compare(Book book1, Book book2) {
							return book1.getTitle().compareTo(book2.getTitle());
						}

					});
		} else if (type.equals(Type.Song)) {
			Collections.sort(mediaLibraryWrapper.getSongs(),
					new Comparator<Song>() {
						@Override
						public int compare(Song song1, Song song2) {
							return song1.getTitle().compareTo(song2.getTitle());
						}

					});
		}
		// need to add the sortByTitle for video, videoGame
	}
}