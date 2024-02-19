package com.fqh.div4.ROUND_928;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/19 18:20
 **/
public class C {
    // 预处理出1-2e5的所有数位和 递推式：dp[i] = dp[i-1] + f(i)
    static int MAX = (int) 2e5;
    static long[] dp = new long[MAX + 10];
    static {
        for (int i = 1; i <= MAX; i++) {
            dp[i] = dp[i-1] + f(i);
        }
    }

    static int f(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        out.println(dp[n]);
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
