import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Thread;

public class GameWindow extends JFrame implements Runnable {
    public Graphics2D g2d;
    public Player player = new Player(this, Utils.PLAYER_OFFSET,
                                           Utils.CENTER_Y - Utils.PAD_HEIGHT / 2);
    public AI computer = new AI(this, Utils.AI_OFFSET,
                                     Utils.CENTER_Y - Utils.PAD_HEIGHT / 2);
    public Ball ball = new Ball(this,
                                     Utils.CENTER_X - Utils.BALL_RADIUS / 2,
                                     Utils.CENTER_Y - Utils.BALL_RADIUS / 2);
    public InputListener inputListener = new InputListener();

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
        this.g2d.fillRect(Utils.CENTER_X - Utils.DIV_WIDTH / 2, 0,
                       Utils.DIV_WIDTH, Utils.WINDOW_HEIGHT);

        this.player.draw();
        this.computer.draw();
        this.ball.draw();

        /* For later, transparent drawing
         * this.g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
         * this.g2d.setColor(new Color(0, 255, 0, 50));
         * this.g2d.fillRect(0, 0, Utils.WINDOW_WIDTH, Utils.WINDOW_HEIGHT);
         */
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
