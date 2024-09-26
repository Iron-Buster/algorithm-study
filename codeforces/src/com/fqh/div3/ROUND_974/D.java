package com.fqh.div3.ROUND_974;

import java.io.*;
import java.util.StringTokenizer;


public class D {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int d = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[k][2];
        for (int i = 0; i < k; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            a[i][0] = l;
            a[i][1] = r;
        }
        int[] in = new int[n + 2];
        int[] ot = new int[n + 2];
        for (int[] en : a) {
            in[en[0]]++;
            ot[en[1]]++;
        }
        int r = 0;
        for (int i = 0; i < d; i++) {
            r += in[i];
        }
        int r1 = -1, r2 = k + 1;
        int ret1 = -1, ret2 = -1;
        for (int i = 1; i + d - 1 <= n; i++) {
            r -= ot[i - 1];
            r += in[i + d - 1];
            if (r > r1) {
                r1 = r;
                ret1 = i;
            }
            if (r < r2) {
                r2 = r;
                ret2 = i;
            }
        }
        out.println(ret1 + " " + ret2);
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
