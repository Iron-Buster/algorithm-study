package com.fqh.abc.abc_327;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/4 19:58
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

    static void solve() throws Exception {
        var arr = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            arr[i] = in.nextIntArr();
        }
        // 每一行
        for (int i = 0; i < 9; ++i) {
            var set = new HashSet<Integer>();
            for (int j = 0; j < 9; ++j) {
                set.add(arr[i][j]);
            }
            if (set.size() != 9) {
                out.println("No");
                return;
            }
        }
        // 每一列
        for (int j = 0; j < 9; ++j) {
            var set = new HashSet<Integer>();
            for (int i = 0; i < 9; ++i) {
                set.add(arr[i][j]);
            }
            if (set.size() != 9) {
                out.println("No");
                return;
            }
        }
        for (int i = 1; i < 8; i += 3) {
            for (int j = 1; j < 8; j += 3) {
                int x = arr[i][j];
                if (arr[i - 1][j - 1] == x || arr[i - 1][j] == x || arr[i - 1][j + 1] == x
                    || arr[i][j - 1] == x || arr[i][j + 1] == x || arr[i + 1][j + 1] == x
                        || arr[i + 1][j - 1] == x || arr[i + 1][j] == x) {
                    out.println("No");
                    return;
                }
            }
        }
        out.println("Yes");
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

        public int[] nextIntArr() throws IOException {
            String[] ss = nextLine().split(" ");
            int[] arr = new int[ss.length];
            for (int i = 0; i < ss.length; ++i) {
                arr[i] = Integer.parseInt(ss[i]);
            }
            return arr;
        }
    }
}
