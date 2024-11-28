package org.demo.Problems.PrintUsingNThreads;


/*Write a program which creates 3 threads (T1, T2, T3) and every thread
should run in such a sequential manner that the output is like:
T1:1
T2:2
T3:3
        .
        ,
        ,
T1:10
Make the code scalable for 'n' threads.*/

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
