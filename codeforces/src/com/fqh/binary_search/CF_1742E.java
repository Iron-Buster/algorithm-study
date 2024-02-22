package com.fqh.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/22 17:44
 **/
public class CF_1742E {


//    https://codeforces.com/problemset/problem/1742/E
//    维护前缀最大值数组b，然后在b上二分查找l
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n], b = new int[n];
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            s[i+1] = s[i] + a[i];
            if (i == 0) b[i] = a[i];
            else b[i] = Math.max(b[i-1], a[i]);
        }
        while (q-- > 0) {
            int k = in.nextInt();
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (b[mid] <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (b[l] > k) {
                out.print(0 + " ");
            } else {
                out.print(s[l + 1] + " ");
            }
        }
        out.println();
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
