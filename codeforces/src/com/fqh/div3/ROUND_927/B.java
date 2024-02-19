package com.fqh.div3.ROUND_927;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/18 20:20
 **/
public class B {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        long last = a[1];
        for (int i = 2; i <= n; i++) {
           if (a[i] > last) {
               last = a[i];
           } else if (a[i] < last) {
               long k = last / a[i] + 1;
               last = k * a[i];
           } else {
               last = 2L * a[i];
           }
        }
        out.println(last);

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
