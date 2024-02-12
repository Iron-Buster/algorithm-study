package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/12 10:52
 **/
public class CF_1738B {

//    https://codeforces.com/problemset/problem/1738/B
//
//    输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
//    每组数据输入 n k (1≤k≤n≤1e5) 和 k 个整数，范围 [-1e9,1e9]。
//
//    这 k 个数是一个长为 n 的非降数组的前缀和的最后 k 项（从左到右）。
//    是否存在这样的非降数组？输出 Yes 或 No。

//    输入
//4
//        5 5
//        1 2 3 4 5
//        7 4
//        -6 -5 -3 0
//        3 3
//        2 3 4
//        3 2
//        3 4
//    输出
//            Yes
//    Yes
//            No
//    No
//            解释
//    这四组数据，对应的数组分别可能是
//[1,1,1,1,1]
//        [-3,-2,-1,0,1,2,3]
//        [2,1,1]
//        [1,2,1]
//    后两个数组不是非降数组


    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] s = new long[k];
        for (int i = 0; i < k; i++) s[i] = in.nextLong();
        if (k > 1 && s[0] > (n - k + 1) * (s[1] - s[0])) {
            out.println("NO");
            return;
        }
        for (int i = 2; i < k; i++) {
            if (s[i-1] * 2 > s[i] + s[i-2]) {
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
