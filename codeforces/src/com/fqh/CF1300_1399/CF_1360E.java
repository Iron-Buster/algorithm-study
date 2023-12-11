package com.fqh.CF1300_1399;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/1 15:34
 * @Version V1.0
 */
public class CF_1360E {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        n = in.nextInt();
        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextIntArray();
        }
        boolean ok = true;
        for (int i = 1; i <= n - 1; ++i) {
            for (int j = 1; j <= n - 1; ++j) {
                if (a[i][j] == 1 && a[i + 1][j] != 1 && a[i][j + 1] != 1) {
                    ok = false;
                    break;
                }
            }
        }
        if (ok) out.println("YES");
        else out.println("NO");
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

        public int[] nextIntArray() throws IOException {
            String s = in.nextLine();
            int[] arr = new int[s.length() + 1];
            for (int i = 0; i < s.length(); ++i) {
                arr[i + 1] = s.charAt(i) - '0';
            }
            return arr;
        }
    }
}
