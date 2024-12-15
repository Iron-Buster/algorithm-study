package com.fqh.abc.abc_384;


import java.io.*;
import java.util.StringTokenizer;

public class B {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int r = in.nextInt();
        for (int i = 0; i < n; i++) {
            int d = in.nextInt();
            int a = in.nextInt();
            if (d == 2 && r >= 1200 && r <= 2399) {
                r += a;
            }
            if (d == 1 && r >= 1600 && r <= 2799) {
                r += a;
            }
        }
        out.println(r);
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
