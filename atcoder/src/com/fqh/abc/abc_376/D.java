package com.fqh.abc.abc_376;

import java.io.*;
import java.util.*;

public class D {
    // https://atcoder.jp/contests/abc376/tasks/abc376_d
    // 思路: 把两个点之间的边权看做1，终点看作0，其实就是求1-0的一条最短路
    // 注意v=1的才能被当作0，题目要求包含1的环。
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        List<int[]>[] g = new List[n + 10];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (v == 1) {
                v = 0;
            }
            g[u].add(new int[]{v, 1});
        }
        int[] dist = new int[n + 1];
        dijkstra0(1, 0, g, dist);
        out.println(dist[0] == Integer.MAX_VALUE ? -1 : dist[0]);
    }

    static void dijkstra0(int start, int end, List<int[]>[] g, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        boolean[] vis = new boolean[g.length];
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int u = p[0];
            if (u == end) return;
            if (vis[u]) continue;
            vis[u] = true;
            for (int[] next : g[u]) {
                int v = next[0], w = next[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
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
