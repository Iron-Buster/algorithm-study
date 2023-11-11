package com.fqh.competition.bw3;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/11 18:49
 * @Version V1.0
 */
public class C {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static int[] map1;


    static void solve() throws Exception {
        String s = in.nextLine();
        String[] ss = s.split(" ");
        if (ss[0].equals("MF") || (ss[0].length() == 2 && ss[0].charAt(0) == ss[0].charAt(1))) {
            out.println("ShallowDream");
            return;
        }
        int cnt1 = ss[0].length();
        int cnt2 = ss[1].length();
        int i = ss[1].indexOf('M');
        if (i != -1 && cnt1 == cnt2) {
            out.println("Joker");
            return;
        }
        while (cnt1 > 0 && cnt2 > 0) {

        }
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
