package com.fqh.div3.ROUND_916;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/19 22:24
 * @Version V1.0
 */
public class A {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        n = in.nextInt();
        String ss = in.nextLine();
        char[] s = ss.toCharArray();
        var map = new HashMap<Character, Integer>();
        for (char x : s) {
            map.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        var set = new HashSet<Character>();
        for (int i = 0; i < s.length; i++) {
            if (set.contains(s[i])) continue;
            if (map.getOrDefault(s[i], 0) >= s[i] - 'A' + 1) {
                ans++;
                set.add(s[i]);
            }
        }
        out.println(ans);
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
