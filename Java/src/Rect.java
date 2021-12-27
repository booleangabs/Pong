import java.awt.*;

public class Rect {
    public int x;
    public int y;
    public final int width = Utils.PAD_WIDTH;
    public final int height = Utils.PAD_HEIGHT;
    public final int dy = 5;
    public GameWindow window;
    public Graphics2D g2d;

    public Rect(GameWindow window, int x, int y) {
        this.x = x;
        this.y = y;
        this.window = window;
    }

    public void draw() {
        if (this.g2d == null) this.g2d = this.window.g2d;
        Color previousColor = this.g2d.getColor();
        this.g2d.setColor(Color.WHITE);
        this.g2d.fillRect(this.x, this.y, this.width, this.height);
        this.g2d.setColor(previousColor);
    }

    public void move(boolean up) {
        if (up) this.y -= this.dy;
        else this.y += this.dy;
        this.y = Math.max((this.height / 2) - 2 * this.dy,
                          Math.min(this.y, this.window.getHeight() - this.height - this.dy));
        System.out.println(this.y);
    }
}
