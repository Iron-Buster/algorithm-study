package com.fqh.多线程;

import java.util.concurrent.Semaphore;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/11 22:19
 **/
public class LC_1114 {



    //https://leetcode.cn/problems/print-in-order/description/

    class Foo {

        /**
         * 使用状态机模型实现 1->2->3->1
         */
        private int state = 1;
        private final Object lock = new Object();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                state = 2;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (state != 2) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                state = 3;
                lock.notifyAll();;
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (state != 3) {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                state = 1;
                lock.notifyAll();;
            }
        }
    }
}
