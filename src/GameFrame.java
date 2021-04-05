import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class GameFrame extends JFrame {
    private GraphicsPanel panel;
    public Player player, enemy;
    public Ball ball;
    public BallPositionUpdater ballPositionUpdater;
    public PlayerController controller;
    public Thread ai;

    public GameFrame(){
        //This is just a extra pert!

        JMenuItem item = new JMenuItem("About Developer");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(new JFrame(), "This is a Java Pong Game\ndesigned and developed by\nJaysmito Mukherjee.", "Jaysmito Mukherjee", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JMenuItem item2 = new JMenuItem("Developers's Website");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(JOptionPane.showConfirmDialog(new JFrame(), "Open Website?") == JOptionPane.YES_OPTION){
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.youtube.com/channel/UCvVUCzb12l-3FM740TdD-Vw"));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(new JFrame(), "Failed to open website.\nPlease restart the application\nand try again!", "Error in Opening Website", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("About");
        menu.add(item);
        menu.add(item2);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        this.setLayout(new BorderLayout());
        player = new Player(Constants.PLAYER_ID);
        enemy = new Player(Constants.ENEMY_ID);
        ball = new Ball();
        ball.directionX = (Math.random()>0.5)?1:-1;
        ball.directionY = (Math.random()>0.5)?1:1;
        panel = new GraphicsPanel(player, enemy, ball);
        ballPositionUpdater = new BallPositionUpdater(ball, panel, this);
        ai = new Thread(new EnemyAI(ball, enemy));
        this.setTitle("Java Pong --Jaysmito Mukherjee");
        this.controller = new PlayerController(player);
        this.addKeyListener(controller);
        this.add(panel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setFocusable(true);
        this.setSize(Constants.GAME_FRAME_SIZE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//to center the window
    }

    public void gameOver(int status){
        System.out.println(status==0?"Game Over!":"You Won!");
        panel.gameState = status;
        ballPositionUpdater.isRunning = false;
        controller.isRunning = false;
    }


    public void updatePlayerYPosition() {
        if(player.yPosition+player.velocity*player.direction<0 || player.yPosition+player.velocity*player.direction>Constants.GAME_FRAME_HEIGHT-Constants.PLAYER_HEIGHT*1.3)
            return;
        player.yPosition+=player.direction*player.velocity;
    }

    public void updateEnemyYPosition() {
        if(enemy.yPosition+enemy.velocity*enemy.direction<0 || enemy.yPosition+enemy.velocity*enemy.direction>Constants.GAME_FRAME_HEIGHT-Constants.PLAYER_HEIGHT*1.3)
            return;
        enemy.yPosition+=enemy.direction*enemy.velocity;
    }

    public void updatePlayerPositions(){
        updatePlayerYPosition();
        updateEnemyYPosition();
        panel.repaint();
    }

    public void startGame(){
        ai.start();
        this.setVisible(true);
    }
}
