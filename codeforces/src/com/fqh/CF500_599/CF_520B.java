package com.fqh.CF500_599;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/1 14:26
 * @Version V1.0
 */
public class CF_520B {
//    B. Two Buttons
//    瓦夏发现了一个奇怪的装置。设备前面板上有一个红色按钮、一个蓝色按钮和一个显示正整数的显示屏。
//    点击红色按钮后，设备将显示的数字乘以 2。点击蓝色按钮后，设备从显示屏上的数字中减去 1。
//    如果某个时候数字不再是正数，设备就会崩溃。显示屏可以显示任意大的数字。最初，显示屏上显示的数字是 n 。
//    鲍勃希望在显示屏上显示数字 m 。他最少要点击几次才能达到这个结果？


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    //BFS
    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        if (n >= m) {
            out.println(n - m);
            return;
        }
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{n, 0});
        int ans = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cur = p[0], step = p[1];
            if (cur == m) {
                ans = step;
                break;
            }
            if (cur - 1 >= 0 && !vis[cur]) {
                q.offer(new int[]{cur - 1, step + 1});
            }
            if (cur <= 2 * m && cur != 0 && !vis[cur]) {
                q.offer(new int[]{cur * 2, step + 1});
            }
            vis[cur] = true;
        }
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
