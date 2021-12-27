import java.util.Random;

public class AI extends Rect{
    public int initialDy = Utils.AI_SPEED;

    public AI(GameWindow window, int x, int y) {
        super(window, x, y, Utils.AI_SPEED);
    }

    public void draw() {
        this.move();
        super.draw();
    }
    public void move() {
        int target = this.window.ball.y;
        Random rnd = new Random();
        rnd.setSeed(System.nanoTime());
        double randomNumber = rnd.nextGaussian(0, 1);
        if (randomNumber < -0.975) {
            this.dy = (int) (randomNumber * this.initialDy);
        }
        else {
            this.dy = initialDy;
        }
        if (this.y <= target) super.move(false);
        else super.move(true);
    }
}
