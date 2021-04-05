import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends BufferedImage {
    public int velocityX, velocityY;
    public int positionX, positionY;
    public int directionX, directionY;

    public Ball(){
        super(Constants.BALL_RADIUS*2, Constants.BALL_RADIUS*2, BufferedImage.TYPE_INT_ARGB);
        this.directionX = 0;
        this.directionY = 0;
        this.positionX = Constants.GAME_FRAME_WIDTH/2-Constants.BALL_RADIUS;
        this.positionY = Constants.GAME_FRAME_HEIGHT/2-Constants.BALL_RADIUS;
        this.velocityX = 5;
        this.velocityY = 5;
        paintComponent();
    }

    protected void paintComponent() {
        Graphics g  = this.getGraphics();
        g.setColor(Constants.BALL_COLOR);
        g.fillOval(0, 0, Constants.BALL_RADIUS*2, Constants.BALL_RADIUS*2);
    }
}
