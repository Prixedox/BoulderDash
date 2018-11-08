package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Diamond extends Sprite{

    private Image image;

    public Diamond(int x, int y) {
        super(x,y);

        initDiamond();
    }

    public void initDiamond() {
        ImageIcon iicon = new ImageIcon("src/resources/diamond.jpg");
        image = iicon.getImage();
        setImage(image);
    }
}
