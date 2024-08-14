package com.fqh.div3.ROUND_966;


import java.io.*;
import java.util.StringTokenizer;

public class B {

    // https://codeforces.com/contest/2000/problem/B
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            a[i]--;
        }
        var vis = new boolean[n];
        vis[a[0]] = true;
        for (int i = 1; i < n; i++) {
            boolean f1 = false, f2 = false;
            if (a[i] - 1 >= 0 && vis[a[i] - 1]) {
                f1 = true;
            }
            if (a[i] + 1 < n && vis[a[i] + 1]) {
                f2 = true;
            }
            if (f1 || f2) {
                vis[a[i]] = true;
            } else {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
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
