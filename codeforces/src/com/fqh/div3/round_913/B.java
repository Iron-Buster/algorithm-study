package com.fqh.div3.round_913;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/6 10:22
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
        String ss = in.nextLine();
        char[] s = ss.toCharArray();
        var q1 = new ArrayDeque<Integer>();
        var q2 = new ArrayDeque<Integer>();
        var ans = new ArrayList<Character>();
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == 'b') {
                ans.add('*');
                if (q1.size() > 0) {
                    int idx = q1.pollLast();
                    ans.set(idx, '*');
                }
            } else if (s[i] == 'B') {
                ans.add('*');
                if (q2.size() > 0) {
                    int idx = q2.pollLast();
                    ans.set(idx, '*');
                }
            } else {
                ans.add(s[i]);
                if (s[i] >= 'a' && s[i] <= 'z') { // 小写
                    q1.addLast(i);
                } else {                          // 大写
                    q2.addLast(i);
                }
            }
        }
        for (int i = 0; i < ans.size(); ++i) {
            if (ans.get(i) != '*') {
                out.print(ans.get(i));
            }
        }
        out.println();
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
