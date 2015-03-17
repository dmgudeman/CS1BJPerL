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
 * This class holds the business logic and implements The Observer 
 * Observable Pattern Gudeman
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
    public void setMediaLibraryWrapper(MediaLibraryWrapper mediaLibraryWrapper){
    	this.mediaLibraryWrapper = mediaLibraryWrapper;
    }
    public MediaLibraryWrapper getMediaLibraryWrapper() {
    	return mediaLibraryWrapper;
    }
    
	/**
	 * Method adds media to the library - Author Shmuel
	 */
	public void addMedia(Media media) {
		addToMediaWrapper(media);
		notifyObservers(mediaLibraryWrapper);
	}
	
	
	public void addMediaWithSortByTitle(Media media){
		addToMediaWrapper(media);
		sortByTitle(media.getType());
		notifyObservers(mediaLibraryWrapper);
		
	}
	
	/**
	 * Method to add the various media types to the mediaLibraryWrapper.
	 * 
	 * V1 SHaffer
	 * V2 Gudeman
	 */
	private void addToMediaWrapper(Media media) {
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

		
	}
	
	
	public void removeMedia(Media media) {
		removeFromMediaWrapper(media);

		notifyObservers(mediaLibraryWrapper);
	}
	
	
	private void removeFromMediaWrapper(Media media) {
		switch (media.getType()) {
		case Book:
			mediaLibraryWrapper.getBooks().remove((Book) media);
			break;
		case Song:
			mediaLibraryWrapper.getSongs().remove((Song) media);
			break;
		case Video:
			mediaLibraryWrapper.getVideos().remove((Video) media);
			break;
		case VideoGame:
			mediaLibraryWrapper.getVideogames().remove((VideoGame) media);
			break;
		default:
			break;
		}

		System.out.println("Removed " + media.getType() + " from library");
		System.out.println(mediaLibraryWrapper.toString());
	}

	public void removeMediaWithSortByTitle(Media media){
		removeFromMediaWrapper(media);
		sortByTitle(media.getType());
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
			observer.update(this, this.mediaLibraryWrapper);
		}
		clearChanged();
	}

	public void notifyObservers() {
		this.notifyObservers(mediaLibraryWrapper);
	}
	public void sortByTitle(Type type) {
		if (type.equals(Type.Book)) {
			Collections.sort(mediaLibraryWrapper.getBooks(),
					new Comparator<Book>() {
						@Override
						public int compare(Book book1, Book book2) {
							return book1.getTitle().toLowerCase().compareTo(book2.getTitle().toLowerCase());
						}

					});
		} else if (type.equals(Type.Song)) {
			Collections.sort(mediaLibraryWrapper.getSongs(),
					new Comparator<Song>() {
						@Override
						public int compare(Song song1, Song song2) {
							return song1.getTitle().toLowerCase().compareTo(song2.getTitle().toLowerCase());
						}

					});
			
		} else if (type.equals(Type.Video)) {
			Collections.sort(mediaLibraryWrapper.getVideos(),
					new Comparator<Video>() {
						@Override
						public int compare(Video video1, Video video2) {
							return video1.getTitle().toLowerCase().compareTo(video2.getTitle().toLowerCase());
						}

					});
			
		} else if (type.equals(Type.VideoGame)) {
			Collections.sort(mediaLibraryWrapper.getVideogames(),
					new Comparator<VideoGame>() {
						@Override
						public int compare(VideoGame videoGame1, VideoGame videoGame2) {
							return videoGame1.getTitle().toLowerCase().compareTo(videoGame2.getTitle().toLowerCase());
						}

					});
			
		}
		// need to add the sortByTitle for video, videoGame
	}
}