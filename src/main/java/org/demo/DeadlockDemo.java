package org.demo;

class Resource {
    String name;

    public Resource(String name) {
        this.name = name;
    }
}
// we can also do using two synchronized method and creating two objects of same with just wait
// and no thread calls notify
class DeadlockExample {
    private final Resource resource1 = new Resource("Resource1");
    private final Resource resource2 = new Resource("Resource2");

    Thread thread1 = new Thread(() -> {
        synchronized (resource1) {
            System.out.println("Thread 1: Locked " + resource1.name);

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (resource2) {
                System.out.println("Thread 1: Locked " + resource2.name);
            }
        }
    });

    Thread thread2 = new Thread(() -> {
        synchronized (resource2) {
            System.out.println("Thread 2: Locked " + resource2.name);

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (resource1) {
                System.out.println("Thread 2: Locked " + resource1.name);
            }
        }
    });

    public void startThreads() {
        thread1.start();
        thread2.start();
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();
        deadlockExample.startThreads();
    }
}
