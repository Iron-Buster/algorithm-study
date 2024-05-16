package com.fqh;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/16 23:47
 **/
public class CF_1165E {


    static final long MOD = 998244353;

    public static void solve() throws IOException {
        int n = in.nextInt();
        Long[] a = new Long[n];
        Long[] b = new Long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        for (int i = 0; i < n; i++) b[i] = in.nextLong();
        for (int i = 0; i < n; i++) {
            a[i] = a[i] * (i + 1) * (n - i);
        }
        Arrays.sort(a);
        Arrays.sort(b, (x, y) -> Long.compare(y, x));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + a[i] % MOD * b[i]) % MOD;
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
