package com.fqh.EDU.div2_ROUND160;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/19 16:20
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

//  input
//            4
//            0
//            011
//            0101110001
//            111100
//            100111
//            map[1] = 3, map[0] = 2
//            111100
//            001100

//   output
//            1
//            1
//            0
//            4


    static void solve() throws Exception {
        String ss = in.nextLine();
        char[] s = ss.toCharArray();
        int[] map = new int[100];
        for (char x : s) {
            map[x]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '1') {
                if (map['0'] > 0) {
                    map['0']--;
                    sb.append('0');
                } else {
                    map['1']--;
                    sb.append('1');
                }
            } else {
                if (map['1'] > 0) {
                    map['1']--;
                    sb.append('1');
                } else {
                    map['0']--;
                    sb.append('0');
                }
            }
        }
        int ans = 0;
        for (int i = 0, j = 0; i < s.length && j < sb.length(); ) {
            if (s[i] != sb.charAt(j)) {
                i++;
                j++;
            } else {        // 代表这个位置要删除
                j++;
                ans++;
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
