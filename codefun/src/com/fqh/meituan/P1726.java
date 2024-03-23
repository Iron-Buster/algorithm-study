package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/23 17:12
 **/
public class P1726 {

    //https://codefun2000.com/p/P1726
    // #P1726. 2024.3.23-美团-第一题-塔子哥的01矩阵

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLine().toCharArray();
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int cnt0 = 0, cnt1 = 0;
                for (char x : new char[]{a[i][j], a[i-1][j-1], a[i-1][j], a[i][j-1]}) {
                    if (x == '0') cnt0++;
                    else cnt1++;
                }
                if (cnt0 == cnt1) ans++;
            }
        }
        out.println(ans);
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
