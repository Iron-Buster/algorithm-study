package com.fqh.other;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/29 10:33
 **/
public class CF_489B {

//    https://codeforces.com/problemset/problem/489/B
//
//    输入 n(1≤n≤100) 和长为 n 的数组 a(1≤a[i]≤100)。
//    输入 m(1≤m≤100) 和长为 m 的数组 b(1≤b[i]≤100)。
//
//    你可以从 a b 中各选一个数字，组成一个数对 (a[i],b[j])，要求 |a[i]-b[j]|<=1。
//    选过的数字不能再选，最多可以选出多少个数对？

//    输入
//        4
//        1 4 6 2
//        5
//        5 1 5 7 9
//    输出 3

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(b);
        int ans = 0;
        int i = 0, j = 0;
        // 1 2 4 6
        // 1 5 5 7 9
        while (i < n) {
            while (i < n && j < m && Math.abs(a[i] - b[j]) > 1) {
                if (a[i] > b[j]) j++;
                else i++;
            }
            if (i >= n || j >= m) break;
            ans++;
            i++;
            j++;
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
