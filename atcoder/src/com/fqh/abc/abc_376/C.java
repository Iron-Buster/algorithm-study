package com.fqh.abc.abc_376;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static boolean check(long mid, long[] a, long[] b) {
        int n = a.length;
        int i = 0, j = 0;
        boolean vis = false;
        for (i = 0; i < n; i++) {
            if (j == n - 1) {
                // 如果mid用过，或者a后面还有很多数字，或者mid < a[i]那么为false
                if (vis || i < n - 1 || mid < a[i]) return false;
                vis = true;
                continue;
            }
            if (a[i] > b[j]) {
                return false;
            }
            // 使用mid
            if (!vis && mid >= a[i] && mid <= b[j]) {
                vis = true;
                continue;
            }
            j++;
        }
        return i == n;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n-1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        for (int i = 0; i < n - 1; i++) {
            b[i] = in.nextLong();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long l = 1;
        long r = (long) 2e14;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(mid, a, b)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (!check(l, a, b)) {
            out.println(-1);
            return;
        }
        out.println(l);
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
