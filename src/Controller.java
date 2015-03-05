import java.util.LinkedList;
import java.util.List;



/**
 * Controller Class. Drives the program and communicates between the View (GUI) and 
 * the Model Classes (Media and its subclasses).
 * Author: DG 
 */

public class Controller {
	
	private List<Media> list = new LinkedList<Media>();
	
	public void doStuff() {
		Media thing01 = new Media ("This", "DVD", "Library", "Hello Notes", "video");
		//	System.out.println(thing01.toString());
			
			Media thing02 = new Song ("This02", "Song2", "Library02", "notes02", "artist02", "genre02", "");
		//	System.out.println(thing02.toString());
			Media thing03 = new Books ("This03", "Book03", "Library03", "notes03", "author03", "");
			//System.out.println(thing03.toString());
			 list.add(thing03);
			 list.add(thing02);
			 list.add(thing01);
			 System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
	  
		Controller controller = new Controller();
		
		controller.doStuff();
		 
		
	}

}