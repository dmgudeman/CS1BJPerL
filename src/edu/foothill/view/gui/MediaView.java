package edu.foothill.view.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import edu.foothill.controller.gui.ViewEvent;
import edu.foothill.controller.gui.ViewListener;
import edu.foothill.model.Media;
import edu.foothill.model.MediaLibrary;
import edu.foothill.model.MediaLibraryWrapper;

/**
 * This class creates a JFrame to takes search Text for Song type. When a button
 * is activates it navigates to a JFrame that is specific to a media type or a
 * JFrame that addresses the entire list. Version 1 David Gudeman
 */
public class MediaView extends JFrame implements Observer {
	
	// set constants for the frame
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	//private static final int FRAME_X_ORIGIN = 150;
//	private static final int FRAME_Y_ORIGIN = 250;

	// initialize the elements in the frame
	private JPanel panel;
	private JTextField mainSearch;
	private JButton mainAllButton;
	private JButton mainSongButton;
	private JButton mainVideoButton;
	private JButton mainVideoGameButton;
	private JButton mainBookButton;
	private JLabel prompt;
	private AllMediaView allMediaView;
	private SongView songView;
	
	private List <Media> allMedia = new ArrayList<Media>();

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public MediaView() {
		
		// creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.YELLOW);

		// declares the elements in the frame
		prompt = new JLabel("Your Media Library");
		prompt.setFont(new Font("Papyrus", Font.ITALIC, 30)); 
		mainAllButton = new JButton("ALL MEDIA");
		mainSongButton = new JButton("SONG");
		mainVideoButton = new JButton("VIDEO");
		mainVideoGameButton = new JButton("VIDEOGAME");
		mainBookButton = new JButton("BOOK");
		mainSearch = new JTextField("                              ");

		// adds the initialized elements to the frame

		this.add(mainSearch);
		this.add(prompt);
		this.add(mainAllButton);
		this.add(mainSongButton);
		this.add(mainVideoButton);
		this.add(mainVideoGameButton);
		this.add(mainBookButton);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// makes an object to allow the grid layout
				GridBagConstraints c = new GridBagConstraints();
				
				c.insets = new Insets(10,10,10,10); //sets the distance between elements
				// adds the initialized elements to the frame
				
				//use GridBagLayout specs to position the components
				c.weightx = 0.5;	
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				panel.add(prompt, c);
				
				c.gridx = 0;
				c.gridy = 1;
				panel.add(mainSearch, c);
				
				c.weightx = 1.0;
				c.gridx = 0;
				c.gridy = 2;
				c.gridwidth = 2;	
				c.ipady = 20; 
				panel.add(mainAllButton, c);
				
				c.fill = GridBagConstraints.HORIZONTAL;
				 
			
				c.gridx = 0;
				c.gridy = 3;
				c.gridwidth = 1;
				panel.add(mainSongButton, c);
				
				c.gridx = 1;
				c.gridy = 3;			
				panel.add(mainBookButton, c);
						
				c.gridx = 0;
				c.gridy = 4;
				panel.add(mainVideoButton,c);
				
				c.gridx = 1;
				c.gridy = 4;
				panel.add(mainVideoGameButton,c);
				
				this.add(panel);
			
				this.setVisible(true);

		
	}

	/**
	 * Takes in a controller Object as a parameter registers the controller
	 * object as a listener for the convertButton to be enacted
	 */
	 public void addController(ViewListener controller) {
		
		// add ActionListeners
			mainAllButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					System.out.println("Button has been clicked");
					if (allMediaView == null) {
						allMediaView = new AllMediaView();
					} else {
						allMediaView.setVisible(true);
					}
				//	controller.viewEventOccured(new ViewEvent(MediaView.class, null));
				}
			});
			mainSongButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					System.out.println("Button has been clicked");
					if (songView == null) {
						songView = new SongView(controller);
					} else {
						songView.setVisible(true);
					}
				}
			});
	 }
	
	
	
	
	/**
	 * Performs method specific to an event triggered by a specific button
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { // if statement to
	 *           clarify action event if(e.getSource() == mainAllButton) {
	 *           System.out.println("All Button pressed"); } if (e.getSource()
	 *           == mainSongButton) { System.out.println("Song Button pressed");
	 *           } if(e.getSource() == mainVideoButton) {
	 *           System.out.println("Video Button pressed"); } if (e.getSource()
	 *           == mainVideoGameButton) {
	 *           System.out.println("VideoGame Button pressed"); }
	 *           if(e.getSource() == mainBookButton) {
	 *           System.out.println("Book Button pressed"); }
	 * 
	 * 
	 *           }
	 */

	
	/**
	 * This is a method necessary to implement the Observer interface. It takes
	 * two parameters o is the observable object and arg an argument passed to
	 * the notifyObservers method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MediaLibrary) {
			MediaLibraryWrapper media = (MediaLibraryWrapper)arg;
			allMedia = media.getMediaLibrary();
			for (Media m : allMedia){
				System.out.println(m.getType() +"  "+ m.getTitle());
			}
		}
	}
}
