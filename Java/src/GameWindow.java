import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Thread;

public class GameWindow extends JFrame implements Runnable {
    public Graphics2D g2d;
    public boolean firstRender = true;
    public int playerScore = 0, computerScore = 0;
    public Player player = new Player(this, Utils.PLAYER_OFFSET,
                                           Utils.CENTER_Y - Utils.PAD_HEIGHT / 2);
    public AI computer = new AI(this, Utils.AI_OFFSET,
                                     Utils.CENTER_Y - Utils.PAD_HEIGHT / 2);
    public Ball ball = new Ball(this,
                                     Utils.CENTER_X - Utils.BALL_RADIUS / 2,
                                     Utils.CENTER_Y - Utils.BALL_RADIUS / 2);

    public GameWindow() {
        this.setSize(Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        this.setResizable(false);
        this.setTitle(Utils.WINDOW_TITLE);
        this.setDefaultCloseOperation(Utils.ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(Utils.ICON.getImage());
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) player.move(true);
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) player.move(false);
            }
        });
    }

    public void update() {
        if (this.g2d == null) this.g2d = (Graphics2D)this.getGraphics();
        this.g2d.setColor(Color.BLACK);
        this.g2d.fillRect(0, 0, Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
        this.g2d.setColor(Color.WHITE);
        for (int i = 0; i < 37; i += 2) {
            this.g2d.fillRect(Utils.CENTER_X - Utils.DIV_WIDTH / 2, i * 13,
                    Utils.DIV_WIDTH, 13);
        }

        this.player.draw();
        this.computer.draw();
        this.ball.draw();

        this.g2d.setColor(Color.GREEN);
        this.g2d.setFont(Utils.FONT);
        this.g2d.drawString(Integer.toString(this.playerScore), Utils.PLAYER_OFFSET, 60);
        this.g2d.drawString(Integer.toString(this.computerScore), Utils.AI_OFFSET, 60);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Warm-up to make sure the Graphics2D is not null
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Started the game");
        while (true) {
            this.update();

            try {
                Thread.sleep(Utils.SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
