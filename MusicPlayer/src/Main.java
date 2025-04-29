import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Main extends JFrame{

	Main(){
		//Border test
		//Border border = BorderFactory.createLineBorder(Color.black, 3);

		//Make an art for redPanel 980x250
		// hope this works animation test
		AnimationPanel animationPanel = new AnimationPanel();

		// Image Button test
		JButton imagePlayButton = new JButton();
		ImageIcon btnPlay = new ImageIcon("MusicPlayer/src/btnPlay.png");
		imagePlayButton.setIcon(btnPlay);
		imagePlayButton.setBorder(null);
		imagePlayButton.setContentAreaFilled(false);
		
		//Menu Bars
		JMenuBar menuBar = new JMenuBar();
		
		//Menu in the top
		JMenu filemenu = new JMenu("File");
		JMenu editmenu = new JMenu("Edit");
		JMenu helpmenu = new JMenu("Help");
		
		menuBar.add(filemenu);
		menuBar.add(editmenu);
		menuBar.add(helpmenu);
		
		//Menu items
		JMenuItem loadItem = new JMenuItem("Import");
		JMenuItem saveItem = new JMenuItem("save");
		JMenuItem exitItem = new JMenuItem("exit");
		
		filemenu.add(loadItem);
		filemenu.add(saveItem);
		filemenu.add(exitItem);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		//Panels colored panel you see in the screen
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.RED);
		redPanel.setBounds(0, 200, 980, 250);
		redPanel.setOpaque(true);
		redPanel.setLayout(null);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		bluePanel.setBounds(0, 0, 980, 100);
		
		JPanel yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.YELLOW);
		yellowPanel.setBounds(0, 0, 100, 50);
		
		//LayeredPane lmao this is not used yet
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.add(redPanel, Integer.valueOf(0));
		layeredPane.add(bluePanel, Integer.valueOf(1));
		layeredPane.add(yellowPanel, Integer.valueOf(2));
		
		// JFrame for the screen
		this.setBackground(Color.BLACK); //Method
		this.setSize(980, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// method to exit program when window closes
        this.setVisible(true);   
        this.setResizable(true);
		redPanel.add(animationPanel);
		bluePanel.add(imagePlayButton);
		this.add(redPanel);
        this.add(bluePanel);
		this.add(yellowPanel);
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));

        ImageIcon icon = new ImageIcon("MusicPlayer/src/icon.jpg"); // Constructor for an image icon
        this.setIconImage(icon.getImage());      
		
		// Action listener to check if the button is pressed
		imagePlayButton.addActionListener(e -> System.err.println("Image Button pressed"));
	}	
	public static void main(String[] args) {
		Main mainFrame = new Main();
		mainFrame.setVisible(true);


	}
}