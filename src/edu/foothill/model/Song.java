package edu.foothill.model;
/**
 * One object of Song Type class and holds information about one Media object. 
 * This subclass extends Media Class. 
 * Adds parameters artist, genre and Song type to the Media class information
 * Author DG  
 */
public class Song extends Media{

	private String artist;
	private String genre;
	private static final String type = "Song";
	
	/**
	 * Constructor utilizing the Media Superclass constructor with parameters: title
	 * location, format and notes.  It adds parameters artist, genre and type.
	 * Author DG
	 */
	public Song(String title, String location, String format, String notes, 
			String artist, String genre) {
		super(title, location, format, notes, type);
		this.artist = artist;
		this.genre = genre;
		
	}
	public Song(){
		
	}
	//getters and setters for subclass, DG
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getType() {
		return type;
	}


	/**
	* Returns a String containing all the data stored in this object. It utilizes
	* the superClass toString method. DG
    */
    @Override
    public String toString()
    {
        String result = super.toString() +"Artist: " + this.getArtist() + "\nGenre: " + this.getGenre() + "\n";
        return result;
    }
}
