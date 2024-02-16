package com.fqh.div2.ROUND_926;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/15 23:03
 **/
public class C {


    public static void solve() throws IOException {
        int k = in.nextInt(); // 赢钱时的加注次数
        int x = in.nextInt(); // 输钱的最大次数
        int a = in.nextInt(); // 初始硬币
        long need = 0;
        for (int i = 1; i <= x + 1; i++) {
           long t = (need + 1 + k - 2) / (k - 1);
           need += t;
           if (need > a) {
               out.println("NO");
               return;
           }
        }
        out.println("YES");
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
