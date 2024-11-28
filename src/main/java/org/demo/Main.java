package org.demo;


import org.demo.ThreadCreation.ThreadCreation;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Thread creation ------------------------------------------------------------
        new ThreadCreation().doSomething();

        // Thread creation ------------------------------------------------------------
        new CriticalSectionWithAtomicVaraiable().doSomething();

        // Problems -------------------------------------------------------------------



    }
}
