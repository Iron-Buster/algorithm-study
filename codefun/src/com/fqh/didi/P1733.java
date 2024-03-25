package com.fqh.didi;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/25 10:22
 **/
public class P1733 {
//    https://codefun2000.com/p/P1733
//    #P1733. 2024.03.24-滴滴春招-第一题-塔子哥的购物优惠
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < m; i++) {
            int cnt = in.nextInt();
            mn = Math.min(mn, cnt);
        }
        int sum = Arrays.stream(a).sum();
        if (mn > n) {
            out.println(sum);
            return;
        }
        Arrays.sort(a);
        for (int i = n - 1; i >= 0; i--, mn--) {
            if (mn == 1) {
                sum -= a[i];
                break;
            }
        }
        out.println(sum);
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
