package com.practice.concepts.thread.producerconsumer.withoutqueue;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full"
                                + "Producer thread waiting for"
                                + "Consumer to take something from queue");
                        queue.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing value: " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}
