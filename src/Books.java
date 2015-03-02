/**
 * One object of Book type class and holds information about one Media object. 
 * This subclass extends Media Class. 
 * Adds parameters author and Book type to the Media class information
 * Author DG  
 */
public class Books extends Media {
   
	private String author;
	private String type = "Book";
	
	/**
	 * Constructor utilizing the Media Superclass constructor with parameters: title
	 * location, format and notes.  It adds parameters author and Book type.
	 * Author DG
	 */
	public Books(String title, String location, String format, String notes, String author, String type) {
		super(title, location, format, notes, type);
		this.author = author;
	}

	//Getters and setters DG
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	* Returns a String containing all the data stored in this object. DG
    */
    @Override
    public String toString()
    {
        String result = super.toString() +"Author: " + this.getAuthor() +  "\n";
        return result;
    }	
    
    
	

}
