package com.fqh.binary_search;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/21 10:37
 **/
public class CF_1198B {

//    https://codeforces.com/problemset/problem/1198/B
//
//    输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)，下标从 1 开始。
//    然后输入 q(1≤n≤2e5) 和 q 个操作。
//
//    有两种操作：
//            "1 p x"：将 a[p] 变为 x。
//            "2 x"：将所有小于 x 的数变为 x。
//    其中 0≤x≤1e9。
//
//    输出所有操作完成后的数组 a。

    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int q = in.nextInt();
        int[] changeTime = new int[n]; // changeTime[i]表示 下标i最后一次修改的值
        int[] sufMax = new int[n];
        for (int t = 0; t < q; t++) {
            long op = in.nextLong();
            if (op == 1) {
                int p = in.nextInt();
                int x = in.nextInt();
                p--;
                a[p] = x;
                changeTime[p] = t;
            } else {
                int x = in.nextInt();
                sufMax[t] = x;
            }
        }
        for (int i = q - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i], sufMax[i+1]);
        }
        for (int i = 0; i < n; i++) {
            out.print(Math.max(a[i], sufMax[changeTime[i]]) + " ");
        }
        out.println();
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
