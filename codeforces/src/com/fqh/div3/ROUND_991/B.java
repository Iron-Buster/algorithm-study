package com.fqh.div3.ROUND_991;


import java.io.*;
import java.util.StringTokenizer;

public class B {

    // https://codeforces.com/contest/2050/problem/B

    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        long s = 0;
        for (long x : a) s += x;
        if (s % n != 0) {
            out.println("NO");
            return;
        }
        long k = s / n;
        long v1 = 0;
        long v2 = 0;
        // 看看能不能把每个数变成 k
        for (int i = 1; i < n; i++) {
            if (v1 != 0) {
                a[i] -= v1;
                v1 = 0;
            }
            if (v2 != 0) {
                a[i] += v2;
                v2 = 0;
            }
            if (i == n - 1) break;

            if (a[i-1] > k) {
                v2 += a[i-1] - k;
                a[i-1] = k;
            } else if (a[i-1] < k) {
                v1 += k - a[i-1];
                a[i-1] = k;
            }
        }
        for (long x : a) {
            if (x != k) {
                out.println("NO");
                return;
            }
        }

        out.println("YES");
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
