package com.fqh.abc.abc_328;

import java.io.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/12 16:29
 * @Version V1.0
 */
public class D {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        var s = in.nextLine();
        var cs = s.toCharArray();
        var stk = new ArrayDeque<Character>();
        for (char c : cs) {
            stk.push(c);
            if (stk.size() >= 3) {
                var p1 = stk.pop();
                var p2 = stk.pop();
                var p3 = stk.pop();
                if (p1 == 'C' && p2 == 'B' && p3 == 'A') {

                } else {
                    stk.push(p3);
                    stk.push(p2);
                    stk.push(p1);
                }
            }
        }
        var sb = new StringBuilder();
        int n = stk.size();
        for (int i = 0; i < n; ++i) {
            sb.append(stk.pollLast());
        }
        out.println(sb);
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
