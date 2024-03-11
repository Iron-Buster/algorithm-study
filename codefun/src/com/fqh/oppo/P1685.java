package com.fqh.oppo;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 16:59
 **/
public class P1685 {

    // #P1685. 2024.3.9oppo-第一题-小欧的商品
    // https://codefun2000.com/p/P1685

    public static void solve() throws IOException {
        int n = in.nextInt();
        int x = in.nextInt();
        PII[] p = new PII[n];
        for (int i = 0; i < n; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            p[i] = new PII(v1, v2);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i].first > x) continue;
            ans += p[i].second;
            x -= (int) p[i].first;
        }
        out.println(ans);
    }

    static class PII {
        long first;
        long second;

        public PII(long first, long second) {
            this.first = first;
            this.second = second;
        }
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
