package com.fqh.other;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/23 17:09
 **/
public class CF_1921D {

    // WAWAWAWA
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        TreeMap<Integer, Integer> b = new TreeMap<>();
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            b.merge(v, 1, Integer::sum);
        }
        Arrays.sort(a);
        long ans = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (i == j) {
                Integer mx = b.lastKey();
                Integer mn = b.firstKey();
                ans += Math.max(Math.abs(mx - a[i]), Math.abs(mn - a[i]));
                break;
            }
            Integer mx = b.lastKey();
            if (mx != null) {
                ans += Math.abs(mx - a[i]);
                b.merge(mx, -1, Integer::sum);
                if (b.get(mx) == 0) b.remove(mx);
            }
            Integer mn = b.firstKey();
            if (mn != null) {
                ans += Math.abs(mn - a[j]);
                b.merge(mn, -1, Integer::sum);
                if (b.get(mn) == 0) b.remove(mn);
            }
            i++; j--;
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
