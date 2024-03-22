package com.fqh.dewu;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/22 17:11
 **/
public class P1725 {

//    https://codefun2000.com/p/P1725
//     #P1725. 2024.3.19-得物-第二题-塔子哥的最优选择
    static int n, m;
    static int[] arr;
    static int[] dp;
    static final int INF = 0x3f3f3f3f;

    public static void solve() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        dp = new int[m + 1];
        Arrays.fill(dp, INF);
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        dp[0] = 0;
        for (int i : arr) {
            for (int j = m; j >= i; j--) {
                if (dp[j - i] != INF) dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }
        out.println(dp[m] == INF ? "No solution" : dp[m]);
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
