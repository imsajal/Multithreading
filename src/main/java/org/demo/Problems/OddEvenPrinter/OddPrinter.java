package org.demo.Problems.OddEvenPrinter;

public class OddPrinter extends Thread {

    @Override
    public void run() {

        Integer MAX = MainPrinter.MAX;
        Object lock = MainPrinter.lock;
        // wait and notify should be called inside synchronized block or method only
        // notify() == this.notify()
        synchronized (lock) {
            while (MainPrinter.currentNumber <= MAX) {
                if (MainPrinter.currentNumber % 2 != 0) {
                    System.out.println("OddNumber - " + MainPrinter.currentNumber);
                    MainPrinter.currentNumber++;
                    notify();
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
