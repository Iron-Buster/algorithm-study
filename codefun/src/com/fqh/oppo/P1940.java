package com.fqh.oppo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940 {
    // https://codefun2000.com/p/P1940
    // 一个数字如果是3的倍数，那么它的数位和也是3的倍数
    // ext -> 如果一个数字是 9 的倍数，那么它的数位和也是 9 的倍数
    // (a + b + c) % 3 == ((a % 3) + (b % 3) + (c % 3)) % 3

    static final int MOD = (int) (1e9 + 7);
    static String s;
    static long[][] dp;

    static long dfs(int i, int v) {
        if (i >= s.length()) return v % 3 == 0 ? 1 : 0;
        if (dp[i][v] != -1) return dp[i][v];
        long ans = 0;
        if (s.charAt(i) == '?') {
            for (int x = 0; x <= 9; x++) {
                ans += dfs(i + 1, (v + x) % 3);
            }
        } else {
            ans += dfs(i + 1, (v + (s.charAt(i) - '0')) % 3);
        }
        ans %= MOD;
        return dp[i][v] = ans;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        s = in.nextLine();
        dp = new long[n + 1][3];
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
