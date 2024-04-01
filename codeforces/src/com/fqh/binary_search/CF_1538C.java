package com.fqh.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/1 21:01
 **/
public class CF_1538C {

//    https://codeforces.com/problemset/problem/1538/C
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(1≤n≤2e5) L R(1≤L≤R≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
//
//    输出有多少对 (i, j) 满足 i < j 且 L <= a[i] + a[j] <= R。

    public static int bisectLeft(int[] a, int start, int target) {
        int left = start, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int bisectRight(int[] a, int start, int target) {
        int left = start, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        int L = in.nextInt();
        int R = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = bisectLeft(a, i + 1, L - a[i]);
            int r = bisectRight(a, i + 1, R - a[i]);
            if (l == -1 || r == -1) continue;
            ans += r - l;
        }
        out.println(ans);
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
