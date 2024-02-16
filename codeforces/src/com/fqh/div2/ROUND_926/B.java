package com.fqh.div2.ROUND_926;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/15 22:33
 **/
public class B {


    public static void solve() throws IOException {
        long n = in.nextLong();
        long k = in.nextLong();
        long cnt = 4 * n - 2; // 对角线数量
        int v = (cnt == k ? 1 : 0);
        if (k % 2 == 1) k++;
        out.println(k / 2 + v);
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
