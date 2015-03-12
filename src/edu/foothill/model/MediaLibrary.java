package edu.foothill.model;



import java.io.Serializable;
/**
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * One object of MediaLibrary Class represents the library of the various media.
 * one list of the Media Objects. 
 * Version 1: Author DG 
 * Version 2: Shmuel removed references to Collection interface. 
 * 				Added the following methods:addMedia, getLibraryByType, getLibraryByTitle,
 */

public class MediaLibrary extends Observable implements Serializable {
	
	private ArrayList<Media> mediaLibrary;
	private MediaLibraryWrapper mediaLibraryWrapper;
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Default Constructor for List Class Author DG
	 */
	public MediaLibrary() {
		mediaLibraryWrapper = new MediaLibraryWrapper();
		mediaLibraryWrapper.setMediaLibrary(new ArrayList<Media>());
		
	}

	/**
	 * Method adds media to the library - Author Shmuel
	 */
	public void addMedia(Media media) {
		mediaLibraryWrapper.getMediaLibrary().add(media);
		System.out.println("Added media to library");
		System.out.println(mediaLibraryWrapper.toString());
		
		notifyObservers(mediaLibraryWrapper);
	}

	/**
	 * Method returns a library object with all of the media elements of
	 * a certain type -Author Shmuel
	 */
	public MediaLibrary getLibraryByType(String mediaType) {
		MediaLibrary tempLibrary= new MediaLibrary();
		System.out
				.println(" Method populates temp library with elements of a specific type");
		return tempLibrary;
	}

	/**
	 * Method returns library object with all of the media elements of
	 * a certain title. Author - Shmuel
	 */
	public MediaLibrary getLibraryByTitle(String mediaTitle) {
		MediaLibrary tempLibrary= new MediaLibrary();
		System.out
				.println(" Method populates temp library with elements of a specific title");
		return tempLibrary;
	}


	/**
	 * Method returns a printable string containing all of the elements in the
	 * library - Author  Shmuel
	 * 
	 */
	public String toString() {
		String libraryString = "Library as a printable string";
		if(mediaLibrary.size()==0){
			libraryString = "There are no items in the library";
		}
		else{
			libraryString = "Your library contains:"+"\n";
		}
			for (int i = 0; i < mediaLibrary.size(); i++) {
				libraryString+=mediaLibrary.get(i)+"\n";
		}
		return (libraryString);
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
	 * The is a method of the class Observable that allows
	 * the model to be observed.  
	 */
	public void addObserver(Observer observe) {
		observers.add(observe);
	}
	/**
	 * This method notifies the observer view object to call 
	 * update and show the result in the output textField
	 */
	public void notifyObservers(Object mediaLibraryWrapper) {
		for (Observer observer : observers){
			observer.update(this, mediaLibraryWrapper);	
		}
		clearChanged();
	}
	/**
	 * Method sorts the media library by type of entry and within type of entry, sorted by title.
	 * Author - Shmuel
	 * @param sortField
	 */
	public void sortByField() {
		String sortFieldI;
		String sortFieldIIPlusOne;
		Media tempMedia = new Media();
		
			for (int sortIndex = 0; sortIndex < 2; sortIndex++) {
				for (int i = 0; i < mediaLibrary.size() - 1; i++) {
					for (int j = 0; j < mediaLibrary.size() - 1 - i; j++) {

						if (sortIndex == 0) { // first sort on first name
							sortFieldI = mediaLibrary.get(j).getTitle();
							sortFieldIIPlusOne = mediaLibrary.get(j + 1)
									.getTitle();
						} else { // Sort on second name after the sort on first
									// name
									// is complete
							sortFieldI = mediaLibrary.get(j).getType();
							sortFieldIIPlusOne = mediaLibrary.get(j + 1)
									.getType();
						}
						sortFieldI = sortFieldI.toLowerCase();
						sortFieldIIPlusOne = sortFieldIIPlusOne.toLowerCase();
						if (sortFieldI.compareTo(sortFieldIIPlusOne) > 0) {
							// need to swap Person Objects
							tempMedia = mediaLibrary.get(j);
							mediaLibrary.remove(j);
							mediaLibrary.add(j + 1, tempMedia);

						}

					}
				}

			}
}
}