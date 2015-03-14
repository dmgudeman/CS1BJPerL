package edu.foothill.view.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import edu.foothill.controller.gui.ViewEvent;
import edu.foothill.controller.gui.ViewListener;
import edu.foothill.model.Command;
import edu.foothill.model.Media;
import edu.foothill.model.MediaLibrary;
import edu.foothill.model.MediaLibraryWrapper;

/**
 * This class creates a JFrame to takes search Text for Media type. When a button
 * is activates it navigates to a JFrame that is specific to a media type and carries the
 * text in the search bar forward to the next GUI. 
 * Version 1 Gudeman
 */
public class MediaView extends JFrame implements Observer {

	// set constants for the frame
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 500;

	// initialize the elements in the frame

	private JPanel panel;

	private JLabel prompt;

	private JTextField mainSearch;

	private JButton mainAllButton;
	private JButton mainSongButton;
	private JButton mainBookButton;
	private JButton mainVideoButton;
	private JButton mainVideoGameButton;
	private JButton exitButton;

	private AllMediaView allMediaView;
	private SongView songView;
	private BookView bookView;
	private VideoView videoView;
	private VideoGameView videoGameView;

	private MediaLibraryWrapper mediaLibraryWrapper;

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 * Gudeman
	 */
	public MediaView() {

		// removes the buttons from the standard upper left area to force the
		// user to use the exit button to close, ensuring saving of the data DG
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		// specifics for the JFrame of this class DG
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);

		// creates panel DG
		panel = new JPanel(new GridBagLayout());
		Color myNewMuaveHeavy = new Color(255, 180, 180, 200);
		panel.setBackground(myNewMuaveHeavy);
		
		// declares the elements in the frame DG
		mainSearch = new JTextField(
				"Search for a title and/or choose a media type", 25);
		prompt = new JLabel("Your Media Library");
		prompt.setFont(new Font("Papyrus", Font.ROMAN_BASELINE, 30));
		mainAllButton = new JButton("ALL MEDIA");
		mainSongButton = new JButton("SONG");
		mainVideoButton = new JButton("VIDEO");
		mainVideoGameButton = new JButton("VIDEOGAME");
		mainBookButton = new JButton("BOOK");
		exitButton = new JButton("EXIT");

		/**
		 * Uses Layout tool to position the elements in the panel Gudeman
		 */
		// creates an object to hold the gridBaglayout constraints DG
		GridBagConstraints c = new GridBagConstraints();

		// sets the distance between elements DG
		c.insets = new Insets(10, 10, 10, 10);

		// use GridBagLayout specifications to position the components DG
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;

		panel.add(prompt, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(mainSearch, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.ipady = 20;
		panel.add(mainAllButton, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		panel.add(mainSongButton, c);

		c.gridx = 1;
		c.gridy = 3;
		panel.add(mainBookButton, c);

		c.gridx = 0;
		c.gridy = 4;
		panel.add(mainVideoButton, c);

		c.gridx = 1;
		c.gridy = 4;
		panel.add(mainVideoGameButton, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		panel.add(exitButton, c);
		
		// add layout to the panel
		this.add(panel);
		
		// completes the JFrame specifications
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Takes in a controller Object as a parameter registers the controller
	 * object as a listener for the convertButton to be enacted
	 */
	public void addController(ViewListener controller) {
		// this declaration allows the view to identify itself when
		// calling making Action Listeners DG
		final MediaView self = this;

		// need to instantiate the next tier of views so the
		// controllers can be added
		songView = new SongView(self, controller);
		songView.setVisible(false);
		allMediaView = new AllMediaView(self, controller);
		allMediaView.setVisible(false);
		// -- need the other views


		/**
		 * Add action listeners. Utilizes anonymous classes to create new
		 * ActionListeners for each element. Uses Runnable interface within
		 * an anonymous class when needed to process through the GUIs
		 * Gudeman
		 */
		
		// instantiates the SongView and makes mediaView invisible
		// utilizes an anonymous class to add the action listener
		// and a Runnable object is needed to make a thread
		mainAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Button has been clicked");
				// use the visibility property to adjust the
				// procession of JFrame views
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						self.setVisible(false);
						allMediaView.setVisible(true);
					}
				});
				// controller.viewEventOccured(new ViewEvent(MediaView.class,
				// null));
			}
		});
		// instantiates the SongView and makes mediaView invisible
		// utilizes an anoymous class to add the action listener
		// and a Runnable object is needed to make a thread
		mainSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Add Button has been clicked");
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						self.setVisible(false);
						songView.setVisible(true);
						
						// populates the search bar in songView appropriately
						// if mediaView search bar is empty
						if (!mainSearch.getText().isEmpty()) {
							songView.setSearchText(mainSearch.getText());
						}
					}
				});
			}
		});

		// the exit button
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Exit Button has been clicked");
				controller.viewEventOccured(new ViewEvent(MediaView.class,
						null, Command.SAVE));
				self.dispatchEvent(new WindowEvent(self,
						WindowEvent.WINDOW_CLOSING));
			}
		});
		// empties the search Bar when mouse cursor enters it, so new text may
		// be typed
		mainSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				mainSearch.setText("");
			}
		});

	}

	/**
	 * This is a method necessary to implement the Observer interface. It takes
	 * two parameters o is the observable object and arg an argument passed to
	 * the notifyObservers method. This allows the mediaView to update the other 
	 * views. 
	 * Gudeman
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof MediaLibrary) {
			this.mediaLibraryWrapper = (MediaLibraryWrapper) arg;
			songView.setMediaLibraryWrapper(mediaLibraryWrapper);

		}
	}
	// -- need update methods for bookView, videoView and videoGameView
}
