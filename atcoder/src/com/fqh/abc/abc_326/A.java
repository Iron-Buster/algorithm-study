package com.fqh.abc.abc_326;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/1 16:57
 * @Version V1.0
 */
public class A {

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    /**
     * 向上每次只能上2层
     * 向下每次只能下<=3层
     */

    static void solve() throws Exception {
        int x = in.nextInt();
        int y = in.nextInt();
        if ((x < y && y - x <= 2) || (x > y && x - y <= 3)) {
            out.println("Yes");
        } else {
            out.println("No");
        }
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
