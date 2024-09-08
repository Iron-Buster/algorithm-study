package com.fqh;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_2008E {

//    https://codeforces.com/contest/2008/problem/E

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = in.nextLine().chars().map(x -> x - 'a').toArray();
        if (n % 2 == 0) {
            int[][] g = new int[2][26];
            for (int i = 0; i < n; i++) g[i % 2][a[i]]++;
            int v1 = Arrays.stream(g[0]).max().getAsInt();
            int v2 = Arrays.stream(g[1]).max().getAsInt();
            out.println(n - v1 - v2);
        } else {
            // 枚举删除 i
            // abcdefg
            // 010 010
            // 0101 10
            int[][] g1 = new int[2][26];
            int[][] g2 = new int[2][26];
            for (int i = 0; i < n; i++) g2[i % 2][a[i]]++;
            int res = n;
            for (int i = 0; i < n; i++) {
                g2[i % 2][a[i]]--;
                int m1 = 0, m2 = 0;
                for (int j = 0; j < 26; j++) {
                    // 删除i后，右边的奇偶性变化
                    // m1:左边的偶数 + 右边的偶数
                    // m2:左边的奇数 + 右边的奇数
                    m1 = Math.max(m1, g1[0][j] + g2[1][j]);
                    m2 = Math.max(m2, g1[1][j] + g2[0][j]);
                }
                res = Math.min(res, n - m1 - m2);
                g1[i % 2][a[i]]++;
            }
            out.println(res);
        }
    }

    static boolean MULTI_CASE = true;

    public static void main(String[] args) throws Exception {
        int T = MULTI_CASE ? in.nextInt() : 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
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
