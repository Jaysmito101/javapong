public class EnemyAI implements Runnable{
    public Ball ball;
    public Player enemy;
    public boolean isRunning;

    public EnemyAI(Ball ball, Player enemy){
        this.isRunning = true;
        this.ball = ball;
        this.enemy = enemy;
    }

    @Override
    public void run() {
        while(true) {
            //enemy.yPosition = ball.positionY; // - This is the logic where no one can ever defeat the computer!]

            //Other alternative
            if(ball.positionX < Constants.GAME_FRAME_WIDTH*0.25){
                if(ball.positionY > enemy.yPosition){
                    enemy.direction = 1;
                }else{
                    enemy.direction = -1;
                }
            }
            try{
                Thread.sleep(Constants.GAME_DELAY/2);
            }catch (Exception ex){}
        }
    }
}
