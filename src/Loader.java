public class Loader implements Runnable{
    private volatile boolean running = true;

    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        while(running){
            try {
                System.out.println("Loaded...");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
