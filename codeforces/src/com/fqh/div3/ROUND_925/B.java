package com.fqh.div3.ROUND_925;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/13 21:46
 **/
public class B {



    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            sum += a[i];
        }
        // 1 2 3 4 5
        long v = sum / n;
        long vv = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > v) {
                vv += a[i] - v;
            } else {
                if (vv < Math.abs(a[i] - v)) {
                    out.println("NO");
                    return;
                } else {
                    vv -= Math.abs(a[i] - v);
                }
            }
        }
        if (vv > 0) {
            out.println("NO");
        } else {
            out.println("YES");
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
