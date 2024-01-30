package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/30 09:43
 **/
public class CF_1717C {
//    https://codeforces.com/problemset/problem/1717/C
//
//    输入 T(≤4e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 n 的数组 b(1≤a[i]≤1e9)。
//
//    你可以执行如下操作任意次：
//    选择一个下标 i，满足 a[i] <= a[(i+1)%n]，然后把 a[i] 增加 1。
//
//    能否把 a 变成 b？输出 YES 或 NO。

//    输入
//        5
//        3
//        1 2 5
//        1 2 5
//        2
//        2 2
//        1 3
//        4
//        3 4 1 2
//        6 4 2 5
//        3
//        2 4 1
//        4 5 3
//        5
//        1 2 3 4 5
//        6 5 6 7 6
//    输出
//            YES
//            NO
//            NO
//            NO
//            YES
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < n; i++) b[i] = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i] || (a[i] < b[i] && b[i] > b[(i+1)%n] + 1)) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
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
