public class Main {
    public static void main(String[] args) {
        //Lets Make Pong in Java!!!!
        GameCore core = new GameCore();
        Thread mainThread = new Thread(core);
        mainThread.start();
        System.out.println("Core Started!");
    }
}
