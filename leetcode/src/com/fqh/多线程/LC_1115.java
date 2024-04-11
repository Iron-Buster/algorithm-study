package com.fqh.多线程;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/11 22:32
 **/
public class LC_1115 {

    //https://leetcode.cn/problems/print-foobar-alternately/description/

    class FooBar {
        private int n;
        private int state = 1;
        private final Object lock = new Object();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (state != 1) {
                        lock.wait();;
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    state = 2;
                    lock.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (state != 2) {
                        lock.wait();;
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    state = 1;
                    lock.notify();
                }
            }
        }
    }
}
