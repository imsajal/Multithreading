package org.demo.Problems.ProducerConsumer;

import java.util.Queue;

public class SharedResource {

    private Queue<Integer> queue;
    private Integer bufferSize;

    public SharedResource(Integer bufferSize, Queue<Integer> queue) {
        this.bufferSize = bufferSize;
        this.queue = queue;
    }

    public synchronized void produce(int item){

        while(queue.size() == bufferSize){
            System.out.println("Waiting for consumer to consume");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Produced: " + item);
        queue.add(item);
        notify();
    }

    public synchronized void consume(){

        while(queue.size() == 0){
            System.out.println("Waiting for producer to produce");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumed: " + queue.poll());
        notify();
    }
}
