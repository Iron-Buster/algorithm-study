package com.fqh;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1955C {

//    https://codeforces.com/problemset/problem/1955/C
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(1≤n≤2e5) k(1≤k≤1e15) 和长为 n 的数组 a(1≤a[i]≤1e9)。
//
//    有 n 个石子堆，每堆的石子个数记录在数组 a 中。
//    按照如下顺序取石子：
//    从最左边的有石子的堆中取出一颗石子，然后从最右边的有石子的堆中取出一颗石子，重复上述过程，左右左右取石子。
//    你至多取出 k 颗石子。
//
//    你可以把多少堆石子变成空的？

    public static void solve() throws IOException {
        int n = in.nextInt();
        long k = in.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        if (k >= Arrays.stream(a).sum()) {
            out.println(n);
            return;
        }
        int i = 0, j = n - 1;
        for (long left = (k + 1) / 2; left >= a[i]; i++) {
            left -= a[i];
        }
        for (long left = k / 2; left >= a[i]; j--) {
            left -= a[j];
        }
        out.println(i + n - 1 - j);
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
