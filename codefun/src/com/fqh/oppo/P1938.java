package com.fqh.oppo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1938 {
    // https://codefun2000.com/p/P1938
    public static void solve() throws IOException {
        int n = in.nextInt();
        long t = in.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        long s = Arrays.stream(a).sum();
        int ans = 0;
        for (int x : a) {
            long v = (s - x) - x;
            if (v >= 0 && v <= t) ans++;
        }

        out.println(ans);
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
