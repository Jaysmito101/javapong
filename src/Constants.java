import java.awt.*;

public class Constants {

    //Private Constructor so that no one can instantiate this class!
    private Constants(){}

    //Constatnt Values

    public static final int GAME_FRAME_WIDTH = 900;
    public static final int GAME_FRAME_HEIGHT = (int)(GAME_FRAME_WIDTH * (5.0 / 9.0));
    public static final Dimension GAME_FRAME_SIZE = new Dimension(GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final Color PLAYER_COLOR = Color.BLUE;
    public static final Color BALL_COLOR = Color.GREEN;
    public static final Color ENEMY_COLOR = Color.RED;
    public static final int PLAYER_ID = 0;
    public static final int ENEMY_ID = 1;
    public static final int PLAYER_HEIGHT = 80;
    public static final int PLAYER_WIDTH = 20;
    public static final int GAME_DELAY = 50;
    public static final int BALL_RADIUS = 15;
}

