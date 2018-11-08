package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JPanel;

public class Board extends JPanel {

    private ArrayList<Wall> walls;
    private ArrayList<Diamond> diamonds;
    private ArrayList<Dirt> dirts;
    private ArrayList<Boulder> boulders;
    private Player tom;

    ArrayList<Sprite> world = new ArrayList<>();

    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private final int SPACE = 30;
    private final int OFFSET = 30;

    private int w = 0;
    private int h = 0;

    private String level
            = "#####################################\n"
            + "#....*........*$...#................#\n"
            + "#....$*.......$....#....$...........#\n"
            + "# @...........*....#........*.......#\n"
            + "#..................#$...*...........#\n"
            + "#.......*...........................#\n"
            + "#............*...$....*........$....#\n"
            + "#...................................#\n"
            + "#.....*......$............*.........#\n"
            + "#................*..................#\n"
            + "#......$................$......*....#\n"
            + "##################################..#\n"
            + "#..........................$.....*..#\n"
            + "#.....*........*...........*.....*..#\n"
            + "#.......................*........*..#\n"
            + "#.........$.........*.............*.#\n"
            + "#......................$...........$#\n"
            + "#......*..........*.........*..$*...#\n"
            + "#......$.....................*......#\n"
            + "#*.##################################\n"
            + "#...................$...............#\n"
            + "#.............*...........*......$..#\n"
            + "#......$..........$.................#\n"
            + "#.............................*.....#\n"
            + "#.*..........$.*..*......$..........#\n"
            + "#.............................*.....#\n"
            + "#####################################\n";

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    private void initWorld() {

        int x = OFFSET;
        int y = OFFSET;

        walls = new ArrayList<>();
        diamonds = new ArrayList<>();
        dirts = new ArrayList<>();
        boulders = new ArrayList<>();

        Wall wall;
        Diamond diamond;
        Dirt dirt;
        Boulder boulder;

        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    y += SPACE;

                    if (this.w < x) {
                        this.w = x;
                    }

                    x = OFFSET;
                    break;

                case '#':
                    wall = new Wall(x, y);
                    walls.add(wall);
                    x += SPACE;
                    break;

                case '$':
                    diamond = new Diamond(x, y);
                    diamonds.add(diamond);
                    x += SPACE;
                    break;

                case '.':
                    dirt = new Dirt(x, y);
                    dirts.add(dirt);
                    x += SPACE;
                    break;

                case '@':
                    tom = new Player(x, y);
                    x += SPACE;
                    break;

                case '*':
                    boulder = new Boulder(x,y);
                    boulders.add(boulder);
                    x+= SPACE;
                    break;


                case ' ':
                    x += SPACE;
                    break;

                default:
                    break;
            }

            h = y;
        }

    }

    private void buildWorld(Graphics g) {

        g.setColor(new Color(0, 0, 0));
        g.fillRect(0,0,1200,900);

        world.addAll(walls);
        world.addAll(boulders);
        world.addAll(diamonds);
        world.addAll(dirts);
        world.add(tom);

        for (int i=0;i<world.size();i++) {
            Sprite item = world.get(i);
            g.drawImage(item.getImage(), item.x(), item.y(), this);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    if (checkWallCollision(tom, LEFT_COLLISION))
                        return;
                    tom.move(-SPACE,0);
                    break;
                case KeyEvent.VK_RIGHT:
                    if (checkWallCollision(tom, RIGHT_COLLISION))
                        return;
                    tom.move(SPACE,0);
                    break;
                case KeyEvent.VK_UP:
                    if (checkWallCollision(tom, TOP_COLLISION))
                        return;
                    tom.move(0,-SPACE);
                    break;
                case KeyEvent.VK_DOWN:
                    if (checkWallCollision(tom, BOTTOM_COLLISION))
                        return;
                    tom.move(0,SPACE);
                    break;
            }

            repaint();

        }
    }

    private boolean checkWallCollision(Sprite sprite, int type) {

        switch (type) {

            case LEFT_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (sprite.isLeftCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case RIGHT_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (sprite.isRightCollision(wall)) {
                        return true;
                    }
                }

                return false;

            case TOP_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (sprite.isTopCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case BOTTOM_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (sprite.isBottomCollision(wall)) {

                        return true;
                    }
                }

                return false;

            default:
                break;
        }

        return false;
    }

}
