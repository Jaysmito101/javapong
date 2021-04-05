import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCore implements Runnable, ActionListener{
    private boolean isRunning;
    private Timer renderClock;
    private double deltaTime, then, now;
    private GameFrame gameFrame;

    public GameCore(){
        gameFrame = new GameFrame();
        gameFrame.startGame();
        renderClock = new Timer(Constants.GAME_DELAY/gameFrame.player.velocity, this);
    }

    public void stopGame(){
        isRunning = false;
    }

    public void startGame(){
        isRunning = true;
    }

    public void gameLoop(){
        gameFrame.updatePlayerPositions();
    }

    @Override
    public void run() {
        startGame();
        renderClock.start();
        new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(Constants.GAME_DELAY * 2);
                }catch (Exception ex){}
                gameFrame.ballPositionUpdater.run();
            }
        }.run();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(isRunning){
            gameLoop();
            renderClock.setDelay(Constants.GAME_DELAY/gameFrame.player.velocity);
        }else{
            renderClock.stop();
        }
    }
}
