import java.awt.*;

public class BallPositionUpdater implements Runnable{
    private Ball ball;
    public boolean isRunning;
    public GraphicsPanel panel;
    public GameFrame frame;

    public BallPositionUpdater(Ball ball, GraphicsPanel panel, GameFrame frame){
        this.ball = ball;
        this.frame = frame;
        this.panel = panel;
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.isRunning = true;
        while (isRunning){
            updateBallPosition();
            panel.repaint();
            try {
                Thread.sleep(Constants.GAME_DELAY);
            }catch (Exception ex){}
        }
    }

    public void updateBallPosition(){
        checkAndFixBallDirection();
        updateBallCoordinates();
    }

    private void updateBallCoordinates() {
        ball.positionY += ball.directionY * ball.velocityY;
        ball.positionX += ball.directionX * ball.velocityX;
    }

    private void checkAndFixBallDirection() {
        checkAndFixBallDirectionY();
        checkAndFixBallDirectionX();
    }

    private void checkAndFixBallDirectionY() {
        if(ball.positionY < Constants.BALL_RADIUS){
            randomizeBallVelocity();
            ball.directionY = 1;
        }else if(ball.positionY > (Constants.GAME_FRAME_HEIGHT - Constants.BALL_RADIUS*4)){
            randomizeBallVelocity();
            ball.directionY = -1;
        }
    }

    public void randomizeBallVelocity(){
        //Some Randomness
        ball.velocityY = (int)( Math.random() * 8 ) +2;
        ball.velocityX = (int)( Math.random() * 8 ) +2;
    }

    private void checkAndFixBallDirectionX() {
        if(ball.positionX < Constants.BALL_RADIUS){
            randomizeBallVelocity();
            if(Math.abs(ball.positionY - frame.enemy.yPosition) > Constants.PLAYER_HEIGHT/2){
                frame.gameOver(1);
            }else {
                ball.directionX = 1;
            }
        }else if(ball.positionX > (Constants.GAME_FRAME_WIDTH - Constants.BALL_RADIUS*3)){
            randomizeBallVelocity();
            if(Math.abs(ball.positionY - frame.player.yPosition) > (Constants.PLAYER_HEIGHT*0.75)){
                frame.gameOver(0);
            }else {
                ball.directionX = -1;
            }
        }
    }
}
