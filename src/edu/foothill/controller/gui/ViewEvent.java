package edu.foothill.controller.gui;

import java.util.EventObject;

import edu.foothill.model.Command;
import edu.foothill.model.Media;
/**
 * This class represents one Event it includes one object of the Media class as well attributes
 * the source of the event (The object on which the Event initially occurred) and the command 
 * that was performed on it (ADD, DELETE, PRINT, EXIT).
 * davidgudeman
 *
 */
public class ViewEvent extends EventObject {

	private Command command;
	private Media media;
	
	/**
	 * Parameterized constructor taking three parameters:
	 * -source (The object on which the Event initially occurred)
	 * -media (An Object of the Media class)
	 * -command (ADD or DELETE or PRINT or EXIT)
	 * and returns the command and a media object
	 * David Gudeman
	 */
	public ViewEvent(Object source, Media media, Command command) {
		super(source);
		this.command = command;
		this.media = media;	
	}

	/**
	 * A getter for the command
	 * David Gudeman
	 */
	public Command getCommand() {
		return command;
	}
	/**
	 * A getter for the media object, used by the controller to collect
	 * the media
	 * 
	 * David Gudeman
	 */
	public Media getMedia() {
		return media;
	}

}
