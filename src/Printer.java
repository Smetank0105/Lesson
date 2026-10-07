public class Printer {
    public synchronized void printDocument(String owner){
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(owner + ": строка " + i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
