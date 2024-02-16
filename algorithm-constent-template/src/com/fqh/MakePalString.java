package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/16 21:53
 **/
public class MakePalString {

    /**
     * 给定一个字符串
     * 求最少去掉几个字符，才能变为回文串
     * case1: abcd -> 3
     * case2: bcba -> 1
     */

    public static void solve() throws IOException {
        // dp
        // s[l] == s[r] --> f[l][r] = min(f[l+1][r-1])
        // s[l] != s[r] --> f[l][r] = min(f[l+1][r],f[l][r-1]) + 1
        // ans -> f[0][n-1]
        String s = in.nextLine();

        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int l = 0, r = i; r < n; l++, r++) {
                if (s.charAt(l) == s.charAt(r)) {
                    f[l][r] = f[l+1][r-1];
                } else {
                    f[l][r] = Math.min(f[l+1][r], f[l][r-1]) + 1;
                }
            }
        }
        out.println(f[0][n-1]);
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
