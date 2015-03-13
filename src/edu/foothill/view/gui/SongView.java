package edu.foothill.view.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import edu.foothill.controller.gui.ViewEvent;
import edu.foothill.controller.gui.ViewListener;
import edu.foothill.model.Command;

/**
 * This class creates a JFrame to takes search Text and search the Song Class.
 * When a button is activates it navigates to a JFrame that is specific to a
 * media type or a JFrame that addresses the entire list. Version 1 David
 * Gudeman
 */
public class SongView extends JFrame implements Observer {

	// set constants for the frame
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	// private static final int FRAME_X_ORIGIN = 50;
	// private static final int FRAME_Y_ORIGIN = 50;

	// initialize the elements in the frame and panel
	private JFrame frame;
	private JPanel panel;
	private JTextField search;
	private JButton addButton;
	private JButton deleteButton;
	private TextArea textArea;
	private JLabel prompt;
	private JButton homeButton;
	private JButton printButton;
	private JButton exitButton;

	// private static JTextField output;
	private AddSubViewSong addSubViewSong;
	private MediaView mediaView;

	/**
	 * Non parameterized constructor for this class. It calls the method gui
	 * which creates a JFrame a JPanel and places buttons in the frame.
	 */
	public SongView(MediaView mediaView, ViewListener controller) {
		gui(controller);
		this.mediaView = mediaView;
	}

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public void gui(ViewListener controller) {
		// creates frame
		frame = new JFrame("Songs");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.CYAN);
		// frame.getContentPane().setBackground(new Color(255, 255, 102));
		// panel.setBackground(new Color(255, 255, 102));

		// declares the elements in the panel
		prompt = new JLabel("Your Songs");
		prompt.setFont(new Font("Papyrus", Font.ITALIC, 30));
		search = new JTextField("Search for a song here", 20);
		addButton = new JButton("  ADD SONG ");
		deleteButton = new JButton("DELETE SONG");
		textArea = new TextArea("After a search your songs will\nappear here", 15, 30);
		textArea.setEditable(false);
		homeButton = new JButton("HOME");
		printButton = new JButton("PRINT");
		exitButton = new JButton("EXIT");

		// makes an object to allow the grid layout
		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(10, 10, 10, 10); // sets the distance between
												// elements
		// adds the initialized elements to the frame
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
		panel.add(deleteButton, c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		panel.add(homeButton, c);

		c.gridx = 1;
		c.gridy = 4;

		panel.add(printButton, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		panel.add(exitButton, c);

		frame.add(panel);

		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// add ActionListeners
		final SongView self = this;
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("add Button has been clicked");
				if (addSubViewSong == null) {
					addSubViewSong = new AddSubViewSong(mediaView, self);
					addSubViewSong.addController(controller);
				} else {
					addSubViewSong.setVisible(true);
				}
			}
		});
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Home Button has been clicked");
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						frame.toBack();
						mediaView.toFront();
						mediaView.repaint();
					}
				});
			}
		});
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Print Button has been clicked");
			}

		});
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Print Button has been clicked");
				controller.viewEventOccured(new ViewEvent(AddSubViewSong.class,
						null, Command.PRINT));

			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Exit Button has been clicked");
				controller.viewEventOccured(new ViewEvent(SongView.class, null,
						Command.SAVE));
				self.frame.dispatchEvent(new WindowEvent(self.frame,
						WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	public AddSubViewSong getAddSubViewSong() {
		return addSubViewSong;
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
