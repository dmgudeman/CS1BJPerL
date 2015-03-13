package edu.foothill.model;
/**
 * One object of Video Type class and holds information about one Media object. 
 * This subclass extends Media Class. 
 * Adds parameters star and Video type information. 
 * Author DG.
 */
public class Video extends Media{
	private String star;
		
	/**
	 * Constructor utilizing the Media Superclass constructor with parameters: title
	 * location, format and notes.  It adds parameters star and Video type.
	 * Author DG
	 */
	public Video(String title, String location, String format, String notes, String star) {
		super(title, location, format, notes);
		this.star = star;
	}

	public Video(){
		
	}
	// getters and setters. DG
	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public Type getType() {
		return Type.Video;
	}

	/**
	* Returns a String containing all the data stored in this object. It utilizes
	* the superClass toString method. DG
    */
    @Override
    public String toString()
    {
        String result = super.toString() +"Author: " + this.getStar() +  "\n";
        return result;
    }	
}
