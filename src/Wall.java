package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Sprite{

    private Image image;

    public Wall(int x, int y) {
        super(x,y);

        initWall();
    }

    public void initWall() {
        ImageIcon iicon = new ImageIcon("src/resources/wall.jpg");
        image = iicon.getImage();
        setImage(image);
    }
}
