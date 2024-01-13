package com.fqh.competition.小白赛.ROUND3;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 21:02
 **/
public class A {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] pmx = new int[n];
        int[] smx = new int[n];
        for (int i = 1; i < n; i++) {
            pmx[i] = Math.max(pmx[i-1], a[i-1]);
        }
        for (int i = n-2; i >= 0; i--) {
            smx[i] = Math.max(smx[i+1], a[i+1]);
        }
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            long v = pmx[i] + smx[i];
            ans = Math.max(ans, v / a[i]);
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
