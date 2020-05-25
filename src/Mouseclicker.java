import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mr Vans
 */

public class Mouseclicker extends Thread {

    private final ImageScanner scanner;
    private boolean start;
    private Robot bot;
    private BufferedImage img_yellow;
    private BufferedImage img_ad;
    private int x;
    private int y;

    public Mouseclicker() {
        scanner = new ImageScanner();
        x = -1;
        y = -1;
        try {
            img_yellow = ImageIO.read(new File("src/images/yellow.png"));
            img_ad = ImageIO.read(new File("src/images/ad.png"));
            bot = new Robot();
        } catch (AWTException | IOException ex) {
            Logger.getLogger(Mouseclicker.class.getName()).log(Level.SEVERE, null, ex);
        }
        start();
    }

    @Override
    public void run() {
        while (true) {
            Thread.yield();
            while (start) {
                try {
                    BufferedImage screenshot = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                    if (scanner.isOnScreen(screenshot, img_yellow) || scanner.isOnScreen(screenshot, img_ad)) {
                        click(scanner.getPosX(), scanner.getPosY());
                        x = scanner.getPosX();
                        y = scanner.getPosY();
                    }
                } catch (AWTException ex) {
                    Logger.getLogger(Mouseclicker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void click(int x, int y) {
        if (this.x == x && this.y == y) {
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public void toggleStart() {
        start = !start;
    }
}
