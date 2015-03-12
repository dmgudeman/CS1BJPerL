package edu.foothill.model;

import java.util.ArrayList;

public class MediaLibraryWrapper {
	private ArrayList<Media> mediaLibrary;
	
	public ArrayList<Media> getMediaLibrary() {
		return mediaLibrary;
	}

	public void setMediaLibrary(ArrayList<Media> mediaLibrary) {
		this.mediaLibrary = mediaLibrary;
	}

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
}



