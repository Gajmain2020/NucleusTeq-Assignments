class MyThread extends Thread {
    private String taskName;

    public MyThread(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(500); // Simulates processing delay
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
            }
        }
        System.out.println(taskName + " completed.");
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Task 1");
        MyThread t2 = new MyThread("Task 2");

        t1.start(); // Start thread 1
        t2.start(); // Start thread 2
    }
}
