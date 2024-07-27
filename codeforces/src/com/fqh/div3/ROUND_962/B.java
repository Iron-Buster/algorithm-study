package com.fqh.div3.ROUND_962;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/7/27 11:08
 **/
public class B {



    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) {
            g[i] = in.nextLine().toCharArray();
        }
        if (n == k) {
            out.println(g[0][0]);
            return;
        }
        if (k == 1) {
            for (char[] gg : g) {
                out.println(String.valueOf(gg));
            }
            return;
        }
        int t = n / k;
        char[][] res = new char[t][t];
        for (int i = 0, i1 = 0; i < n; i += k, i1++) {
            for (int j = 0, j1 = 0; j < n; j += k, j1++) {
                res[i1][j1] = g[i][j];
            }
        }
        for (char[] r : res) {
            out.println(String.valueOf(r));
        }
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
