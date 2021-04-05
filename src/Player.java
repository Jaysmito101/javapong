import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends BufferedImage {
    public int type;
    public int velocity;
    public int yPosition;
    public int direction;

    public Player(int type){
        super(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        direction = 0;
        this.yPosition = 0;
        this.velocity = 3;
        this.type = type;
        paintComponent();
    }

    protected void paintComponent() {
        Graphics g  = this.getGraphics();
        if(this.type == Constants.PLAYER_ID)
            g.setColor(Constants.PLAYER_COLOR);
        else if(this.type == Constants.ENEMY_ID)
            g.setColor(Constants.ENEMY_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
