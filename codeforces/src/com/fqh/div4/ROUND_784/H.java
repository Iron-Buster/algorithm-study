package com.fqh.div4.ROUND_784;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/22 14:32
 **/
public class H {

    // https://codeforces.com/contest/1669/problem/H
    // 从高位到低位贪心，如果当前位1的个数满足 k >= n - cnt1，那么可以将改为设置为1。
    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] map = new int[32];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            for (int j = 31; j >= 0; j--) {
                if ((a[i] >> j & 1) == 1) map[j]++;
            }
        }
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            int cnt = map[i];
            if (k >= n - cnt) {
                // 将ans的第i位设置位1
                ans |= (1<<i);
                k -= n - cnt;
            }
        }
        out.println(ans);
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
