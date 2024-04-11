package com.fqh.多线程;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/11 22:36
 **/
public class T {

    private static int state = 1;
    private static final Object lock = new Object();
    private static  List<Character> list = new ArrayList<>();
    private static final AtomicInteger count = new AtomicInteger(0);
    private static char[] a, b;
    private static List<String> res = new ArrayList<>();

    public static void solve() throws IOException, InterruptedException {
        a = in.nextLine().toCharArray();
        b = in.nextLine().toCharArray();

        new Thread(() -> {
            for (int i = 0; i < a.length; i++) {
                synchronized (lock) {
                    try {
                        while (state != 1) {
                            lock.wait();
                        }
                        list.add(a[i]);
                        state = 2;
                        lock.notify();
                    } catch (InterruptedException e) {

                    }
                }
            }

        }, "T1").start();

        new Thread(() -> {
            for (int i = 0; i < b.length; i++) {
                synchronized (lock) {
                    try {
                        while (state != 2) {
                            lock.wait();
                        }
                        list.add(b[i]);
                        state = 1;
                        lock.notify();
                    } catch (InterruptedException e) {}
                }
            }

        }, "T2").start();


        new Thread(() -> {
            while (list.size() != a.length * 2) {

                //TODO
            }
        }, "T3").start();

        Thread.sleep(100000);
    }

    static boolean MULTI_CASE = false;
    public static void main(String[] args) throws Exception {
        int T = MULTI_CASE ? in.nextInt() : 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
