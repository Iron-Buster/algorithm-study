package com.fqh.多线程;

import java.util.function.IntConsumer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/11 23:06
 **/



public class LC_1195 {

    //https://leetcode.cn/problems/fizz-buzz-multithreaded/description/

    class FizzBuzz {
        private int n;
        private int i = 1;
        private final Object lock = new Object();

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            synchronized (lock) {
                while (i <= n) {
                    if (i % 5 != 0 && i % 3 == 0) {
                        printFizz.run();
                        i++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            synchronized (lock) {
                while (i <= n) {
                    if (i % 3 != 0 && i % 5 == 0) {
                        printBuzz.run();
                        i++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            synchronized (lock) {
                while (i <= n) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        printFizzBuzz.run();
                        i++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            synchronized (lock) {
                while (i <= n) {
                    if (i % 3 != 0 && i % 5 != 0) {
                        printNumber.accept(i);
                        i++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }
    }
}
