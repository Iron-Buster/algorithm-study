package com.fqh.xiaomi;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P1992 {

    // https://codefun2000.com/p/P1992
    // 2024.9.5-XM-第1题-小塔吃面包(开发岗)


    static class PII {
        int value;
        int index;

        public PII(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < n; i++) b[i] = in.nextInt();

        TreeSet<PII> tset1 = new TreeSet<>((x, y) -> x.value - y.value);
        TreeSet<PII> tset2 = new TreeSet<>((x, y) -> x.value - y.value);
        for (int i = 0; i < n; i++) {
            tset1.add(new PII(b[i], i));
            tset2.add(new PII(a[i], i));
        }
        long ans = Long.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            int c1 = a[i] + b[i];
            PII ceiling = tset1.ceiling(new PII(a[i], 0));
            ans = Math.min(ans, c1);
            if (ceiling == null) {
                ans = Math.min(ans, a[i]);
            }
            if (ceiling != null && ceiling.index != i) {
                ans = Math.min(ans, ceiling.value);
            }

            PII ceiling2 = tset2.ceiling(new PII(b[i], 0));
            if (ceiling2 == null) {
                ans = Math.min(ans, b[i]);
            }
            if (ceiling2 != null && ceiling2.index != i) {
                ans = Math.min(ans, ceiling2.value);
            }
        }
        out.println(ans);
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
