package com.fqh.abc.abc_327;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/4 19:58
 * @Version V1.0
 */
public class B {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        long B = in.nextLong();
        var x = BigDecimal.valueOf(B);
        for (int i = 1; i <= 100; ++i) {
            BigDecimal v = BigDecimal.valueOf(i);
            v = v.pow(v.intValue());
            if (v.compareTo(x) == 0) {
                out.println(i);
                return;
            }

        }
        out.println(-1);
    }

    // 求 m^k mod p 时间复杂度 O(logk)
    static double fastPow(double m, long k) {
        if (k < 0) {
            k = -k;
            m = 1 / m;
        }
        double ans = 1, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = ans * t;
            }
            t = t * t;
            k >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
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
