package com.fqh._2023_11;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/13 12:38
 * @Version V1.0
 */
public class CF_1648A {

//    https://codeforces.com/problemset/problem/1648/A
//
//    输入 n m (1≤n*m≤1e5) 和 n 行 m 列的矩阵 a，元素范围 [1,1e5]。
//    对于矩阵中的所有相同元素对，即满足 a[x1][y1] = a[x2][y2] 的元素对 (a[x1][y1], a[x2][y2])，把 abs(x1-x2) + abs(y1-y2) 加到答案中。
//    注意 (a,b) 和 (b,a) 只算一次。
//    输出答案。

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        var map = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = in.nextInt();
                List<int[]> l =  map.getOrDefault(v, new ArrayList<>());
                l.add(new int[]{i, j});
                map.put(v, l);
            }
        }
        long ans = 0;
        for (List<int[]> l : map.values()) {
            l.sort(Comparator.comparingInt(a -> a[0]));
            long pre = 0;
            for (int i = 0; i < l.size(); ++i) {
                ans += (long) l.get(i)[0] * i - pre;
                pre += l.get(i)[0];
            }
            l.sort(Comparator.comparingInt(a -> a[1]));
            pre = 0;
            for (int i = 0; i < l.size(); ++i) {
                ans += (long) l.get(i)[1] * i - pre;
                pre += l.get(i)[1];
            }
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
