package com.fqh.competition.小白赛.ROUND3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 21:11
 **/
public class B {

    public static void solve() throws IOException {
        int n = in.nextInt();
        String ss = in.nextLine();
        char[] s = ss.toCharArray();
        // 000111
        // 111000
        // 最后得到的字符串一定是上面两种之一
        int cnt1 = s[0] - '0';
        int res1 = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == '1') {
                cnt1++;
            } else {
                res1 += cnt1;
            }
        }
        int cnt0 = s[0] == '0' ? 1 : 0;
        int res2 = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == '0') {
                cnt0++;
            } else {
                res2 += cnt0;
            }
        }
        out.println(Math.min(res1, res2));
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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
