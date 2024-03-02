package com.fqh.div2.ROUND_931;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 17:51
 **/
public class B {


    public static void solve() throws IOException {
        long n = in.nextLong();
        long ans = Long.MAX_VALUE;
        for (int a = 0; a <= 2; a++) { // 最多2个1
            for (int b = 0; b <= 1; b++) { // 最多1个3
                for (int c = 0; c <= 5; c++) { // 最多5个6
                    for (int d = 0; d <= 3; d++) { // 最多3个10
                        long need = n - a - 3 * b - 6 * c - 10 * d;
                        if (need % 15 != 0 || need < 0) continue;
                        ans = Math.min(ans, a + b + c + d + need / 15);
                    }
                }
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
