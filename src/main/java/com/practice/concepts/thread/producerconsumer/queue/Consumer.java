package com.practice.concepts.thread.producerconsumer.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.sharedQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed " + sharedQueue.take());
            } catch (InterruptedException ie) {

            }
        }
    }
}
