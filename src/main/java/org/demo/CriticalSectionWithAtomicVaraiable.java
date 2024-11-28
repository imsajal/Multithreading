package org.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class CriticalSectionWithAtomicVaraiable {

    //static int counter = 0;
    AtomicInteger counter = new AtomicInteger(0);
    public void doSomething() throws InterruptedException {

        Thread[] threads = new Thread[10];
        for(int i =0; i< 10 ;i++){
            threads[i] = new Thread(() -> {
                for(int j=0; j < 10000; j++){
                    counter.getAndIncrement();
                }
            });
            threads[i].start();
        }

        for(int i =0; i< threads.length; i++){
            threads[i].join();
        }
        System.out.println("Final cọunter value - " + counter);
    }
}
