package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

public class P1972 {

    // https://codefun2000.com/p/P1972
    // #P1972. 2024.8.31-MT-第2题-塔子哥种树
    static boolean check(int mid, int[] a, int k) {
        int cnt = mid;
        int pre = a[0] + mid - 1;
        for (int i = 1; i < a.length; i++) {
            int cur = a[i] + mid - 1;
            if (pre >= a[i]) {
                cnt += cur - pre;
            } else {
                cnt += mid;
            }
            pre = cur;
        }
        return cnt >= k;
    }
    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int l = 1;
        int r = 200001;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, a, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
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
