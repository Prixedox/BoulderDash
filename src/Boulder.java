package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Boulder extends Sprite{

    private Image image;

    public Boulder(int x, int y) {
        super(x,y);

        initBoulder();
    }

    public void initBoulder() {
        ImageIcon iicon = new ImageIcon("src/resources/boulder.jpg");
        image = iicon.getImage();
        setImage(image);
    }
}
