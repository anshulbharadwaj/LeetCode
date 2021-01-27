package com.practice.concepts.thread;

import lombok.Data;

@Data
public class SynchronizedMethod {
    private int sum = 0;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }
}
