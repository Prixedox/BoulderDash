package src;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class BoulderDash extends JFrame {

    private final int OFFSET = 30;

    public BoulderDash() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setTitle("BoulderDash");

        setSize(1200,900);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            BoulderDash game = new BoulderDash();
            game.setVisible(true);
        });
    }
}