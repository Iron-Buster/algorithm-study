package com.fqh.graph;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/7 17:29
 * @Version V1.0
 */
public class CF_1167C {

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    /**
     * 并查集
     */
    static class UnionFind {
        private int[] parent;
        private int count;
        private int[] size;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            this.count = n;
            for (int i = 1; i <= n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            if (size[aRoot] > size[bRoot]) {
                parent[bRoot] = aRoot;
                size[aRoot] += size[bRoot];
            } else {
                parent[aRoot] = bRoot;
                size[bRoot] += size[aRoot];
            }
            count--;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }

        public int getSize(int x) {
            return size[x];
        }
    }

    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        var uf = new UnionFind(n);
        for (int i = 1; i <= m; ++i) {
            int[] a = in.nextArr();
            for (int j = 2; j < a.length; ++j) {
                uf.union(a[1], a[j]);  // 将同一组的合并
            }
        }
        for (int i = 1; i <= n; i++) {
            int fa = uf.find(i);
            out.print(uf.getSize(fa) + " ");
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

        public int[] nextArr() throws IOException {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int[] arr = new int[ss.length];
            for (int i = 0; i < ss.length; ++i) {
                arr[i] = Integer.parseInt(ss[i]);
            }
            return arr;
        }
    }
}
