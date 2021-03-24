package com.practice.concepts.thread.producerconsumer.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.sharedQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sharedQueue.put(i);
            } catch (InterruptedException ie) {

            }

        }

    }
}
