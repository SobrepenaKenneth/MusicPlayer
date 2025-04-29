import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AnimationPanel extends JPanel implements ActionListener {
    private Image[] frames;
    private int currentFrame = 0;
    private Timer timer;

    public AnimationPanel() {
        // Load animation frames
        frames = new Image[3];
        frames[0] = new ImageIcon("MusicPlayer/src/anna_0000.png").getImage();
        frames[1] = new ImageIcon("MusicPlayer/src/anna_0001.png").getImage();
        frames[2] = new ImageIcon("MusicPlayer/src/anna_0002.png").getImage();

        timer = new Timer(150, this); // 150ms per frame
        timer.start();

        this.setOpaque(false); // Optional: transparent background
        this.setBounds(0, 0, 980, 250); // Adjust as needed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frames[currentFrame], 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % frames.length;
        repaint();
    }
}
