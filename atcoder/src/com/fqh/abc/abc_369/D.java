package com.fqh.abc.abc_369;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static int n;
    static int[] a;
    static long[][] dp;

    static long dfs(int i, int state) {
        if (i >= n) return 0;
        if (dp[i][state] != -1) return dp[i][state];
        long x = dfs(i + 1, state);
        long y = 0;
        if (state == 1) {
            y = dfs(i +1 , state ^ 1) + 2L * a[i];
        } else {
            y = dfs(i + 1, state ^ 1) + a[i];
        }
        return dp[i][state] = Math.max(x, y);
    }

    public static void solve() throws IOException {
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        dp = new long[n + 1][2];
        for (long[] d : dp) Arrays.fill(d, -1);

        long res = dfs(0, 0);
        out.println(res);
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
