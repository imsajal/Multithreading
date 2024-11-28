package org.demo.Problems.PrintUsingNThreads;

class ThreadPrinter extends Thread{

    int threadId;
    int totalNoOfThreads;
    static int current = 1;
    static int max = 30;
    static Object lock = new Object();

    ThreadPrinter(int threadId, int totalNoOfThreads){
        this.totalNoOfThreads = totalNoOfThreads;
        this.threadId = threadId;
    }

    @Override
    public void run(){

        synchronized (lock){
            while(current <= max){
                if(current % totalNoOfThreads == (threadId % totalNoOfThreads)){
                    System.out.println("T" + threadId + " : " + current);
                    current++;
                    lock.notifyAll();
                }
                else{
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
public class Main {

    public static void main(String[] args) {

        int noOfThreads = 5;
        for (int i = 1; i <= noOfThreads; i++) {
             new ThreadPrinter(i, noOfThreads).start();
        }
    }
}
