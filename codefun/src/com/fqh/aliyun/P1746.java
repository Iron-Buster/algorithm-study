package com.fqh.aliyun;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/26 20:22
 **/
public class P1746 {

//    http://101.43.147.120:8888/p/P1746
//    #P1746. 2024.03.24-阿里云-第一题-塔子哥的彩灯节

    static int n;
    static int[][] a;
    static long[][] dp;

    public static void solve() throws IOException {
        n = in.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[i][0] = x;
            a[i][1] = y;
        }
        dp = new long[n][3];
        for (long[] d : dp) {
            Arrays.fill(d, -1);
        }
        // 简单状态机dp
        // dp[i][0] 表示当前不亮灯的最优解 -> 转移式子 max(dp[i-1][0~2])
        // dp[i][1] 表示当前亮红灯的最优解 -> 转移式子 max(dp[i-1][0], dp[i-1][2]) + a[i][0]
        // dp[i][2] 表示当前亮绿灯的最优解 -> 转移式子 max(dp[i-1][0], dp[i-1][1]) + a[i][1]
        dp[0][0] = 0;
        dp[0][1] = a[0][0];
        dp[0][2] = a[0][1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + a[i][0];
            dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + a[i][1];
        }
        out.println(Math.max(dp[n-1][1], dp[n-1][2]));
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
