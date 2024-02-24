package com.fqh.competition.小白赛.ROUND6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/24 18:43
 **/
public class C {


    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        long[] s1 = new long[n+1]; // 正数前缀和
        long[] s2 = new long[n+1]; // 负数前缀和
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + a[i];
            s1[i+1] = s1[i] + (a[i] > 0 ? a[i] : 0);
            s2[i+1] = s2[i] + (a[i] < 0 ? a[i] : 0);
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long v1 = s1[i], v2 = -s2[i];
            if (v1 > v2) {
                ans = v1 - (-v2);
            } else if (v1 < v2) {
                ans = v2 - (-v1);
            } else if (v1 != 0) {
                ans += a[i-1];
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
