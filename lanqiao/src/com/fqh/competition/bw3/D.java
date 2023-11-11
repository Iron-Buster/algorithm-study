package com.fqh.competition.bw3;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/11 18:50
 * @Version V1.0
 */
public class D {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;
    static int[][] mat;
    static long[][][] f;
    static int[][] dirs = {{1, 0}, {0, 1}};

    static long gcd(long a, long b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    static long dfs(int i, int j, int k) {
        long ans = Long.MIN_VALUE;
        if (i == n - 1 && j == m - 1) return mat[i][j];
        if (f[i][j][k] != -1) return f[i][j][k];
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                if (gcd(mat[i][j], mat[x][y]) == 1) {
                    if (k > 0) {
                        long sub = dfs(x, y, k - 1);
                        if (sub != Long.MIN_VALUE) ans = Math.max(sub + mat[i][j], ans);
                    }
                } else {
                    long sub = dfs(x, y, k);
                    if (sub != Long.MIN_VALUE) ans = Math.max(sub + mat[i][j], ans);
                }
            }
        }
        return f[i][j][k] = ans;
    }

    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        mat = new int[n][m];
        f = new long[n][m][k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                mat[i][j] = in.nextInt();
                Arrays.fill(f[i][j], -1);
            }
        }
        long ans = dfs(0, 0, k);
        if (ans <= 0) ans = -1;
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
