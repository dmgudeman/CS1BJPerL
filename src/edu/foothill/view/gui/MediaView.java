package edu.foothill.view.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * This class creates a JFrame to takes search Text for Song type. When a button
 * is activates it navigates to a JFrame that is specific to a media type or a
 * JFrame that addresses the entire list. Version 1 David Gudeman
 */
public class MediaView extends JFrame implements Observer {

	// set constants for the frame
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 500;

	// initialize the elements in the frame
	private JFrame frame;
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

	private List<Media> allMedia = new ArrayList<Media>();

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public MediaView() {

		// removes the buttons from the standard upper left area to force the
		// user to use the exit button to close, ensuring saving of the data
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		// creates frame
		frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);

		// creates panel
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.YELLOW);

		// declares the elements in the frame
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

		// // adds the initialized elements to the frame
		// frame.add(mainSearch);
		// frame.add(prompt);
		// frame.add(mainAllButton);
		// frame.add(mainSongButton);
		// frame.add(mainVideoButton);
		// frame.add(mainVideoGameButton);
		// frame.add(mainBookButton);

		frame.setVisible(true);

		// makes an object to allow the grid layout
		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(10, 10, 10, 10); // sets the distance between
												// elements
		// adds the initialized elements to the frame

		// use GridBagLayout specs to position the components
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

		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Takes in a controller Object as a parameter registers the controller
	 * object as a listener for the convertButton to be enacted
	 */
	public void addController(ViewListener controller) {
		// this declaration allows the view to send itself to the back when
		// going to
		// the next JFrame
		final MediaView self = this;

		// add ActionListeners
		mainAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Button has been clicked");
				if (allMediaView == null) {
					allMediaView = new AllMediaView();
				} else {
					allMediaView.setVisible(true);
				}
				// controller.viewEventOccured(new ViewEvent(MediaView.class,
				// null));
			}
		});
		// instantiates the SongView and sends itself to the back
		mainSongButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Button has been clicked");
				if (songView == null) {
					songView = new SongView(self, controller);
				} else {
					songView.setVisible(true);
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							frame.toBack();
							songView.toFront();
							songView.repaint();
						}
					});
				}
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Exit Button has been clicked");
				controller.viewEventOccured(new ViewEvent(MediaView.class, null, Command.SAVE));
				self.frame.dispatchEvent(new WindowEvent(self.frame, WindowEvent.WINDOW_CLOSING));				
			}
		});
	}

	/**
	 * This is a method necessary to implement the Observer interface. It takes
	 * two parameters o is the observable object and arg an argument passed to
	 * the notifyObservers method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		// if(o instanceof MediaLibrary) {
		// MediaLibraryWrapper media = (MediaLibraryWrapper)arg;
		// //allMedia = media.getMediaLibrary();
		// for (Media m : allMedia){
		// System.out.println(m.getType() +"  "+ m.getTitle());
		// }
		// }
	}
}
