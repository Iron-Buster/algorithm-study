package com.fqh.abc.abc_372;

import java.io.*;
import java.util.*;

public class B {

//    AC
    public static void solve() throws IOException {
        int m = in.nextInt();
        int[] A = new int[20];
        int sum = 0;
        int N = 0;
        for (int i = 10; i >= 0; i--) {
            int power = (int)Math.pow(3, i);
            while (sum + power <= m && N < 20) {
                A[N++] = i;
                sum += power;
            }
            if (sum == m) {
                break;
            }
        }
        out.println(N);
        for (int i = 0; i < N; i++) {
            out.print(A[i] + " ");
        }
        out.println();
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
