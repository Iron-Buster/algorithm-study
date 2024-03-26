package com.fqh.xiaohongshu;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/25 18:21
 **/
public class P1744 {

//    https://codefun2000.com/p/P1744
//    #P1744. 2024.03.24-小红书-第二题-塔子哥的关注数


    static final int INF = 0x3f3f3f;
    static int[][][] dp;
    static int[] a;
    static int n, x;
    // 恰好为x
    static int dfs(int i, int c, int v) {
        if (i >= n) return v == x ? 0 : INF;
        if (v == x) return 0;
        // 不选第i个
        int ans = dfs(i + 1, 0, v);
        // 选第i个 方案1
        ans = Math.min(ans, dfs(i + 1, 1, v + a[i] / 2) + 1);
        // 选第i个 方案2
        return dp[i][c][v] = ans;
    }
    public static void solve() throws IOException {
        n = in.nextInt();
        x = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        dp = new int[n][x + 1][x + 1];
        for (int[][] d : dp) {
            for (int[] f : d) {
                Arrays.fill(f, INF);
            }
        }
        int res = dfs(0, 0, 0);
        out.println(res == INF ? -1 : res);
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
