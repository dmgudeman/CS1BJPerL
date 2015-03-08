/**
 * This Class provides interface to the hard disk for the OO Java project. The
 * class has methods for saving and retrieving the media library list to/from a disk.
 * The class saves the whole media library (override the existing file). The class can read
 * the library from the disk and return the library object to the invoking class.  
 * 
 * @author Shmuel Shaffer

 * 
 */
import java.io.*;

public class Disk {
	static final String MEDIA_LIBRARY_FILE_NAME = "MediaLibrary.ser";
	private boolean fileExists = false;

	/**
	 * Constructor for the Disk Class - initialize instance variables.
	 * 
	 * @param
	 */

	Disk() {

	}

	/**
	 * Method finds if the MediaLibrary file exists. If it exists, the
	 * constructor sets fileExists to true. Otherwise, fileExists remains false.
	 */
	public void doesFileExistOnDisk() {
		fileExists = true;
	}

	/**
	 * The writeToDisk method gets the MediaLibrary Object as an input parameter
	 * and overrides the existing library file with a new library file. The
	 * method returns true if successful, and false if an error occurs.
	 * 
	 * @param - mediaLibrary: MediaLibrary object containing the list of media
	 *        object
	 * @return - Returns true if write operation was successful and false if it
	 *         failed.
	 */
	public boolean writeToDisk(MediaLibrary mediaLibraryObject) {
		boolean fileExists = true;
		System.out.println("Saving Media Library to hard disk");

		return fileExists;
	}

	/**
	 * The readFromDisk method attempts to read an object from the disk. If the
	 * read operation fails, the method returns false. If the read operation
	 * succeeds the method returns true and populates the MediaLibrary object
	 * with the library object from the disk file.
	 * 
	 * @return - Returns true if read is successful and false if operation
	 *         failed.
	 */
	public boolean readFromDisk() {
		// boolean successfullyreadFromDisk = true;

		return fileExists;
	}

	/**
	 * The method getObjectFromDiskFile returns the object which was read from
	 * the disk by the readFromDisk method. If the readFromDisk method was not
	 * successful, the method returns null (rather than the address of a valid
	 * ContactList object).
	 * 
	 * @return - Returns MediaLibrary object containing the directory object
	 *         which was read from the disk.
	 */
	public MediaLibrary getDiskFileObject() {
		if (!fileExists) {
			MediaLibrary mediaLibraryFromDisk = null; // ***NEED TO REMOVE
			mediaLibraryFromDisk = null;

		}
		System.out.println("Retrieved Media Library from hard disk");
		MediaLibrary mediaLibraryFromDisk = new MediaLibrary();
		return mediaLibraryFromDisk;
	}

}