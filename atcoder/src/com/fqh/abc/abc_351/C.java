package com.fqh.abc.abc_351;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/29 22:15
 **/
public class C {



    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        var q = new ArrayDeque<Long>();
        for (int i = 0; i < n; i++) {
            long x = a[i];
            if (q.isEmpty() || q.size() < 2) {
                q.addLast(x);
                continue;
            }
            while (q.size() > 1) {
                long first = q.pollLast();
                long second = q.pollLast();
                if (first == second) {
                    q.offer(first + 1);
                } else {
                    q.addLast(second);
                    q.addLast(first);
                    break;
                }
            }
            q.offer(x);
        }
        while (q.size() > 1) {
            long first = q.pollLast();
            long second = q.pollLast();
            if (first == second) {
                q.offer(first + 1);
            } else {
                q.addLast(second);
                q.addLast(first);
                break;
            }
        }
        out.println(q.size());
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
