package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/9 12:33
 **/
public class P1681 {

    //https://codefun2000.com/p/P1681
    //#P1681. 2024.3.9美团-第二题-塔子哥的最大最小值
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        long s = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            cnt += (x == 0 ? 1 : 0);
            s += x;
        }
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            out.print(s + cnt * l + " " + s + cnt * r);
            out.println();
        }
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
