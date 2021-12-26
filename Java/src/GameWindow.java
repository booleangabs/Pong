import javax.swing.*;

public class GameWindow extends JFrame implements Runnable {
    public GameWindow() {
        this.setSize(Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        this.setResizable(false);
        this.setTitle(Utils.WINDOW_TITLE);
        this.setDefaultCloseOperation(Utils.ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void run() {
        while (true) {
        }
    }
}
