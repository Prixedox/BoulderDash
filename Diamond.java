package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Diamond extends Sprite{

    private Image image;

    private boolean destroyed;

    public Diamond(int x, int y) {
        super(x,y);
        destroyed=false;
        initDiamond();
    }

    public void initDiamond() {
        ImageIcon iicon = new ImageIcon("src/resources/diamond.jpg");
        image = iicon.getImage();
        setImage(image);
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public void destroy() {
        this.destroyed=true;
    }
}
