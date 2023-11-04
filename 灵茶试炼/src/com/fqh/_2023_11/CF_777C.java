package com.fqh._2023_11;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/1 11:36
 * @Version V1.0
 */
public class CF_777C {

//    https://codeforces.com/problemset/problem/777/C
//
//    输入 n m(1≤n*m≤1e5) 和 n 行 m 列的矩阵 a，元素范围 [1,1e9]。
//    然后输入 k(1≤k≤1e5) 和 k 个询问，每个询问输入两个数 L R(1≤L≤R≤n)。
//    对于每个询问，请判断在第 L 行到第 R 行中，是否存在一列，元素值从上到下是递增的（允许相等），输出 Yes 或 No。
//
//    进阶：把询问范围缩小至子矩形，即第 L 行到第 R 行并且只考虑第 p 列到第 q 列。@tdzl2003


//    输入
//        5 4
//        1 2 3 5
//        3 1 3 2
//        4 5 2 3
//        5 5 3 2
//        4 4 3 4
//        6
//        1 1
//        2 5
//        4 5
//        3 5
//        1 3
//        1 5
//        输出
//                Yes
//                No
//                Yes
//                Yes
//                Yes
//                No


//    提示 1：对于一个固定的 R，能输出 Yes 的最小 L 是多少？
//
//    提示 2：定义 up[i][j] 表示第 j 列中，从第 up[i][j] 行到第 i 行，是递增的。
//    如果 a[i-1][j] <= a[i][j]，那么 up[i][j] = up[i-1][j]，否则 up[i][j] = i。
//    那么提示 1 要计算的最小 L，即为 min(up[R])，可以记在数组 minL 中。
//
//    对于每个询问，只要 minL[R] <= L，则输出 Yes，否则输出 No。
//
//    代码实现时，up 数组的第一个维度可以去掉。
//
//    https://codeforces.com/problemset/submission/777/230012309

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    static void solve() throws Exception {
        int n = in.nextInt();
        int m = in.nextInt();
        var minL = new int[n];
        var up = new int[m];
        var arr = new int[n][m];
        for (int i = 0; i < n; ++i) {
            minL[i] = i;
            for (int j = 0; j < m; ++j) {
                arr[i][j] = in.nextInt();
                if (i > 0 && arr[i][j] < arr[i - 1][j]) {
                    up[j] = i;
                }
                minL[i] = Math.min(minL[i], up[j]);
            }
        }
        int k = in.nextInt();
        while (k-- > 0) {
            int L = in.nextInt();
            int R = in.nextInt();
            if (minL[R - 1] <= L - 1) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) {
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
