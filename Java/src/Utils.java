import assets.fonts.Berlin;
import assets.images.Images;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Utils {
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    public static final int PAD_HEIGHT = 80;
    public static final int PAD_WIDTH = 20;
    public static final int CENTER_X = Utils.WINDOW_WIDTH / 2;
    public static final int CENTER_Y = Utils.WINDOW_HEIGHT / 2;
    public static final int BALL_RADIUS = 15;
    public static final int OFFSET = 25;
    public static final int PLAYER_OFFSET = OFFSET;
    public static final int AI_OFFSET = WINDOW_WIDTH - OFFSET - PAD_WIDTH;
    public static final String WINDOW_TITLE = "Pong - Java";
    public static final int DIV_WIDTH = 10;
    public static final int SLEEP = 45;
    public static final int BALL_SPEED = 11;
    public static final int AI_SPEED = 10;
    public static final int PLAYER_SPEED = 10;
    public static final int ON_CLOSE = WindowConstants.EXIT_ON_CLOSE;
    public static final ImageIcon ICON = new ImageIcon(Objects.requireNonNull(Images.class.getResource("icon.png")));
    public static Font FONT = null;

    static {
        try {
            FONT = Font.createFont(
              Font.TRUETYPE_FONT,
              Objects.requireNonNull(Berlin.class.getResourceAsStream("Berlin.ttf"))
            );
            FONT = FONT.deriveFont(30.0f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}