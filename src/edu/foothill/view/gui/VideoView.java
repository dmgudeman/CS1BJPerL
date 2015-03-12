package edu.foothill.view.gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * This class creates a JFrame to takes search Text and search the video Class.
 * When a button is activates it navigates to a JFrame that is specific to a
 * media type or a JFrame that addresses the entire list.
 * Version 1 David Gudeman
 */
public class VideoView extends JFrame implements ActionListener {
	// set constants for the frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;

	// initialize the elements in the frame
	private JTextField videoSearch;
	private JButton videoAddButton;
	private JButton videoDeleteButton;
	private JLabel videoPrompt;
	private JTextField videoOutput;

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public VideoView() {
		// creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		this.setLayout(new FlowLayout());

		// declares the elements in the frame
		videoSearch = new JTextField("  ");
		videoAddButton = new JButton("ADD video");
		videoDeleteButton = new JButton("DELETE video");
		videoPrompt = new JLabel("Your videos");
		videoOutput = new JTextField("");

		// adds the initialized elements to the frame
		this.add(videoPrompt);
		this.add(videoAddButton);
		this.add(videoDeleteButton);
		this.add(videoOutput);
		
		// adds ActionListener to buttons and search bar
		videoSearch.addActionListener(this);
		videoAddButton.addActionListener(this);
		videoDeleteButton.addActionListener(this);

		this.setVisible(true);

		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Performs method specific to an event triggered by a specific button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// if statement to clarify action event

	}

}
