package com.fqh._2023_11;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/9 9:34
 * @Version V1.0
 */
public class CF_1140C {


//    https://codeforces.com/problemset/problem/1140/C
//
//    输入 n k(1≤k≤n≤3e5) 和 n 个物品，每个物品输入两个属性值 t[i] 和 b[i]，范围 [1,1e6]。
//    从这 n 个物品中选出至多 k 个物品，输出这 k 个物品的 sum(t) * min(b) 的最大值。

//    输入
//        4 3
//        4 7
//        15 1
//        3 6
//        6 8
//    输出 78
//
//    输入
//        5 3
//        12 31
//        112 4
//        100 100
//        13 55
//        55 50
//    输出 10000

//    按照 b 从大到小排序，这样可以枚举最小的 b。把当前的 t 和左边的 t 都加到一个最小堆中，从而维护堆中最大的 k 个数的和。
//
//    https://codeforces.com/contest/1140/submission/231732136

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        n = in.nextInt();
        int k = in.nextInt();
        int[][] tt = new int[n + 1][2];
        for (int i = 1; i <= n; ++i) {
            String[] ss = in.nextLine().split(" ");
            tt[i][0] = Integer.parseInt(ss[0]);
            tt[i][1] = Integer.parseInt(ss[1]);
        }
        Arrays.sort(tt, 1, 1 + n, (a, b) ->  b[1] - a[1]);
        var pq = new PriorityQueue<Integer>((a, b) -> a - b);
        long ans = 0;
        long sum = 0;
        for (int i = 1; i <= n; ++i) {
            pq.offer(tt[i][0]);
            sum += tt[i][0];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            ans = Math.max(ans, tt[i][1] * sum);
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
