package com.fqh.动态规划.状压DP.排列型相邻相关;

import java.io.*;
import java.util.*;

// https://hydro.ac/d/luogu/p/P2915

public class Mixed_Up_Cows_G {

    static long[][] dp;
    public static void solve() throws Exception {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextLong();
        int U = (1<<n) - 1;
        dp = new long[n][U];
        for (long[] d : dp) Arrays.fill(d, -1);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += dfs(i, 1<<i, U, k, nums);
        }
        out.println(res);
    }

    public static long dfs(int i, int mask, int U, int k, long[] nums) {
        if (mask == U) return 1;
        if (dp[i][mask] != -1) return dp[i][mask];
        long ans = 0;
        long pre = nums[i];
        for (int j = 0; j < nums.length; j++) {
            // 相邻元素差必须超过k
            if (((mask>>j)&1) == 0 && Math.abs(pre - nums[j]) > k) {
                ans += dfs(j, mask|(1<<j), U, k, nums);
            }
        }
        return dp[i][mask] = ans;
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
