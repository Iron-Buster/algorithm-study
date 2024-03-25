package com.fqh.didi;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/25 10:58
 **/
public class P1734 {

    //#P1734. 2024.03.24-滴滴春招-第二题-塔子哥的网格配送
    //https://codefun2000.com/p/P1734
    static int n, m;
    static char[][] g;
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int bfs(int sx, int sy, int ex, int ey) {
        boolean[][] vis = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], step = p[2];
            if (x == ex && y == ey) return step;
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == '#') continue;
                if (!vis[nx][ny]) {
                    q.offer(new int[]{nx, ny, step + 1});
                    vis[nx][ny] = true;
                }
            }
        }
        return 0;
    }

    public static void solve() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = in.nextLine().toCharArray();
        }
        String p = in.nextLine();
        String[] s = p.split(" ");
        int x1 = Integer.parseInt(s[0]) - 1, y1 = Integer.parseInt(s[1]) - 1;
        int x2 = Integer.parseInt(s[2]) - 1, y2 = Integer.parseInt(s[3]) - 1;
        int x3 = Integer.parseInt(s[4]) - 1, y3 = Integer.parseInt(s[5]) - 1;
        int ans = bfs(x1, y1, x2, y2) + bfs(x2, y2, x3, y3);
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
