import java.awt.event.*;
import javax.swing.*;

public class ImageButton extends JButton {
    private boolean isClicked = false;
    private final MusicPlayer player = new MusicPlayer(); // music player instance

    private final ImageIcon defaultIcon = new ImageIcon("src/assets/default.png");
    private final ImageIcon transition1 = new ImageIcon("src/assets/transition1.png");
    private final ImageIcon transition2 = new ImageIcon("src/assets/transition2.png");
    private final ImageIcon clickedIcon = new ImageIcon("src/assets/clicked.png");

    public ImageButton() {
        setIcon(defaultIcon);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBounds(0, 0, defaultIcon.getIconWidth(), defaultIcon.getIconHeight());

        addActionListener(e -> {
            Timer transitionTimer = new Timer(100, null);
            final int[] frame = {0};

            transitionTimer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    frame[0]++;
                    if (!isClicked) {
                        // Play forward transition
                        switch (frame[0]) {
                            case 1 -> setIcon(transition1);
                            case 2 -> setIcon(transition2);
                            case 3 -> {
                                setIcon(clickedIcon);
                                isClicked = true;
                                player.play("src/assets/music.wav"); // <-- play music
                                ((Timer) evt.getSource()).stop();
                            }
                        }
                    } else {
                        // Play reverse transition
                        switch (frame[0]) {
                            case 1 -> setIcon(transition2);
                            case 2 -> setIcon(transition1);
                            case 3 -> {
                                setIcon(defaultIcon);
                                isClicked = false;
                                player.stop(); // <-- stop music
                                ((Timer) evt.getSource()).stop();
                            }
                        }
                    }
                }
            });

            transitionTimer.start();
        });
    }
}
