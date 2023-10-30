package com.fqh.constructive;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/10/30 22:12
 * @Version V1.0
 */
public class CF_467B {

    /**
     * 枚举 a[m + 1] 和前面几个数上二进制不同的个数
     */
    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    static void solve() throws Exception {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        for (int i = 1; i <= m + 1; ++i) {
            a[i] = in.nextInt();
        }
        int s = a[m + 1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            int diff = 0;
            for (int j = 0; j < 32; ++j) {
                int x = (s >> j) & 1;
                int y = (a[i] >> j) & 1;
                if (x != y) diff++;
            }
            ans += diff <= k ? 1 : 0;
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) {
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
