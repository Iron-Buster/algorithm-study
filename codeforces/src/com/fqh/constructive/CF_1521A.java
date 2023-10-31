package com.fqh.constructive;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/10/31 23:16
 * @Version V1.0
 */
public class CF_1521A {

    /**
     *
     * b=1的时候，不存在又能被a整除和又不能被a整除的数
     * 构造一种方式 x y z -> a, a * b, a * (b + 1)
     */

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    static void solve() throws Exception {
        long a = in.nextLong();
        long b = in.nextLong();
        if (b == 1) {
            out.println("NO");
            return;
        }
        out.println("YES");
        out.println(a + " " + a * b + " " + a * (b + 1));
    }

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
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
