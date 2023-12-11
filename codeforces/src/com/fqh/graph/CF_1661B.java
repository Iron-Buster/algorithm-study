package com.fqh.graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/5 18:05
 * @Version V1.0
 */
public class CF_1661B {

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static final int MOD = 32768;

    static int bfs(int x) {
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{x, 0});
        while (!q.isEmpty()) {
            var p = q.poll();
            int cur = p[0], step = p[1];
            if (cur == 0) return step;
            int next1 = (cur + 1) % MOD;
            if (!vis[next1]) {
                q.offer(new int[]{next1, step + 1});
            }
            int next2 = 2 * cur % MOD;
            if (!vis[next2]) {
                q.offer(new int[]{next2, step + 1});
            }
            vis[cur] = true;
        }
        return -1;
    }

    static void solve() throws Exception {
        n = in.nextInt();
        while (n-- > 0) {
            int x = in.nextInt();
            out.print(bfs(x) + " ");
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
