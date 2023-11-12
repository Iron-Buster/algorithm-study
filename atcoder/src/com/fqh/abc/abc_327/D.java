package com.fqh.abc.abc_327;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/5 18:00
 * @Version V1.0
 */
public class D {

    /**
     * 给定一个数组 S 和一个数组 T 长度都为 M。
     * 问是否存在一个长度为 N的 01 数组 X
     * 使得X_si
     *
     */


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static int[] fa;
    static int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }
    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        fa = new int[2 * n + 1];
        for (int i = 1; i <= m; ++i) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= m; ++i) {
            b[i] = in.nextInt();
        }
        for (int i = 1; i <= 2 * n; ++i) fa[i] = i;
        for (int i = 1; i <= m; ++i) {
            int x = a[i], y = b[i];
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                out.println("No");
                return;
            }
            fa[fx] = find(y + n);
            fa[fy] = find(x + n);
        }
        out.println("Yes");
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
