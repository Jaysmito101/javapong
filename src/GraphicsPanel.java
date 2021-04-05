import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel {
    private Player player, enemy;
    private Ball ball;
    public int gameState;
    private static BufferedImage gameOverScreen, wonScreen;

    public GraphicsPanel(Player player, Player enemy, Ball ball){
        this.player = player;
        this.ball = ball;
        this.enemy = enemy;
        this.setSize(Constants.GAME_FRAME_SIZE);
        this.setBackground(Constants.BACKGROUND_COLOR);
        this.gameState = -1;
        try {
            this.gameOverScreen = ImageIO.read(getClass().getResourceAsStream("/res/GameOverScreen.png"));
            this.wonScreen = ImageIO.read(getClass().getResourceAsStream("/res/YouWonScreen.png"));
        }catch (Exception ex){
            System.out.println("Error in loading Resources!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if(this.gameState==-1){
            g.drawImage(ball, ball.positionX, ball.positionY, null);//rendering the ball
            g.drawImage(player, Constants.GAME_FRAME_WIDTH - Constants.PLAYER_WIDTH, player.yPosition, null);//render the player
            g.drawImage(enemy, 0, enemy.yPosition, null);//render the enemy
        }else if(this.gameState == 0){
            //Game Over!
            g.drawImage(GraphicsPanel.gameOverScreen, 0, 0, null);
        }else if(this.gameState == 1){
            //You Won!
            g.drawImage(GraphicsPanel.wonScreen, 0, 0, null);
        }
    }
}
