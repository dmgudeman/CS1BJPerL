package edu.foothill.view.gui;

import javax.swing.*;   

import edu.foothill.controller.gui.ViewEvent;
import edu.foothill.controller.gui.ViewListener;
import edu.foothill.model.Command;
import edu.foothill.model.MediaLibrary;
import edu.foothill.model.Song;

import java.awt.event.*;     
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubViewSong extends JFrame implements ActionListener
													
{	
	// create a frame
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 600;
	
		
	// declare variables needed 
	//JFrame frame = new JFrame();

	JPanel panel = new JPanel();
	
	private JButton addButton;
	private JButton backButton;
	private JButton printButton;
	
	private JTextField title;
	private JTextField artist;
	private JTextField genre;
	private JTextField format;
	private JTextField location;
	private JTextArea notes;
	
	private JLabel songPrompt;
	private JLabel titlePrompt;
	private JLabel artistPrompt;
	private JLabel genrePrompt;
	private JLabel formatPrompt;
	private JLabel locationPrompt;
	private JLabel notesPrompt;
	private final SongView songView;
	private final MediaView mediaView;
	
	/**
	 * constructor instantiates widgets and adds them to the Frame
	 */
	public AddSubViewSong(final MediaView mediaView,final SongView songView) 
	{
		// removes the buttons from the standard upper left area to force the
		// user to use the exit button to close, ensuring saving of the data
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		this.songView = songView;
		this.mediaView = mediaView;
		//creates frame
		//frame = new JFrame("Songs");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.CYAN);
		
		// declares the elements in the frame
		songPrompt = new JLabel("New Song Entry");
		songPrompt.setFont(new Font("Papyrus", Font.ITALIC, 30)); 
		titlePrompt = new JLabel("Enter title:");
		artistPrompt = new JLabel("Enter artist:");
		genrePrompt = new JLabel("Enter genre:");
		formatPrompt = new JLabel("Enter format:");
		locationPrompt = new JLabel("Enter location: ");
		notesPrompt = new JLabel("Enter notes:");
		
		title = new JTextField();
		artist = new JTextField();
		genre = new JTextField();
		format = new JTextField();
		location = new JTextField();
		notes = new JTextArea(5, 20);
			
		addButton = new JButton("Add");
		backButton = new JButton("Back");
		printButton = new JButton("Print");

		this.setVisible(true);
		
		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// declare and instantiate an object to hold the GridBagConstraints
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10,10,0,0); //sets the distance between elements
		
		// formats the elements on the gird Bag and adds the initialized elements 
		// to the frame
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(songPrompt, c);
		
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.EAST;
		panel.add(titlePrompt, c);
			
		c.gridx = 1;
		c.gridy = 1;
		panel.add(title, c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(artistPrompt, c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(artist, c);
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(genrePrompt, c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(genre, c);
		
		c.gridx = 0;
		c.gridy = 4;
		panel.add(formatPrompt, c);
		
		c.gridx = 1;
		c.gridy = 4;
		panel.add(format, c);
		
		c.gridx = 0;
		c.gridy = 5;
		panel.add(locationPrompt, c);
		
		c.gridx = 1;
		c.gridy = 5;
		panel.add(location, c);
		
		c.gridx = 0;
		c.gridy = 6;
		panel.add(notesPrompt, c);
		
		c.ipady = 20; 
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(notes, c);
		
		c.gridx = 0;
		c.gridy = 8;
		panel.add(addButton, c);
		
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		panel.add(backButton, c);
		
		c.gridx = 1;
		c.gridy = 9;
		panel.add(printButton, c);
	
		this.add(panel);
	}
	
	/**
	 * Takes in a controller Object as a parameter registers
	 * the controller object as a listener for the convertButton
	 * to be enacted 
	 */
	public void addController(ViewListener controller) {
		final AddSubViewSong self = this;
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Add Song Button has been clicked");
				Song song = new Song(title.getText(), location.getText(),  format.getText(),  notes.getText(), 
						artist.getText(), genre.getText());
				controller.viewEventOccured(new ViewEvent(AddSubViewSong.class, song, Command.ADD));
				
			}
		});
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Print Button has been clicked");
				
				controller.viewEventOccured(new ViewEvent(AddSubViewSong.class, null , Command.PRINT));
				
			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Back Button has been clicked");
				java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					
					
					self.setVisible(false);
					songView.setVisible(true);
					//mediaView.setVisible(false);
					
				}
				});									    	
			} 
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


