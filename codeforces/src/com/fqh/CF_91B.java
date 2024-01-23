package com.fqh;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/23 10:15
 **/
public class CF_91B {

//    https://codeforces.com/problemset/problem/91/B
//
//    输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
//    对于每个 i，输出 j-i-1 的最大值，其中 j 满足 j>i 且 a[j]<a[i]。如果不存在这样的 j，输出 -1。

//    输入
//    6
//        10 8 5 3 50 45
//    输出 2 1 0 -1 0 -1
//
//    输入
//    7
//        10 4 6 3 2 8 15
//    输出 4 2 1 0 -1 -1 -1
//
//    输入
//    5
//        10 3 1 10 11
//    输出 1 0 -1 -1 -1

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] ans = new int[n];
        var tmap = new TreeMap<Integer, Integer>();
        for (int i = n - 1; i >= 0; i--) {
            var entry = tmap.lowerEntry(a[i]);
            if (entry == null) {
                ans[i] = -1;
            } else {
                ans[i] = entry.getValue() - i - 1;
            }
            if (tmap.isEmpty() || a[i] < tmap.firstKey()) {
                tmap.put(a[i], i);
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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
