package edu.foothill.model;

import java.util.ArrayList;
import java.util.List;

public class MediaLibraryWrapper {

	private List<Song> songs = new ArrayList<Song>();
	private List<Book> books = new ArrayList<Book>();
	private List<Video> videos = new ArrayList<Video>();
	private List<VideoGame> videogames = new ArrayList<VideoGame>();

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
