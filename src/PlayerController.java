import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerController extends KeyAdapter {
    private Player player;
    public boolean isRunning;

    public PlayerController(Player player){
        this.player = player;
        isRunning = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!isRunning)return;
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:{
                if(player.direction ==0)
                    player.direction = -1;
                break;
            }
            case KeyEvent.VK_DOWN:{
                if(player.direction ==0)
                    player.direction = 1;
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!isRunning)return;
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN: {
                if(player.direction !=0)
                    player.direction = 0;
                break;
            }
        }
    }
}
