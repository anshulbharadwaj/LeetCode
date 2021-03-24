package com.practice.concepts.thread.producerconsumer.withoutqueue;

import java.util.Queue;

public class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue queue, int maxSize, String name) {
        super(name);
        this.maxSize = maxSize;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty,"
                            + "Consumer thread is waiting"
                            + "for producer thread to put something in queue");
                    try {
                        queue.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

                System.out.println("Consuming value " + queue.remove());
                queue.notifyAll();

            }

        }
    }
}
