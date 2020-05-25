import java.awt.image.BufferedImage;

/**
 *
 * @author Mr Vans
 */

public class ImageScanner {

    private int posX;
    private int posY;

    public boolean isOnScreen(BufferedImage screenshot, BufferedImage target) {
        for (int x = 0; x < screenshot.getWidth(); x++) {
            for (int y = 0; y < screenshot.getHeight(); y++) {
                boolean invalid = false;
                int k = x, l = y;
                for (int a = 0; a < target.getWidth(); a++) {
                    l = y;
                    for (int b = 0; b < target.getHeight(); b++) {
                        if (target.getRGB(a, b) != screenshot.getRGB(k, l)) {
                            invalid = true;
                            break;
                        } else {
                            l++;
                        }
                    }
                    if (invalid) {
                        break;
                    } else {
                        k++;
                    }
                }
                if (!invalid) {
                    posX = x;
                    posY = y;
                    return true;
                }
            }
        }
        return false;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
