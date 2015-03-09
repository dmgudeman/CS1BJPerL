
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * This class creates a JFrame to takes search Text and search the Song Class.
 * When a button is activates it navigates to a JFrame that is specific to a
 * media type or a JFrame that addresses the entire list. Version 1 David
 * Gudeman
 */
public class SongView extends JFrame implements Observer {
	
	// initialize the elements in the frame and panel
	//private static JFrame frame;
	//private static JPanel panel;
	private static JLabel prompt;
	private static JTextField search;
	private static JButton addButton;
	private static JButton deleteButton;
	private static TextArea textArea;


	
	private AddSubViewSong addSubViewSong;
	
	/**
	 * Non parameterized constructor for this class. It calls the method gui which creates a JFrame 
	 * a JPanel and places buttons in the frame. 
	 */
	public SongView() {
		gui();
	}

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public void gui() {
		
		
		// declares the elements in the panel
		prompt = new JLabel("Search for a song, add a song or delete a song");
		Dimension size1 = prompt.getPreferredSize();
		prompt.setBounds(50, 20,size1.width, size1.height);
		add(prompt);
		
		search = new JTextField("Search for a song here");
		Dimension size2 = search.getPreferredSize();
		search.setBounds(100, 40, size2.width, size2.height);
		add(search);
		
		
	/*	addButton = new JButton("ADD SONG");
		deleteButton = new JButton("DELETE SONG");
		*/
		
		textArea = new TextArea();
		textArea.setEditable(false);
		Dimension size5 = textArea.getPreferredSize();
		textArea.setBounds(50, 200, size5.width, size5.height);
		add(textArea);
		
		setLayout(null);
		setSize (400,500);
		setTitle("Songs");
		setBackground(Color.YELLOW);
		
		

		// adds ActionListener to buttons and search bar
		//songSearch.addActionListener(this);
		//songAddButton.addActionListener(this);
		//songDeleteButton.addActionListener(this);

		

		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	
	
	
	// add ActionListeners
		addButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					System.out.println("Button has been clicked");
					if (addSubViewSong == null){
						addSubViewSong = new AddSubViewSong();
					} else {
						addSubViewSong.setVisible(true);
					}
				}
			});
		/*	mainSongButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Button has been clicked");
				if (songView == null){
					songView = new SongView();
				} else {
					songView.setVisible(true);
				}
			} 
		});*/
	
	}

	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	}
