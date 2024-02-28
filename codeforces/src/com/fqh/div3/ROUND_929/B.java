package com.fqh.div3.ROUND_929;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 10:30
 **/
public class B {



    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        long s = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            s += a[i];
        }
        if (s % 3 == 0) {
            out.println(0);
            return;
        }
        for (int x : a) {
            if ((s - x) % 3 == 0) {
                out.println(1);
                return;
            }
        }
        if ((s + 1) % 3 == 0) {
            out.println(1);
        }
        else if ((s + 2) % 3 == 0) {
            out.println(2);
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
