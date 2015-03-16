package edu.foothill.view.gui;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.foothill.controller.gui.ViewListener;
import edu.foothill.model.MediaLibraryWrapper;
import edu.foothill.model.Song;


/**
 * This class creates a JFrame to takes search Text and search the VideoGame
 * Class. When a button is activates it navigates to a JFrame that is specific
 * to a media type or a JFrame that addresses the entire list.
 * Version 1 David Gudeman
 */
public class AllMediaView extends JFrame implements ActionListener {
	
	private MediaLibraryWrapper mediaLibraryWrapper;
	// set constants for the frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	
	// initialize the elements in the frame
	private JTextField search;
	private JButton addButton;
	private JButton deleteButton;
	private JLabel prompt;
	private JTextArea textArea;
	
	private boolean matchedMedia;

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 * @param controller 
	 * @param self 
	 */
	public AllMediaView(MediaView self, ViewListener controller) {
		// creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);

		this.setLayout(new FlowLayout());

		// declares the elements in the frame
		search = new JTextField("  ");
		addButton = new JButton("ADD an item");
		deleteButton = new JButton("DELETE an item");
		prompt = new JLabel("Your Library");
		textArea = new JTextArea("");

		// adds the initialized elements to the frame
		this.add(prompt);
		this.add(addButton);
		this.add(deleteButton);
		this.add(textArea);

		// adds ActionListener to buttons and search bar
		search.addActionListener(this);
		addButton.addActionListener(this);
		deleteButton.addActionListener(this);
		this.setVisible(true);

		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void setSearchText(String text) {
		this.search.setText(text);
	//	searchHelper(text);
	}

	/**
	 * Method to manage the text in the search bar. text as a parameter examined
	 * to determine a match Gudeman
	 */
/*	private boolean searchHelper(String text) {
		boolean found = false;
		if (text.isEmpty()) {
			repopulateTextArea();
			found = false;
		} else {
			for (Song song : mediaLibraryWrapper.getSongs()) {
				if (text.trim().equalsIgnoreCase(song.getTitle())) {
					textArea.setText(song.getTitle().trim());
					textArea.repaint();

					// identifies an object whose title is a match
					this.matchedSong = song;
					found = true;
					break;
				} else {
					this.matchedSong = null;
					repopulateTextArea();
					found = false;
				}
			}
		}
		return found;
	}
    
	*/
	/**
	 * This method iterates through the song class and appends the title to a
	 * viewable output to display in the textArea box Gudeman
	 */
	private void repopulateTextArea() {
		textArea.setText("");

		for (Song song : mediaLibraryWrapper.getSongs()) {
			textArea.append(song.getTitle() + "\n");
		}
	}

	public void setMediaLibraryWrapper(MediaLibraryWrapper mediaLibraryWrapper) {
		this.mediaLibraryWrapper = mediaLibraryWrapper;
	}
	
	/**
	 * Performs method specific to an event triggered by a specific button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// if statement to clarify action event

	}

}
