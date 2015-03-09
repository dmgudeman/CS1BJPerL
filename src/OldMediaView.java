import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


/**
 * This class creates a JFrame to takes search Text for Song type. When a button
 * is activates it navigates to a JFrame that is specific to a media type or a
 * JFrame that addresses the entire list.
 * Version 1 David Gudeman
 */
public class OldMediaView extends JFrame implements Observer {
	// set constants for the frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;

	// initialize the elements in the frame
	private JTextField mainSearch;
	private JButton mainAllButton;
	private JButton mainSongButton;
	private JButton mainVideoButton;
	private JButton mainVideoGameButton;
	private JButton mainBookButton;
	private JLabel prompt;
	private AllMediaView allMediaView;
	private SongView songView;

	/**
	 * Non parameterized constructor for this class, creates a JFrame and places
	 * buttons in the frame
	 */
	public OldMediaView() {
		// creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		this.setLayout(new FlowLayout());

		// declares the elements in the frame
		prompt = new JLabel("Welcome to JPerl personalized media library");
		mainAllButton = new JButton("ALL MEDIA");
		mainSongButton = new JButton("SONG");
		mainVideoButton = new JButton("VIDEO");
		mainVideoGameButton = new JButton("VIDEOGAME");
		mainBookButton = new JButton("BOOK");
		mainSearch = new JTextField("                              ");

		// adds the initialized elements to the frame
		
		this.add(mainSearch);
		this.add(prompt);
		this.add(mainAllButton);
		this.add(mainSongButton);
		this.add(mainVideoButton);
		this.add(mainVideoGameButton);
		this.add(mainBookButton);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// add ActionListeners
		mainAllButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Button has been clicked");
				if (allMediaView == null){
					allMediaView = new AllMediaView();
				} else {
					songView.setVisible(true);
				}
			}
		});
		mainSongButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae) {
			System.out.println("Button has been clicked");
			if (songView == null){
				songView = new SongView();
			} else {
				songView.setVisible(true);
			}
		}
	});
		//mainVideoButton.addActionListener(this);
		//mainVideoGameButton.addActionListener(this);
		//mainBookButton.addActionListener(this);

		// makes frame visible and exits on close
	}

	/**
	 * Performs method specific to an event triggered by a specific button
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// if statement to clarify action event
		if(e.getSource() == mainAllButton) {
			System.out.println("All Button pressed");
		} 
		if (e.getSource() == mainSongButton) {
			System.out.println("Song Button pressed");
		}
		if(e.getSource() == mainVideoButton) {
			System.out.println("Video Button pressed");
		} 
		if (e.getSource() == mainVideoGameButton) {
			System.out.println("VideoGame Button pressed");
		}
		if(e.getSource() == mainBookButton) {
			System.out.println("Book Button pressed");
		} 
		

	}
	*/

	/**
	 * Takes in a controller Object as a parameter registers
	 * the controller object as a listener for the convertButton
	 * to be enacted 
	 */
	//public void addController(ActionListener controller) {
	//	mainAllButton.addActionListener(controller);
	//}
	/**
	 * This is a method necessary to implement the Observer interface.
	 * It takes two parameters o is the observable object and 
	 * arg an argument passed to the notifyObservers method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		//double celsius = (double) arg;
		//DecimalFormat df = new DecimalFormat("#.00");
		//celsOutput.setText(df.format(celsius));
	}
}
