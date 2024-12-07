package com.fqh.div3.ROUND_991;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    static char[] a;
    static char[] b;
    static char[] c;

    static int[][] dp;
    // https://codeforces.com/contest/2050/problem/E

    public static void solve() throws IOException {
        a = in.nextLine().toCharArray();
        b = in.nextLine().toCharArray();
        c = in.nextLine().toCharArray();
        int n = c.length;
        dp = new int[n][3001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = dfs(0, 0);
        out.println(res);
    }

    // j表示选择a的数量
    static int dfs(int i, int j) {
        int n = c.length;
        if (i >= n) return 0;
        int k = i - j; // b选择的数量
        if (j >= a.length) { // a选玩了 全选b
           int res = dfs(i + 1, j) + (c[i]== b[k] ? 0 : 1);
           return dp[i][j] = res;
        }
        if (k >= b.length) { // b选完了 全选a
            int res = dfs(i + 1, j + 1) + (c[i] == a[j] ? 0 : 1);
            return dp[i][j] = res;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int res1 = dfs(i + 1, j + 1) + (c[i] == a[j] ? 0 : 1);
        int res2 = dfs(i + 1, j) + (c[i] == b[k] ? 0 : 1);
        return dp[i][j] = Math.min(res1, res2);
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
