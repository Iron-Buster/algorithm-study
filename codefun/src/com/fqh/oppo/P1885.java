package com.fqh.oppo;

import java.io.*;
import java.util.StringTokenizer;

public class P1885 {

    // https://codefun2000.com/p/P1885
    public static void solve() throws IOException {
        int n = in.nextInt();
        long k = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            if (a[i] > k) {
                out.println(-1);
                return;
            }
        }
        long pre = a[0];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if ((pre | a[i]) >= k) {
                pre = a[i];
                ans++;
            } else {
                pre |= a[i];
            }
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
