package src;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Dirt extends Sprite{

    private Image image;

    private boolean destroyed;

    public Dirt(int x, int y) {
        super(x,y);
        this.destroyed=false;
        initDirt();
    }

    public void initDirt() {
        ImageIcon iicon = new ImageIcon("src/resources/dirt.jpg");
        image = iicon.getImage();
        setImage(image);
    }

    public boolean isDestroyed(){
        return this.destroyed;
    }

    public void destroy(){
        this.destroyed=true;
    }
}
