package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Dirt extends Sprite{

    private Image image;

    public Dirt(int x, int y) {
        super(x,y);

        initDirt();
    }

    public void initDirt() {
        ImageIcon iicon = new ImageIcon("src/resources/dirt.jpg");
        image = iicon.getImage();
        setImage(image);
    }
}
