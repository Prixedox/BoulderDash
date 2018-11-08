package src;

import java.awt.Image;

public class Sprite {
    private int x;
    private int y;

    private final int SPACE = 30;

    private Image image;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int x() {

        return x;
    }

    public int y() {

        return y;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public boolean isLeftCollision(Sprite sprite) {

        return x() - SPACE == sprite.x() && y() == sprite.y();
    }

    public boolean isRightCollision(Sprite sprite) {

        return x() + SPACE == sprite.x() && y() == sprite.y();
    }

    public boolean isTopCollision(Sprite sprite) {

        return y() - SPACE == sprite.y() && x() == sprite.x();
    }

    public boolean isBottomCollision(Sprite sprite) {

        return y() + SPACE == sprite.y() && x() == sprite.x();
    }

}
