import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements ActionListener{

    private JFrame j;
    private JLabel label;
    public GameWindow(String display) {

        j = new JFrame(display);
        j.setSize(300, 300);
        j.setLocation(5, 5);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Press WASD to move!", SwingConstants.CENTER);
        //create new Font
        Font font = new Font("Courier", Font.BOLD,16);

        //set font for JLabel
        label.setFont(font);
        j.add(label);
        j.addKeyListener(new KeyTracker());

        j.show();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
    }

    public class KeyTracker extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_A) {
                System.out.println("a key pressed");
            }
            if (key == KeyEvent.VK_S) {
                System.out.println("s key pressed");
            }
            if (key == KeyEvent.VK_D) {
                System.out.println("d key pressed");
            }
            if (key == KeyEvent.VK_W) {
                System.out.println("w key pressed");
            }
        }

    }
}