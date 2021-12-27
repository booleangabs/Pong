import java.awt.*;

public class Ball {
    public int x;
    public int y;
    public int[] velocity = {-1 * Utils.BALL_SPEED, -1 * Utils.BALL_SPEED};
    public final int radius = Utils.BALL_RADIUS;
    public GameWindow window;
    public Graphics2D g2d;

    public Ball(GameWindow window, int x, int y) {
        this.x = x;
        this.y = y;
        this.window = window;
    }

    public void draw() {
        this.move();
        if (this.g2d == null) this.g2d = this.window.g2d;
        this.g2d.setColor(Color.WHITE);
        this.g2d.fillOval(this.x, this.y, this.radius, this.radius);
    }

    public void move() {
        this.x += velocity[0];

        // Top and Bottom hits
        this.y += this.velocity[1];
        if ((this.y <= 30) || (this.y >= 450)) this.velocity[1] *= -1;

        // Paddle hits
        // Player
        if ((this.x <= Utils.PLAYER_OFFSET + Utils.PAD_WIDTH) &
            (this.y >= this.window.player.y - 2 * this.velocity[1]) &
            (this.y <= this.window.player.y + Utils.PAD_HEIGHT - 2 * this.velocity[1])) {
                if (this.y <= (this.window.player.y + Utils.PAD_HEIGHT / 2)) {
                    this.velocity[1] = -Utils.BALL_SPEED;
                }
                else {
                    this.velocity[1] = Utils.BALL_SPEED;
                }
                this.velocity[0] *= -1;
        }

        // AI
        if ((this.x >= Utils.AI_OFFSET - Utils.PAD_WIDTH) &
                (this.y >= this.window.computer.y - 2 * this.velocity[1]) &
                (this.y <= this.window.computer.y + Utils.PAD_HEIGHT - 2 * this.velocity[1])) {
            if (this.y <= (this.window.computer.y + Utils.PAD_HEIGHT / 2)) {
                this.velocity[1] = -Utils.BALL_SPEED;
            }
            else {
                this.velocity[1] = Utils.BALL_SPEED;
            }
            this.velocity[0] *= -1;
        }

        // Side hits
        if ((this.x <= 5) || (this.x >= 610)) {
            if (this.x <= 5) this.window.computerScore++;
            if (this.x >= 610) this.window.playerScore++;
            this.x = Utils.CENTER_X;
            this.y = Utils.CENTER_Y;
        }
    }
}
