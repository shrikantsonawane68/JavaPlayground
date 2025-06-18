public class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        // Thread 1 (Writer)
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000);  // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flag = true;  // Change the flag value
            System.out.println("Flag set to true");
        });

        // Thread 2 (Reader)
        Thread reader = new Thread(() -> {
            while (!flag) {  // Keep checking the flag until it is set to true
                // Busy-wait loop, the value of flag is checked from main memory
                System.out.println("Flag is now false");
            }
            System.out.println("Flag is now true");
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }
}
