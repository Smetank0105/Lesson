static int counter = 0;

void main() throws InterruptedException {
    //1
    Thread thread1 = new Thread(new MyThread());
    thread1.setName("thread from class");
    thread1.setPriority(Thread.MIN_PRIORITY);

    Thread thread2 = new Thread(() -> {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " приоритет: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    });
    thread2.setName("thread from lyambda");
    thread2.setPriority(Thread.NORM_PRIORITY);

    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " приоритет: " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    });
    thread3.setName("thread from lyambda");
    thread3.setPriority(Thread.MAX_PRIORITY);

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();

    System.out.println("THE END");

    //2
    int count = 0;
    int min = 400000;
    int max = 0;

    for (int i = 0; i < 10; i++) {
        Runnable runnable = () -> {
            for (int j = 0; j < 100000; j++) {
                counter++;
            }
        };

        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);


        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();

        System.out.println(counter);
        if (counter == 400000) count++;
        if (min > counter) min = counter;
        if (max < counter) max = counter;
        counter = 0;
    }
    System.out.println("Count 400000 - " + count);
    System.out.println("Min - " + min);
    System.out.println("Max - " + max);
}
