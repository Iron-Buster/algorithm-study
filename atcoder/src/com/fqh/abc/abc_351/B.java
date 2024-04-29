package com.fqh.abc.abc_351;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/29 22:14
 **/
public class B {


    public static void solve() throws IOException {
        int n = in.nextInt();
        char[][] a = new char[n][n];
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            var s1 = String.valueOf(a[i]);
            var s2 = String.valueOf(b[i]);
            if (s1.equals(s2)) continue;
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    out.println((i+1) + " " + (j+1));
                    return;
                }
            }
        }
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
