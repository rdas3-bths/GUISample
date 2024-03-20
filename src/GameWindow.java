import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;


public class GameWindow extends JFrame implements ActionListener, Runnable {

    private JFrame j;
    private JPanel p;
    private JLabel textLabel;
    private JLabel bottomLabel;
    private int x;
    private int y;
    private int clickerCounter;
    private Thread windowThread;
    private long startTime;

    public GameWindow(String display) {
        startTime = System.currentTimeMillis();
        x = 100;
        y = 100;
        int frameWidth = 500;
        int frameHeight = 500;
        BufferedImage imageOrange = null;
        BufferedImage imageBlue = null;
        try {
            imageOrange = ImageIO.read(new File("src/orange-fox-sprite.png"));
            imageBlue = ImageIO.read(new File("src/blue-fox-sprite.png"));
        }
        catch (Exception e) {}

        p = new DrawPanel(imageOrange, imageBlue);
        j = new JFrame(display);
        textLabel = new JLabel("Counter: " + clickerCounter);
        bottomLabel = new JLabel("Time: " + clickerCounter);
        clickerCounter = 0;
        j.add(p);
        j.add(textLabel, BorderLayout.NORTH);
        j.add(bottomLabel, BorderLayout.SOUTH);
        j.addKeyListener(new KeyTracker());

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(frameWidth, frameHeight);
        j.setLocation(5, 5);
        j.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }


    public void run() {
        while (true) {
            long currentTime = System.currentTimeMillis();
            long timeElapsed = (currentTime - startTime) / 1000;
            bottomLabel.setText("Time: " + timeElapsed + "s");
            p.repaint();
        }


    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
    }

    public class KeyTracker extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 65) {
                clickerCounter++;
                textLabel.setText("Counter: " + clickerCounter);
            }
        }
    }
}

class DrawPanel extends JPanel {

    private BufferedImage image;
    private BufferedImage image1;
    private BufferedImage currentImage;
    private Rectangle fox;
    double x;
    double y;
    boolean foxOffScreen = false;
    int foxType = 0;


    public DrawPanel(BufferedImage image, BufferedImage image1) {
        x = 0;
        y = 0;
        fox = new Rectangle((int)x, (int)y, image.getWidth(), image.getHeight());
        this.image = image;
        this.image1 = image1;
        this.currentImage = image;
        this.addMouseListener(new EventTracker());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(currentImage, (int)x, (int)y, null);
        g.drawRect(0, 0, 15, 15);
        if (foxOffScreen) {
            x = x - .3;
            y = y - .3;
            fox.setLocation((int)x, (int)y);
        }
        else {
            x = x + .3;
            y = y + .3;
            fox.setLocation((int)x, (int)y);
        }
        if (x > 400 && y > 400) {
            foxOffScreen = true;
        }
        if (x < 0) {
            foxOffScreen = false;
        }
    }

    class EventTracker implements MouseListener {
        public void mousePressed(MouseEvent e) {
            if (fox.contains(new Point(e.getX(), e.getY()))) {
                foxType++;
                if (foxType == 2) foxType = 0;
            }

            if (foxType == 0) {
                currentImage = image;
            }
            if (foxType == 1) {
                currentImage = image1;
            }

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseClicked(MouseEvent e) {

        }


    }
}

