package com.fqh.div3.ROUND_923;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/7 13:11
 **/
public class D {


    static int[] a = new int[200001];
    static int[] to = new int[200001];
    public static void solve() throws IOException {
        int n = in.nextInt();
        to[1] = 0;
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        for (int i = 2; i <= n; i++) {
            if (a[i] != a[i-1]) to[i] = i - 1;
            else to[i] = to[i-1];
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            if (to[r] < l) {
                out.println(-1 + " " + -1);
            } else {
                out.println(to[r] + " " + r);
            }
        }
        out.println();
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
