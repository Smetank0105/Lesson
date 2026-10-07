public class Printer {
    public synchronized void printDocument(String owner){
        for (int i = 0; i < 5; i++) {
            System.out.println(owner + ": строка " + i);
        }
    }
}
