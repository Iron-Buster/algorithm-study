package com.fqh.div4.ROUND_918;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/28 23:45
 **/
public class E {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if ((i & 1) == 1) {
                a[i] = -a[i];
            }
        }
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + a[i];
        }
        var set = new HashSet<Long>();
        for (int i = 1; i <= n; i++) {
            if (set.contains(sum[i]) || sum[i] == 0) {
                out.println("YES");
                return;
            }
            set.add(sum[i]);
        }
        out.println("NO");
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
