package edu.foothill.model;
import java.io.Serializable;
import java.util.List;


/** 
*Each Object of this class is identified by title. And contains information location, 
*format and notes. This is the SuperClass that provides basic information common to 
*all Media Types.
*Author DG
*/

// variables holding basic information that all media types have in common DG
public abstract class Media implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title; 
	private String location;
	private String format;
	private String notes;
	private String searchText;
	
	
	/**
	 * Constructor that takes all four identifiers for this class: title, location,
	 * format and notes notes. Needs at least a null string in each of the parameters.
	 * Should not take a null string for title.
	 * Author DG 
	 */
	public Media(String title, String location, String format, String notes) {
		this.title = title;
		this.location = location;
		this.format = format;
		this.notes = notes;
	}
	
	public Media() {
		
	}
	
	public abstract Type getType();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	 /**
     * Returns a String containing all the data stored in this object. 
     * Author DG
     */
    @Override
    public String toString()
    {
        String result = "Title: " + this.getTitle() + "\nLocation: " + this.getLocation()
                + "\nFormat: " + this.getFormat() + "\nNotes: " + this.getNotes()
                + "\n";
        return result;
    }
	
}
