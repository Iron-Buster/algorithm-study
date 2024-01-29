package com.fqh.contest.ROUND_30;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/29 15:25
 **/
public class E {

    static final int MOD = (int) (1e9 + 7);
    static List<Integer>[] g;
    static long[][] f = new long[100001][2];

    static void dfs(int x, int fa) {
        f[x][0] = f[x][1] = 1;
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            f[x][0] = f[x][0] * f[y][1] % MOD;
            f[x][1] = f[x][1] * (f[y][0] + f[y][1]) % MOD;
        }
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        g = new List[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        dfs(1, 0);
        out.println((f[1][0] + f[1][1]) % MOD);
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
