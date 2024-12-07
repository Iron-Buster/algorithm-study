package com.fqh.div3.ROUND_991;


import java.io.*;
import java.util.StringTokenizer;

public class C {
    // https://codeforces.com/contest/2050/problem/C
    static int[] a;
    static Boolean[][][] dp;

    public static void solve() throws IOException {
        a = in.nextLine().chars().map(i -> (i-'0')).toArray();
        int n = a.length;
        dp = new Boolean[n][2][9];
//        dp[0][0][0] = true;
        boolean res = dfs(0, 0, 0);
        out.println(res ? "YES" : "NO");
    }

    static boolean dfs(int i, int j, int k) {
        if (i >= a.length) {
            return k == 0;
        }
        if (dp[i][j][k] != null) return dp[i][j][k];
        boolean res = false;
        res |= dfs(i + 1, 0, (k + a[i]) % 9);
        if (a[i] * a[i] < 10) {
            res |= dfs(i + 1, 1, (k + a[i] * a[i]) % 9);
        }
        return dp[i][j][k] = res;
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
