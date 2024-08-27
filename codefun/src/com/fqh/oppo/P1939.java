package com.fqh.oppo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1939 {

    // https://codefun2000.com/p/P1939

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : a) {
            if (v < n) map.merge(v, 1, Integer::sum);
        }
        int mex = 0;
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(i, 0) == 0) {
                mex = i;
                break;
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] < n && map.get(a[i]) == 1 && mex > a[i]) {
                ans[i] = a[i];
            } else {
                ans[i] = mex;
            }
        }
        for (long v : ans) out.print(v + " ");
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
