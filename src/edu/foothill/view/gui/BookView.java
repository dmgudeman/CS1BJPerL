package edu.foothill.view.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;

import edu.foothill.controller.gui.ViewEvent;
import edu.foothill.controller.gui.ViewListener;
import edu.foothill.model.Book;
import edu.foothill.model.Command;
import edu.foothill.model.MediaLibraryWrapper;
import edu.foothill.model.Video;


/**
 * This class creates a GUI JFrame to takes search Text and search the Book
 * Class. When a button is activates it navigates to a ADD GUI JFrame. When
 * search text is specified to a book object the DELETE button becomes active.
 * You can print the mediaLibrary list, navigate back to HOME and EXIT from this
 * GUI. Version 1 Dominick Scottolini and David Gudeman
 */
public class BookView extends JFrame {

	// include the views needed to process through the UI tree
	private AddSubViewBook addSubViewBook;
	private MediaView mediaView;

	// set constants for the frame
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;

	// variable used in searching to collect media object whose title is a match
	private Book matchedBook;

	// initialize the elements in the panel DG & DS
	private JPanel panel;
	private JTextField search;
	private JButton addButton;
	private JButton deleteButton;
	private TextArea textArea;
	private JLabel prompt;
	private JButton homeButton;
	private JButton printButton;
	private JButton exitButton;

	// needed to populate the textArea also used for the search Bar
	private MediaLibraryWrapper mediaLibraryWrapper;

	/**
	 * Constructor for this class that takes a MediaView and a ViewListener as
	 * parameters. The mediaView is necessary so that visibility of the GUIs can
	 * be manipulated. Scottolini & Gudeman
	 */
	public BookView(MediaView mediaView, ViewListener controller) {

		gui(controller);
		this.mediaView = mediaView;
	}

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public void gui(ViewListener controller) {
		// removes the buttons from the standard upper left area to force the
		// user to use the exit button to close, ensuring saving of the data Scottolini & Gudeman
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		// specifics for the frame DS & DG
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create a panel
		panel = new JPanel(new GridBagLayout());
		// panel.setBackground(Color.CYAN);
		Color myNewMuaveMedium = new Color(255, 125, 180, 150);
		panel.setBackground(myNewMuaveMedium);

		// declares the elements in the panel
		prompt = new JLabel("Your Books");
		prompt.setFont(new Font("Papyrus", Font.ITALIC, 30));
		search = new JTextField("Search for a book here", 20);
		addButton = new JButton("  ADD BOOK ");
		deleteButton = new JButton("DELETE THE BOOK IN SEARCH BAR");
		deleteButton.setEnabled(false);
		textArea = new TextArea("After a search your books will\nappear here",
				15, 30);
		textArea.setEditable(false);
		homeButton = new JButton("HOME");
		printButton = new JButton("PRINT");
		exitButton = new JButton("EXIT");

		// makes an object of constraints to allow the grid layout DG & DS
		GridBagConstraints c = new GridBagConstraints();

		// sets the distance between elements DG & DS
		c.insets = new Insets(10, 10, 10, 10);

		// adds the initialized elements to the frame DG & DS
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(prompt, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(search, c);

		c.gridx = 0;
		c.gridy = 2;
		panel.add(textArea, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.ipady = 20;
		panel.add(addButton, c);

		c.gridx = 1;
		c.gridy = 3;
		panel.add(printButton, c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		panel.add(deleteButton, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		panel.add(homeButton, c);

		c.gridx = 1;
		c.gridy = 5;
		panel.add(exitButton, c);

		this.add(panel);

		// makes frame visible and exits on close DG & DS
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		/**
		 * Add Action Listeners to Buttons, uses anonymous classes to add each
		 * Listener. Action performed methods are within each class. Action
		 * performed methods perform functions of printing etc., and also adjust
		 * the visibility of the procession of GUIs when navigating between
		 * GUIs. Gudeman & Scottolini
		 */

		// variable to be able to specify the bookView within the anonymous
		// classes DG & DS
		final BookView SELF = this;

		// add ActionListeners to the various buttons
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("add Button has been clicked");
				if (addSubViewBook == null) {
					addSubViewBook = new AddSubViewBook(SELF);
					addSubViewBook.addController(controller);
				} else {
					addSubViewBook.setVisible(true);

				}
				// sets the visibility of the JFrames to show the next view
				// uses invokeLater method because needs it own java thread
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						mediaView.setVisible(false);
						addSubViewBook.setVisible(true);
						SELF.setVisible(false);

					}
				});
			}
		});
		// ActionListener added to HOME button DG & DS
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Home Button has been clicked");
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						mediaView.setVisible(true);
						SELF.setVisible(false);
					}
				});
			}
		});
		// ActionListener added to PRINT button DG & DS
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Print Button has been clicked");
				// this utilizes the mechanism of the AddSubViewBook without
				// duplicating code
				controller.viewEventOccured(new ViewEvent(BookView.class,
						null, Command.PRINT_BOOKS));

			}
		});
		// ActionListener added to EXIT button DG & DS
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Exit Button has been clicked");
				controller.viewEventOccured(new ViewEvent(BookView.class, null,
						Command.SAVE));
				SELF.dispatchEvent(new WindowEvent(SELF,
						WindowEvent.WINDOW_CLOSING));
			}
		});
		// implements keylisteners to the search bar to active delete button
		// upon a
		// title match in the search bar. DG & DS
		search.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// to complete interface
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// to complete interface

			}

			// enables the delete button when there
			// is a match in the search bar to the
			// mediaWrapper arrayList
			@Override
			public void keyReleased(KeyEvent e) {
				if (searchHelper(search.getText())) {
					deleteButton.setEnabled(true);
				} else {
					deleteButton.setEnabled(false);
				}
			}

		});
		/**
		 * Add mouse Listener to the search bar and the delete button Gudeman & Scottolini
		 */
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				search.setText("");
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Delete Button has been clicked");

				// sends info to the controller of what to delete
				controller.viewEventOccured(new ViewEvent(BookView.class,
						matchedBook, Command.DELETE_WITH_SORT));
				deleteButton.setEnabled(false);
				search.setText("");
			}
		});

	}

	// getter for the addSubView Book
	public AddSubViewBook getAddSubViewBook() {
		return addSubViewBook;
	}

	/**
	 * A method to get the Data to repopulate the textArea box. Takes the
	 * parameter mediaLibraryWrapper. Gudeman & Scottolini
	 */
	public void setMediaLibraryWrapper(MediaLibraryWrapper mediaLibraryWrapper) {
		this.mediaLibraryWrapper = mediaLibraryWrapper;
		repopulateTextArea();

	}

	/**
	 * This method iterates through the book class and appends the title to a
	 * viewable output to display in the textArea box Gudeman & Scottolini
	 */
	private void repopulateTextArea() {
		String bookString = "";
		for (Book book : mediaLibraryWrapper.getBooks()) {
			bookString += (book.getTitle() + "\n");
		}
		textArea.setText(bookString);
		textArea.repaint();
	}

	/**
	 * Sets the text in the search bar and then calls the searchHelper method to
	 * determine how to proceed Gudeman & Scottolini
	 * 
	 */
	public void setSearchText(String text) {
		this.search.setText(text);
		searchHelper(text);
	}

	/**
	 * Method to manage the text in the search bar. text as a parameter examined
	 * to determine a match Gudeman & Scottolini
	 */
	private boolean searchHelper(String text) {
		boolean found = false;
		if (text.isEmpty()) {
			repopulateTextArea();
			found = false;
		} else {
			for (Book book : mediaLibraryWrapper.getBooks()) {
				if (text.trim().equalsIgnoreCase(book.getTitle())) {
					textArea.setText(book.getTitle().trim());
					textArea.repaint();
					deleteButton.setEnabled(true);

					// identifies an object whose title is a match
					this.matchedBook = book;
					found = true;
					break;
				} else {
					this.matchedBook = null;
					repopulateTextArea();
					found = false;
				}
			}
		}
		return found;
	}
}
