package com.fqh.div4.ROUND_784;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/22 15:04
 **/
public class C {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true;
        for (int i = 1; i <= n; i++) {
            if (a[i] % 2 == 1) {
                ok4 = false;
            } else {
                ok3 = false;
            }
            if (i % 2 == 1) {
                if (a[i] % 2 == 0) ok1 = false;
                else ok2 = false;
            } else {
                if (a[i] % 2 == 1) ok1 = false;
                else ok2 = false;
            }
        }
        if (ok1 || ok2 || ok3 || ok4) {
            out.println("YES");
        } else {
            out.println("NO");
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
