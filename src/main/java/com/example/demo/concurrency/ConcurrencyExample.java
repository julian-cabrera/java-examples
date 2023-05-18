package com.example.demo.concurrency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.demo.OneInterfaceToRunThemAll;

public class ConcurrencyExample implements OneInterfaceToRunThemAll{
    
    // Maximum number of threads in thread pool
    private final int MAX_T = 3;

    @Override
    public void runExample() {
        //counting();
        threadPoolExample();
    }

    private void counting(){
        class Counter {
            int counter = 0;
            public void increment() { counter++; }
            public int get() { return counter; }
        }
        
            final Counter counter = new Counter();
            
            class CountingThread extends Thread {
                public void  run() {
                    for (int x = 0; x < 500000; x++) {
                        counter.increment();
                    }
                }
            }
    
            CountingThread t1 = new CountingThread();
            CountingThread t2 = new CountingThread();
            t1.start(); t2.start();

            try {
                t1.join(); t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(counter.get());
    }

    private void threadPoolExample(){
        // creates five tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");      
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5); 
          
        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}