package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/24 14:53
 **/
public class CF_1610C {

//    https://codeforces.com/problemset/problem/1610/C
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(1≤n≤2e5) 和 n 行，每行 2 个数 a[i] 和 b[i]，范围都在 [0,n] 内。
//
//    你有 n 个朋友，第 i 个朋友有 i 元钱。
//    你想邀请朋友参加聚会。
//    对于第 i 个朋友，只有聚会中最多有 a[i] 个人比他的钱多，最多有 b[i] 个人比他的钱少，他才会参加聚会。
//
//    输出你最多可以邀请多少个人。

//    输入
//        3
//        3
//        1 2
//        2 1
//        1 1
//        2
//        0 0
//        0 1
//        2
//        1 0
//        0 1
//    输出
//        2
//        1
//        2

    static int[] a;
    static int[] b;
    static boolean check(int m) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (cnt <= b[i] && m - 1 - cnt <= a[i]) {
                cnt++;
            }
        }
        return cnt < m;
    }
    public static void solve() throws IOException {
        int n = in.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            a[i] = v1;
            b[i] = v2;
        }
        int l = 0;
        int r = 200001;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        out.println(l);
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
