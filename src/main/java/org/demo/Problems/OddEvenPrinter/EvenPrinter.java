package org.demo.Problems.OddEvenPrinter;

import org.demo.Main;



public class EvenPrinter extends Thread{

    @Override
    public void run(){

        Integer MAX = MainPrinter.MAX;
        Object lock = MainPrinter.lock;

        synchronized (lock) {
            while (MainPrinter.currentNumber <= MAX) {
                if (MainPrinter.currentNumber % 2 == 0) {
                    System.out.println("EvenNumber - " + MainPrinter.currentNumber);
                    MainPrinter.currentNumber++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
