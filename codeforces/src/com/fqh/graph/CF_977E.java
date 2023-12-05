package com.fqh.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/5 17:38
 * @Version V1.0
 */
public class CF_977E {


//    题意：给你n个顶点，m条边，求单圈环的个数。（只有一个圈的环）
//
//    题解：通过观察发现单圈环里的顶点的度都为2，所以并查集找连通图，map存顶点度数，遍历查找单圈环。

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (a < b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
        }
    }

    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        int[] rd = new int[n + 1];
        var u = new UnionFind(n);
        while (m-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            u.merge(x, y);
            rd[x]++;
            rd[y]++;
        }
        var groups = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= n; ++i) {
            int fa = u.find(i);
            groups.computeIfAbsent(fa, v -> new ArrayList<>());
            groups.get(fa).add(i);
        }
        int ans = 0;
        for (List<Integer> g : groups.values()) {
            if (g.size() <= 2) { // 连通图至少要有3个点
                continue;
            }
            boolean ok = true;
            for (int x : g) {
                // 只要有一个度不为2就跳出
                if (rd[x] != 2) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        }
        out.println(ans);
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
