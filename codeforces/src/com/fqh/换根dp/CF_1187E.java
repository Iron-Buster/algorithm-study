package com.fqh.换根dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF_1187E {

    static List<Integer>[] g;
    static long[] dp;
    static int[] sz;
    static int n;
    public static void solve() throws IOException {
        // O.o?
        n = in.nextInt();
        g = new List[n];
        dp = new long[n];
        sz = new int[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        out.println(Arrays.stream(dp).max().getAsLong());
    }

    static void dfs(int x, int fa) {
        sz[x] = 1;
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            sz[x] += sz[y];
        }
        dp[0] += sz[x];
    }

    static void dfs2(int x, int fa) {
        for (int y : g[x]) {
            if (y == fa) continue;
            dp[y] = dp[x] - sz[y] + (n - sz[y]);
            dfs2(y, x);
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

