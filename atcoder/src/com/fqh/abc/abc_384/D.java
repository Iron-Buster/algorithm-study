package com.fqh.abc.abc_384;


import java.io.*;
import java.util.StringTokenizer;

public class D {

    public static void solve() throws IOException {
        int N = in.nextInt();
        long S = in.nextLong();
        long[] a = new long[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
            total += a[i];
        }
        long sum = 0;
        int l = 0;
        for (int r = 0; r < 2 * N; r++) {
            sum += a[r % N];
            while (sum > S % total) {
                sum -= a[l % N];
                l++;
            }
            if (sum == S % total) {
                out.println("Yes");
                return;
            }
        }

        out.println("No");
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
