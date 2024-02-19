package com.fqh.brute_force;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/19 12:02
 **/
public class CF_934A {

//    https://codeforces.com/problemset/problem/934/A
//
//    输入 n(2≤n≤50) m(2≤m≤50) 和长为 n 的数组 a，长为 m 的数组 b，元素范围 [-1e9,1e9]。
//
//    你必须恰好删除 a 中的一个数字。
//    最小化 a[i] * b[j] 的最大值。
//    输出这个最大值。

//    输入
//        2 2
//        20 18
//        2 14
//    输出 252

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        for (int i = 0; i < m; i++) b[i] = in.nextLong();
        long ans = Long.MAX_VALUE;
        // n和m比较小，暴力枚举删除a中的每一个元素
        for (int i = 0; i < n; i++) {
            long v = Long.MIN_VALUE;
            for (int k = 0; k < n; k++) {
                if (k == i) continue;
                for (int j = 0; j < m; j++) {
                    v = Math.max(v, a[k] * b[j]);
                }
            }
            ans = Math.min(ans, v);
        }
        out.println(ans);
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
