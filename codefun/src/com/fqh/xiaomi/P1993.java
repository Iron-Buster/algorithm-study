package com.fqh.xiaomi;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1993 {

    // https://codefun2000.com/p/P1993
    // 2024.9.5-XM-第2题-序列(开发岗)

    static int n, x;
    static int[] a;
    static int[][] dp = new int[1001][1001];
    static final int INF = Integer.MAX_VALUE / 2;


    // (a + b + c) % x == ((a % x) + (b % x) + (c % x))
    static int dfs(int i, int v) {
        if (i >= n) {
            return v % x == 0 ? 0 : INF;
        }
        if (dp[i][v] != -1) return dp[i][v];
        // 不删除
        int res = dfs(i + 1, (v + a[i]) % x);
        // 删除 还是 +1
        int op1 = dfs(i + 1, v) + 1;
        int op2 = dfs(i + 1, (v + a[i] + 1) % x) + 1;
        res = Math.min(res, Math.min(op1, op2));
        return dp[i][v] = res;
    }

    public static void solve() throws IOException {
        n = in.nextInt();
        x = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int[] d : dp) Arrays.fill(d, -1);

        int res = dfs(0, 0);
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
