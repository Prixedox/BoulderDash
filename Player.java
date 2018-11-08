package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Sprite {

    private Image image;

    public Player(int x,int y) {
        super(x,y);

        initPlayer();
    }

    private void initPlayer() {

        ImageIcon iicon = new ImageIcon("src/resources/player.jpg");
        Image image = iicon.getImage();
        setImage(image);
    }

    public void move(int x, int y) {

        int dx = x() + x;
        int dy = y() + y;

        setX(dx);
        setY(dy);
    }
}
