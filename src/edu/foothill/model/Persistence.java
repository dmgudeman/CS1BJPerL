package edu.foothill.model;
/**
 * This Class provides interface to the hard disk. The
 * class has methods for saving and retrieving the  whole media library to/from a disk. 
 * 
 * @author Shmuel Shaffer

 
 */
import java.io.*;

public class Persistence {

	private String mediaLibraryFileName;
	private File mediaLibraryFile;
	private MediaLibrary mediaLibraryFromDisk;

	/**
	 * Non-parameterized constructor for the Disk Class. Note that if you do not
	 * specify file name it defaults to Temp.ser
	 * 
	 * @param
	 */

	Persistence() {
		this("Temp.ser");
	}

	/**
	 * parameterized constructor for the Disk Class.
	 * 
	 * @param
	 */

	public Persistence(String diskFileName) {
		mediaLibraryFileName = diskFileName;
		mediaLibraryFile = new File(mediaLibraryFileName);

	}

	/**
	 * The writeToDisk method gets the MediaLibrary Object as an input parameter
	 * and overrides the existing (if any) file with a new library file. The
	 * method returns true if successful, and false if an error occurs.
	 * 
	 * @param - mediaLibraryObject: media library object to be written to disk
	 * @return - Returns true if write operation was successful and false if it
	 *         failed.
	 */
	public boolean writeToDisk(MediaLibrary mediaLibraryObject) {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;
		boolean successfulWriteToDisk=true;
		try {
			fileOutput = new FileOutputStream(mediaLibraryFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			successfulWriteToDisk = false;
		}
		try {
			objectOutput = new ObjectOutputStream(fileOutput);
		} catch (IOException e) {
			e.printStackTrace();
			successfulWriteToDisk = false;

		}
		try {
			objectOutput.writeObject(mediaLibraryObject);

		} catch (IOException e) {
			e.printStackTrace();
			successfulWriteToDisk = false;

		}
		return successfulWriteToDisk;
	}

	/**
	 * The readFromDisk method attempts to read an object from the disk. If the
	 * read operation fails, the method returns false. If the read operation
	 * succeeds the method returns true and populates the MediaLibrary object
	 * with the MediaLibrary object from the disk file.
	 * 
	 * @return - Returns true if read is successful and false if operation
	 *         failed.
	 */
	public boolean readFromDisk() {
		// boolean successfullyreadFromDisk = true;
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInput = null;
		boolean successfulReadFromDisk;
		if (mediaLibraryFile.exists()) {
			successfulReadFromDisk = true;
			try {
				fileInput = new FileInputStream(mediaLibraryFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				successfulReadFromDisk = false;
			}
			try {
				objectInputStream = new ObjectInputStream(fileInput);
			} catch (IOException e) {

				e.printStackTrace();
				successfulReadFromDisk = false;

			}
			try {
				mediaLibraryFromDisk = (MediaLibrary) objectInputStream
						.readObject();
			} catch (IOException e) {

				e.printStackTrace();
				successfulReadFromDisk = false;

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
				successfulReadFromDisk = false;

			}
		} else{
			successfulReadFromDisk = false;
		}
		return successfulReadFromDisk;
	}

	/**
	 * The method getObjectFromDiskFile returns the object which was read from
	 * the disk by the readFromDisk method. If the readFromDisk method was not
	 * successful, the method returns null .
	 * 
	 * @return - Returns ContMediaLibrary object containing the media library object
	 *         which was read from the disk.
	 */
	public MediaLibrary getDiskFileObject() {
		if (!mediaLibraryFile.exists()) {
			mediaLibraryFromDisk = null;

		}
		return mediaLibraryFromDisk;
	}

}
