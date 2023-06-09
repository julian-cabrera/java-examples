package com.example.demo.concurrency;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionExample extends Thread {
    static CopyOnWriteArrayList<String> concurrentList = new CopyOnWriteArrayList<>();
    
    public void run()
    {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println("Child Thread going to add element");
        }
 
        // Child thread trying to add new
        // element in the Collection object
        concurrentList.add("D");
    }
}
