package com.fqh.div3.ROUND_925;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/13 21:46
 **/
public class C {


    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
        }
        long v1 = 0, v2 = 0;
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                v1 = 1;
                l = i + 1;
            } else if (a[i] == a[i-1]) {
                v1++;
                l = i + 1;
            } else break;
        }
        for (int i = n; i >= 1; i--) {
            if (i == n) {
                v2 = 1;
                r = i - 1;
            } else if (a[i] == a[i+1]) {
                v2++;
                r = i - 1;
            } else break;
        }
        if (v1 == n) {
            out.println(0);
            return;
        }
        if (a[1] == a[n]) {
            out.println(r - l + 1);
        } else if (v1 > v2) {
            out.println(n - l + 1);
        } else {
            out.println(r);
        }
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
