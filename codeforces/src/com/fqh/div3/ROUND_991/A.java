package com.fqh.div3.ROUND_991;


import java.io.*;
import java.util.StringTokenizer;

public class A {

    // https://codeforces.com/contest/2050/problem/A

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            var s = in.nextLine();
            m -= s.length();
            if (m < 0) continue;
            ans = i + 1;
        }
        out.println(ans);
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
