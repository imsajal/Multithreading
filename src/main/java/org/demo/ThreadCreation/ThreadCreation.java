package org.demo.ThreadCreation;

public class ThreadCreation {
    public void doSomething() {
        CustomThread customThread = new CustomThread();
        customThread.start();
        try {
            customThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread");

        Thread th = new Thread(new ImplemetingRunnableInterface());
        th.start();

        Thread threadWithLambdaRunnable = new
                Thread(() -> System.out.println("Thread ran using lambda expression"));
        threadWithLambdaRunnable.start();
    }
}
