import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        EventQueue.invokeLater(() -> {
            gameWindow.setVisible(true);
        });
        Thread gameThread = new Thread(gameWindow);
        gameThread.start();
    }
}
