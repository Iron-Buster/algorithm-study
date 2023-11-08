package com.fqh.graph;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/8 23:09
 * @Version V1.0
 */
public class CF_1196F {

    /* 第k小路径 https://codeforces.com/problemset/problem/1196/F */
    static class Edge {
        int u, v;
        long w;
        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    private static Edge[] edges;
    private static Map<Integer, Integer> mp;
    private static int cnt = 0;
    private static long[][] dis;

    public static void init() {
        for (int i = 1; i <= cnt; ++i) {
            for (int j = 1; j <= cnt; ++j) {
                if (i == j) continue;
                if (dis[i][j] == 0) dis[i][j] = (long) 1e16;
            }
        }
    }

    public static void work() {
        for (int i = 1; i <= cnt; ++i) {
            for (int j = 1; j <= cnt; ++j) {
                for (int k = 1; k <= cnt; ++k) {
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }
    }
    public static void findKthPath(int n, int m, int k) throws IOException {
        cnt = 0;
        mp = new HashMap<>();
        dis = new long[1010][1010];
        edges = new Edge[m + 1];
        for (int i = 1; i <= m; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges, 1, m + 1, (a, b) -> Long.compare(a.w, b.w));
        for (int i = 1; i <= m; ++i) {
            if (!mp.containsKey(edges[i].u)) {
                mp.put(edges[i].u, ++cnt);
            }
            if (!mp.containsKey(edges[i].v)) {
                mp.put(edges[i].v, ++cnt);
            }
            int u = mp.get(edges[i].u);
            int v = mp.get(edges[i].v);
            long w = edges[i].w;
            if (dis[u][v] == 0) {
                dis[u][v] = dis[v][u] = (long) 1e16;
            }
            dis[u][v] = dis[v][u] = Math.min(dis[u][v], w);
            if (i >= k) break;
        }
        init();
        work();
        List<Long> ans = new ArrayList<>();
        for (int i = 1; i <= cnt; ++i) {
            for (int j = i + 1; j <= cnt; ++j) {
                if (dis[i][j] == 0 || dis[i][j] == 1e16) continue;
                ans.add(dis[i][j]);
            }
        }
        Collections.sort(ans);
        out.println(ans.get(k - 1));
    }


    static void solve() throws Exception {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        findKthPath(n, m, k);

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
