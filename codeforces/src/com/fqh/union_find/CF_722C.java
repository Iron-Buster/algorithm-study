package com.fqh.union_find;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/24 18:31
 * @Version V1.0
 */
public class CF_722C {
    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static class InReverseUnionFind {
        int[] fa;
        long[] sum;      // sum[i]表示第i个集合的和
        boolean[] vis;  // 标记第i个数是否已添加

        public InReverseUnionFind(int n) {
            this.fa = new int[n + 1]; // n大小从1开始 -> n+1
            this.sum = new long[n + 1];
            this.vis = new boolean[n + 1];
            for (int i = 1; i <= n; ++i) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int x, int y) {
            int f_x = find(x);
            int f_y = find(y);
            if (f_x != f_y) {
                fa[f_y] = f_x;
                sum[f_x] += sum[f_y];
            }
        }
    }

    static void solve() throws Exception {
        n = in.nextInt();
        var u = new InReverseUnionFind(n);
        for (int i = 1; i <= n; ++i) {
            u.sum[i] = in.nextInt();
        }
        int[] queries = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            queries[i] = in.nextInt();
        }
        long[] res = new long[n + 1];
        long ans = 0;
        for (int i = n; i >= 1; --i) {
            res[i] = ans;
            int q = queries[i];
            u.vis[q] = true;
            if (q - 1 >= 1 && u.vis[q - 1]) {
                u.merge(q, q - 1);
            }
            if (q + 1 <= n && u.vis[q + 1]) {
                u.merge(q, q + 1);
            }
            ans = Math.max(ans, u.sum[u.find(q)]);
        }
        for (int i = 1; i <= n; ++i) {
            out.println(res[i]);
        }
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
