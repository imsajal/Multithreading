package org.demo.Problems.OddEvenPrinter;

public class MainPrinter {

    //Print Odd/Even numbers in multiple threads (one by one)
    public static final Object lock = new Object();
    public static final Integer MAX = 4;
    public static  int currentNumber = 1;

    public static void main(String[] args){

        EvenPrinter evenPrinter = new EvenPrinter();
        OddPrinter oddPrinter = new OddPrinter();

        oddPrinter.start();
        evenPrinter.start();

    }

}
