
import java.io.Serializable;
/**
 */
import java.util.ArrayList;

/**
 * One object of MediaLibrary Class represents the library of the various media.
 * one list of the Media Objects. 
 * Version 1: Author DG 
 * Version 2: Shmuel removed references to Collection interface. 
 * 				Added the following methods:addMedia, getLibraryByType, getLibraryByTitle,
 */

public class MediaLibrary implements Serializable {

	public ArrayList<Media> mediaLibrary;

	/**
	 * Default Constructor for List Class Author DG
	 */
	public MediaLibrary() {
		mediaLibrary = new ArrayList<Media>();
	}

	/**
	 * Method adds media to the library - Author Shmuel
	 */
	public void addMedia(Media media) {
		mediaLibrary.add(media);
		System.out.println("Added media to library");

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

		return libraryString;

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
}
