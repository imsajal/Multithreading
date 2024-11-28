package org.demo.Problems.ArrayBlockingQueue;

public class ArrayBlockingQueue<T> {

    int capacity;
    int count;
    int head;
    int tail;
    final Object[] arr ;

    public ArrayBlockingQueue(int capacity){
        head = 0;
        tail = 0;
        count = 0;
        this.capacity = capacity;
        arr = new Object[capacity];
    }


    public synchronized T consume() throws InterruptedException {
        while(count == 0){
            wait();
        }
        T val = (T) arr[head];
        arr[head] = null;
        head = (head + 1) % capacity;
        count--;
        notify();
        System.out.println("Consumed " + val);
        return val;
    }

    public synchronized void produce(T value) throws InterruptedException {
       while(count == capacity){
           wait();
       }
       arr[tail] = value;
       tail = (tail + 1) % capacity;
       count++;
       System.out.println("Produced " + value);
       notify();
    }
}
