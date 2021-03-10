package com.practice.concepts.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private int capacity;
    private BlockingQueue<Runnable> workerQueue;
    private Thread[] workerThreads;

    public CustomThreadPool(int capacity) {
        this.capacity = capacity;
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[capacity];
        for (int i = 0; i < workerThreads.length; i++) {
            Thread thread = new Worker(" WorkerThread " + i);
            thread.start();
        }
    }

    public void addTask(Runnable runnable) {
        try {
            workerQueue.put(runnable);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    workerQueue.take().run();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(5);
        customThreadPool.addTask(() -> {
            System.out.println("This is a first task");
        });
        customThreadPool.addTask(() -> {
            System.out.println("This is second task");
        });
    }
}
