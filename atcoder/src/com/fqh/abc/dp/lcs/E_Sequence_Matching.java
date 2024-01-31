package com.fqh.abc.dp.lcs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/31 12:22
 **/
public class E_Sequence_Matching {

//    https://atcoder.jp/contests/abc185/tasks/abc185_e
//
//    输入 n(≤1000) 和 m(≤1000)，长度分别为 n 和 m 的数组 a 和 b，元素范围 [1,1e9]。
//    从 a 中移除若干元素，得到一个子序列 a'；从 b 中移除若干元素，得到一个子序列 b'。
//    要求 a' 和 b' 的长度相同。
//    输出 (a和b总共移除的元素个数) + (a'[i]≠b'[i]的i的个数) 的最小值。

//    输入
//        4 3
//        1 2 1 3
//        1 3 1
//    输出 2

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n+1];
        long[] b = new long[m+1];
        for (int i = 1; i <= n; i++) a[i] = in.nextLong();
        for (int i = 1; i <= m; i++) b[i] = in.nextLong();;
        long[][] f = new long[n+1][m+1];
        for (int i = 1; i <= n; i++) f[i][0] = i;
        for (int j = 1; j <= m; j++) f[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long v1 = f[i-1][j] + 1;
                long v2 = f[i][j-1] + 1;
                long v3 = f[i-1][j-1] + (a[i] == b[j] ? 0 : 1);
                f[i][j] = Math.min(Math.min(v1, v2), v3);
            }
        }
        out.println(f[n][m]);
    }

    static boolean MULTI_CASE = false;
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
