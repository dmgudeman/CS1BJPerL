package edu.foothill.view.gui;
/**
 * Contains a GUI View for an interface that allows you to add a new video game entry based on title, format, location, notes
 * Author Dominick Scottolini
 * 
 */
 
import javax.swing.*;   
import java.awt.event.*;     
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubViewVideoGame extends JFrame implements ActionListener
													
{	
	// create a frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;
	
	// declare variables needed 
	private JLabel videogameprompt;
	private JButton addButton;
	private JTextField title;
	private JTextField format;
	private JTextField location;
	private JTextField notes;
	private JLabel titlePrompt;
	private JLabel formatPrompt;
	private JLabel locationPrompt;
	private JLabel notesPrompt;
	/**
	 * constructor instantiates widgets and adds them to the Frame
	 */
	public AddSubViewVideoGame() 
	{
		//creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		this.setLayout(new FlowLayout());
		
		// declares the elements in the frame
		videogameprompt = new JLabel("Add New Video Game Entry");
		titlePrompt = new JLabel("Enter title of Video: ");
		formatPrompt = new JLabel("Enter format of Video: ");
		locationPrompt = new JLabel("Enter location of Video: ");
		notesPrompt = new JLabel("Enter notes for Video: ");
		title = new JTextField("");
		format = new JTextField("");
		location = new JTextField("");
		notes = new JTextField("");
		addButton = new JButton("Add");
		// adds the initialized elements to the frame
		this.add(videogameprompt);
		this.add(addButton);
		this.add(title);
		this.add(format);
		this.add(location);
		this.add(notes);
		this.add(titlePrompt);
		this.add(formatPrompt);
		this.add(locationPrompt);
		this.add(notesPrompt);
		
		this.setVisible(true);
		
		// add action listeners
		addButton.addActionListener(this);
		
		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
		
	/**
	 * performs action based on incoming event triggered by specific button
	 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
				// triggers add method
				
		}	
		
		

		
		
		



		
		
		
		
		
		
	
	


}


