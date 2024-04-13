package com.fqh.多线程;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/12 23:42
 **/
public class T1 {

    private static final int N = 100;
    private static int i = 1; // (i%2) == 1 -> (i%2) == 0 -> (i%2) == 1 ...
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (i < N) {
                        if (i % 2 != 1) {
                            lock.wait();
                        }
                        System.out.println("A");
                        i++;
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                }
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (i < N) {
                        if (i % 2 != 0) {
                            lock.wait();
                        }
                        System.out.println("B");
                        i++;
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                }
            }
        }, "B");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(">>>>> end: " + i);
    }
}
