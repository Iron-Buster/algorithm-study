package com.fqh.abc.abc_384;


import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void solve() throws IOException {
        int m = in.nextInt();
        int n = in.nextInt();
        long X = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        long[][] a = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextLong();
            }
        }
        var vis = new boolean[m][n];
        p--; q--;
        var pq = new PriorityQueue<long[]>(((o1, o2) -> Long.compare(o1[2], o2[2])));
        pq.offer(new long[]{p, q, 0});
        vis[p][q] = true;
        long nowSize = a[p][q];
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int x = (int) cur[0];
            int y = (int) cur[1];
            long size = cur[2];
            long k = (nowSize + X - 1) / X;
            if (size >= k) break;
            nowSize += size;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny]) {
                    pq.offer(new long[]{nx, ny, a[nx][ny]});
                    vis[nx][ny] = true;
                }
            }
        }
        out.println(nowSize);
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
