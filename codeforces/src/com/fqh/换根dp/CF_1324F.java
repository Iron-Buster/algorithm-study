package com.fqh.换根dp;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF_1324F {
    // https://codeforces.com/problemset/problem/1324/F
    static List<Integer>[] g;
    static int[] dp;
    static int[] a;

    public static void solve() throws IOException {
        int n = in.nextInt();
        a = new int[n];
        g = new List[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            int c = in.nextInt();
            a[i] = c == 1 ? 1 : -1;
        }
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        for (int v : dp) {
            out.print(v + " ");
        }
        out.println();
    }

    static void dfs(int x, int fa) {
        dp[x] = a[x];
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            if (dp[y] > 0) {
                dp[x] += dp[y];
            }
        }
    }
    // f[x] -> f[y]
    // 1.f[y]给f[x]贡献了, f[y] = max(f[y], f[x])
    // 2.f[y]没给f[x]贡献, f[y] = max(f[y], f[y] + f[x])
    static void dfs2(int x, int fa) {
        for (int y : g[x]) {
            if (y == fa) continue;
            if (dp[y] > 0) {
                dp[y] = Math.max(dp[y], dp[x]);
            } else {
                dp[y] = Math.max(dp[y], dp[y] + dp[x]);
            }
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
