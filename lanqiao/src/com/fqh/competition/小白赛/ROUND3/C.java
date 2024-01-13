package com.fqh.competition.小白赛.ROUND3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 21:37
 **/
public class C {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
        }
        long[] s = new long[n+10];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + a[i];
        }
        long[] bb = new long[n+10];
        bb[0] = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            bb[i] = Math.min(bb[i-1], a[i] * 1L + b[i]);
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= Math.min(k, n); i++) {
            ans = Math.min(ans, s[i] + (k - i) * 1L * bb[i]);
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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
