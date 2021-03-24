package com.practice.concepts.thread.producerconsumer.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerRunner {

    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        Thread producer = new Thread(new Producer(sharedQueue));
        Thread consumer = new Thread(new Consumer(sharedQueue));

        producer.start();
        consumer.start();
    }
}
