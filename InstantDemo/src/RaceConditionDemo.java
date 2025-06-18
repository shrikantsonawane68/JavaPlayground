import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int count = 0;
     private AtomicInteger atomicCount = new AtomicInteger(0);

    public void increment() {
        synchronized (this){
            count++;  // This is not atomic!
        }

        atomicCount.incrementAndGet(); // This is atomic!
    }

    public int getCount() {
        return count;
    }

    public int getAtomicCount() {
        return atomicCount.get();
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create two threads that will increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Final count: " + counter.getCount());  // Expected 2000, but it might be less
        System.out.println("Final atomicCount: " + counter.getAtomicCount());  // Expected 2000, but it might be less
    }
}

