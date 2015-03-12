package edu.foothill.view.gui;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * This class creates a JFrame to takes search Text and search the VideoGame
 * Class. When a button is activates it navigates to a JFrame that is specific
 * to a media type or a JFrame that addresses the entire list.
 * Version 1 David Gudeman
 */
public class AllMediaView extends JFrame implements ActionListener {
	// set constants for the frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;

	// initialize the elements in the frame
	private JTextField allMediaSearch;
	private JButton allMediaAddButton;
	private JButton allMediaDeleteButton;
	private JLabel allMediaPrompt;
	private JTextField allMediaOutput;

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public AllMediaView() {
		// creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);

		this.setLayout(new FlowLayout());

		// declares the elements in the frame
		allMediaSearch = new JTextField("  ");
		allMediaAddButton = new JButton("ADD an item");
		allMediaDeleteButton = new JButton("DELETE an item");
		allMediaPrompt = new JLabel("Your Library");
		allMediaOutput = new JTextField("");

		// adds the initialized elements to the frame
		this.add(allMediaPrompt);
		this.add(allMediaAddButton);
		this.add(allMediaDeleteButton);
		this.add(allMediaOutput);

		// adds ActionListener to buttons and search bar
		allMediaSearch.addActionListener(this);
		allMediaAddButton.addActionListener(this);
		allMediaDeleteButton.addActionListener(this);
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
