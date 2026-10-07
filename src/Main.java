void main() throws InterruptedException {
    //1
    Loader loader = new Loader();
    Thread thread = new Thread(loader);
    thread.start();
    Thread.sleep(2000);
    loader.stop();
    thread.join();

    //2
    Printer printer = new Printer();
    Thread thread1 = new Thread(()->printer.printDocument("Иван"));
    Thread thread2 = new Thread(()->printer.printDocument("Мария"));
    Thread thread3 = new Thread(()->printer.printDocument("Олег"));

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();
}
