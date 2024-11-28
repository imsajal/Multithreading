package org.demo.Problems.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
     ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
     Thread t1 = new Thread(() -> {
         for(int i = 0; i<10; i++){
             try {
                 arrayBlockingQueue.produce(i);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
     });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i<10; i++){
                try {
                    arrayBlockingQueue.consume();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
