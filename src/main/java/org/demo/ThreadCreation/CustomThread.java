package org.demo.ThreadCreation;

public class CustomThread extends Thread{

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi, this is custom thread");
    }
}
