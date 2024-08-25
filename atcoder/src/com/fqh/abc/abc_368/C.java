package com.fqh.abc.abc_368;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    // https://atcoder.jp/contests/abc368/tasks/abc368_c#

    static long ans;
    static long[] a;
    static void da(int i) {
        if (ans % 3 == 2) a[i] -= 3;
        else a[i]--;
        ans++;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        a = new long[n + 1];
        ans = 0;
        for (int i = 1; i <= n; i++) a[i] = in.nextLong();
        for (int i = 1; i <= n; i++) {
            while (a[i] > 0 && ans % 3 != 0) {
                da(i);
            }
            ans += a[i] / 5 * 3;
            a[i] %= 5;
            while (a[i] > 0) da(i);
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
