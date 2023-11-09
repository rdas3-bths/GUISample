import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameWindow extends JFrame implements ActionListener{

    private JFrame j;
    private JPanel p;
    private JLabel textLabel;
    private Image image;
    private int x;
    private int y;
    private int clickerCounter;

    public GameWindow(String display) {
        x = 100;
        y = 100;
        int frameWidth = 500;
        int frameHeight = 500;
        j = new JFrame(display);
        textLabel = new JLabel("Counter: " + clickerCounter);
        clickerCounter = 0;
        j.add(textLabel, BorderLayout.NORTH);
        j.addKeyListener(new KeyTracker());

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(frameWidth, frameHeight);
        j.setLocation(5, 5);
        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
    }

    public class KeyTracker extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                clickerCounter++;
                textLabel.setText("Counter: " + clickerCounter);
            }
        }

    }
}