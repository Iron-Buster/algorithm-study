package com.fqh.div3.ROUND_974;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C {
    // https://codeforces.com/contest/2014/problem/C
    static boolean check(long mid, long[] a) {
        long sum = Arrays.stream(a).sum();
        double avg = ((double) (sum + mid) / a.length) / 2.0;
        int cnt = 0;
        for (long x : a) {
            if (x < avg) cnt++;
        }
        return cnt > a.length / 2;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        if (n == 1 || n == 2) {
            out.println(-1);
            return;
        }
        long l = 0;
        long r = (long) 1e12;
        // 二分这个x
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (check(mid, a)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (check(l, a)) {
            out.println(l);
            return;
        }
        if (check(l + 1, a)) {
            out.println(l + 1);
            return;
        }
        out.println(-1);
    }

    static boolean MULTI_CASE = true;

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
