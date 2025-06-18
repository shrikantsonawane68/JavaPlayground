class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code for the task that will run in the new thread
        System.out.println("Runnable is running");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task);  // Passing Runnable to Thread
        thread.start();  // Starts the new thread
        //task.run();  // Directly calling run method (not recommended for threading)task.
    }
}
