package com.fqh.abc.abc_384;


import java.io.*;
import java.util.StringTokenizer;

public class A {

    public static void solve() throws IOException {
        String[] a = in.nextLine().split(" ");
        int n = Integer.parseInt(a[0]);
        String c1 = String.valueOf(a[1]);
        String c2 = String.valueOf(a[2]);

        char[] s = in.nextLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (s[i] != c1.charAt(0)) {
                s[i] = c2.charAt(0);
            }
        }
        out.println(String.valueOf(s));
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
