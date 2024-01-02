package com.fqh.GOOD_BYE2023;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 22:33
 **/
public class A {



    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();

        }
        long s = 1;
        for (int x : b) {
            s *= x;
        }
        if (2023L % s != 0) {
            out.println("NO");
        } else {
            long v = 2023L / s;
            out.println("YES");
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    out.print(v + "\n");
                } else {
                    out.print(1 + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
