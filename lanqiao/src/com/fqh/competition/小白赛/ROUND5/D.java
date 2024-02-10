package com.fqh.competition.小白赛.ROUND5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/10 22:28
 **/
public class D {

    static int n;
    static int[] a;

    // 交换后的数组只有两种情况
    // 1.以0开头 1结尾 （奇数下标放0，偶数下标放1）
    // 2.以1开头 0结尾 （奇数下标放1，偶数下标放0）
    static int f(int x) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                if (a[i] != x) ans++;
            } else {
                if (a[i] == x) ans++;
            }
        }
        return ans / 2;
    }
    public static void solve() throws IOException {
        n = in.nextInt();
        a = new int[n * 2];
        for (int i = 0; i < n * 2; i++) a[i] = in.nextInt();
        out.println(Math.min(f(0), f(1)));
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
