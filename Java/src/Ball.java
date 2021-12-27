import java.awt.*;

public class Ball {
    public int x;
    public int y;
    public int[] direction;
    public final int radius = Utils.BALL_RADIUS;
    public GameWindow window;
    public Graphics2D g2d;

    public Ball(GameWindow window, int x, int y) {
        this.x = x;
        this.y = y;
        this.window = window;
    }

    public void draw() {
        if (this.g2d == null) this.g2d = this.window.g2d;
        Color previousColor = this.g2d.getColor();
        this.g2d.setColor(Color.GREEN);
        this.g2d.fillOval(this.x, this.y, this.radius, this.radius);
        this.g2d.setColor(previousColor);
    }

    public void move(boolean up) {
    }
}
