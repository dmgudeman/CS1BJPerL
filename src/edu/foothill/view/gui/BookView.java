package edu.foothill.view.gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * This class creates a JFrame to takes search Text and search the Book Class.
 * When a button is activates it navigates to a JFrame that is specific to a
 * media type or a JFrame that addresses the entire list.
 * Version 1 David Gudeman
 */
public class BookView extends JFrame implements ActionListener {
	// set constants for the frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;

	// initialize the elements in the frame
	private JTextField bookSearch;
	private JButton bookAddButton;
	private JButton bookDeleteButton;
	private JLabel bookPrompt;
	private JTextField bookOutput;

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public BookView() {
		// creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		this.setLayout(new FlowLayout());

		// declares the elements in the frame
		bookSearch = new JTextField("  ");
		bookAddButton = new JButton("ADD book");
		bookDeleteButton = new JButton("DELETE book");
		bookPrompt = new JLabel("Your Books");
		bookOutput = new JTextField("");

		// adds the initialized elements to the frame
		this.add(bookPrompt);
		this.add(bookAddButton);
		this.add(bookDeleteButton);
		this.add(bookOutput);

		this.setVisible(true);
		
		// adds ActionListener to buttons and search bar
		bookSearch.addActionListener(this);
		bookAddButton.addActionListener(this);
		bookDeleteButton.addActionListener(this);

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
