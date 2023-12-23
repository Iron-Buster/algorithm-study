package com.fqh.competition.小白赛.ROUND2;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/23 18:57
 * @Version V1.0
 */
public class B {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;


    static void solve() throws Exception {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Pair> list = new ArrayList<>();
        while (m-- > 0) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            long x = Integer.parseInt(ss[0]);
            long y = Integer.parseInt(ss[1]);
            list.add(new Pair(x, y));
        }
        Collections.sort(list, (a, b) -> {
            if (a.x != b.x) {
                return Long.compare(a.x, b.x);
            }
            return Long.compare(a.y, b.y);
        });
        Pair p1 = list.get(0);
        Pair p2 = list.get(list.size() - 1);
        if (p2.x == n) p2.y = n;
        else if (p2.y == n) p2.x = n;
        double k = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        out.println("k >>>>>>>>>" + Math.sqrt(k));
        out.println((int) Math.ceil(Math.sqrt(k)));
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
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
