package com.fqh.oppo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P1939 {

    // https://codefun2000.com/p/P1939
    // 卡54

    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        TreeMap<Long, Integer> tmap = new TreeMap<>();
        long minV = 0;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            tmap.merge(a[i], 1, Integer::sum);
            if (a[i] == minV) minV++;
            pos[i] = i;
        }
        Arrays.sort(pos, (i, j) -> Long.compare(a[i], a[j]));
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int p = pos[i];
            if (tmap.get(a[p]) == 1) {
                ans[p] = Math.min(a[p], minV);
            } else {
                ans[p] = minV;
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
