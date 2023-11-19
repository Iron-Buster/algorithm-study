package com.fqh.abc.abc_329;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/18 20:38
 * @Version V1.0
 */
public class F {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

//    启发式合并就是一个比较经典的算法，并且复杂度式有保证的。
//    启发式合并就是在合并的时候将size小的那个集合合并到size大的那个集合里面。

    static void solve() throws Exception {
        int n = in.nextInt();
        int q = in.nextInt();
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 1; i <= n; ++i) {
            int x = in.nextInt();
            map.computeIfAbsent(i, v -> new HashSet<>());
            map.get(i).add(x);
        }
        while (q-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            // swap
            if (map.get(x).size() > map.get(y).size()) {
                var temp = map.get(y);
                map.put(y, map.get(x));
                map.put(x, temp);
            }
            for (int i : map.get(x)) {
                map.get(y).add(i);
            }
            map.get(x).clear();
            out.println(map.get(y).size());
        }
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
