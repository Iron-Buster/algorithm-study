package com.fqh.competition.小白赛.ROUND3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 21:25
 **/
public class D {

    public static void solve() throws IOException {
        int a = in.nextInt(); // a体力
        int b = in.nextInt(); // b体力
        int bv = in.nextInt(); // b攻击力
        if (bv >= a) {
            out.println(b);
            return;
        }
        int cnt = a % bv == 0 ? a / bv : a / bv + 1;
        out.println(b % cnt == 0 ? b / cnt : b / cnt + 1);
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
