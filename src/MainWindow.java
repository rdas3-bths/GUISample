import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainWindow;
    private JButton button1;
    private JButton button2;
    private Image image;
    private int x;
    private int y;

    public MainWindow(String title) {
        x = 100;
        y = 100;
        setContentPane(mainWindow);
        mainWindow.add(new CustomPaintComponent());
        setTitle(title);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        String imageURL = "src/orange-fox-sprite.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        setVisible(true);
    }

    public class CustomPaintComponent extends Component {

        public void paint(Graphics g) {
            System.out.println("Paint " + x + " " + y);
            Graphics2D g2d = (Graphics2D)g;
            System.out.println(image);
            g2d.drawImage(image, x, y, null);
        }

    }
}
