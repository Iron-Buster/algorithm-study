package com.fqh._2023_11;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/7 12:57
 * @Version V1.0
 */
public class CF_1106D {

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

//    https://codeforces.com/problemset/problem/1106/D
//
//    输入 n m(1≤n,m≤1e5) 和一个无向图的 m 条边。节点编号从 1 开始。
//    你从 1 出发，沿着边在图上行走，每遇到一个之前没有访问过的点，就把这个点的编号记录下来。你可以重复访问节点。
//    这个过程直到你记录了 n 个节点编号时停止。
//    输出这 n 个数的最小字典序。


//    用最小堆模拟。
//
//    一开始把 1 入堆，然后每次循环把最小节点 x 出堆，并把 x 的邻居入堆。
//    用一个 vis 数组避免重复访问。
//
//    注：这个过程有点像 Dijkstra。
//
//    https://codeforces.com/contest/1106/submission/231063593


    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        g = new List[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        var pq = new PriorityQueue<Integer>((a, b) -> a - b);
        pq.offer(1);
        vis[1] = true;
        var path = new StringBuilder();
        while (!pq.isEmpty()) {
            int x = pq.poll();
            path.append(x).append(" ");
            for (int y : g[x]) {
                if (vis[y]) continue;
                pq.offer(y);
                vis[y] = true;
            }
        }
        out.println(path.toString().trim());
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
