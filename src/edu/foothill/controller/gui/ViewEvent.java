package edu.foothill.controller.gui;

import java.util.EventObject;
import edu.foothill.model.Media;
/**
 * This class represents one Event it includes one object of the Media class as well attributes
 * the source of the event (The object on which the Event initially occurred) and the command 
 * that was performed on it (ADD, DELETE).
 * davidgudeman
 *
 */
public class ViewEvent extends EventObject {

	private String command;
	private Media media;
	
	/**
	 * 
	 * @param source (The object on which the Event initially occurred)
	 * @param media (An Object of the Media class)
	 * @param command (ADD or DELETE)
	 */
	
	public ViewEvent(Object source, Media media, String command) {
		super(source);

		this.command = command;
		this.media = media;
	}

	/**
	 * A getter for the command
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * A getter for the media object
	 * @return
	 */
	public Media getMedia() {
		return media;
	}

}
