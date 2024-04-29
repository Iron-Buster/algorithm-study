package com.fqh.abc.abc_351;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/29 22:30
 **/
public class D {

    static int m, n;
    static char[][] g;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] vis;

    // check是否周围存在#
    public static boolean check(int x, int y) {
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (g[nx][ny] == '#') {
                return true;
            }
        }
        return false;
    }
    public static int bfs(int i, int j) {
        var q = new ArrayDeque<int[]>();
        var vis = new boolean[m][n];
        q.addLast(new int[]{i, j});
        vis[i][j] = true;
        int res = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            if (check(x, y)) {
                vis[x][y] = true;
                continue;
            }
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void solve() throws IOException {
        m = in.nextInt();
        n = in.nextInt();
        g = new char[m][n];
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            g[i] = in.nextLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '.') ans = 1;
                if (g[i][j] == '#') {
                    for (int[] d : dirs) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        vis[nx][ny] = true;
                    }
                    vis[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) continue;
                if (g[i][j] == '.') {
                    ans = Math.max(ans, 1);
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        out.println(ans);
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
