package com.fqh.div3.ROUND_916;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/19 22:25
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
        int n = in.nextInt();
        int k = in.nextInt();
        if (k == 0) {
            for (int i = n; i >= 1; i--) {
                out.print(i + " ");
            }
        } else if (k == n - 1) {
            for (int i = 1; i <= n; i++) {
                out.print(i + " ");
            }
        } else {
            // 前k个递增，然后全部递减
            for (int i = n - k; i <= n; i++) {
                out.print(i + " ");
            }
            for (int i = n - k - 1; i >= 1; i--) {
                out.print(i + " ");
            }
        }
        out.println();
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
