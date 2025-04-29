import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main extends JFrame{
	Main(){
		
		//Menu Bars
		JMenuBar menuBar = new JMenuBar();
		
		//Menu
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
		
		//Panels
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.RED);
		redPanel.setBounds(0, 0, 600, 520);
		redPanel.setOpaque(true);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		bluePanel.setBounds(600, 0, 370, 200);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.GREEN);
		greenPanel.setBounds(0, 0, 100, 50);
		
		//LayeredPane
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.add(redPanel, Integer.valueOf(0));
		layeredPane.add(bluePanel, Integer.valueOf(1));
		layeredPane.add(greenPanel, Integer.valueOf(2));
		
		// JFrame
		this.setBackground(Color.BLACK); //Method
		this.setSize(980, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// method to exit program when window closes
        this.setVisible(true);   
        this.setResizable(false);
        this.add(redPanel);
        this.add(bluePanel);
        this.add(greenPanel);
        
        ImageIcon icon = new ImageIcon("MusicPlayer/src/icon.jpg"); // Constructor for an image icon
        this.setIconImage(icon.getImage());        
	}	
	public static void main(String[] args) {
		new Main();
	}
}