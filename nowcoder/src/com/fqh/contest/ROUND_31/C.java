package com.fqh.contest.ROUND_31;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/5 11:16
 **/
public class C {

//            5 b
//            cabcb


    public static void solve() throws IOException {
        String s1 = in.nextLine();
        String[] sp = s1.split(" ");
        int n = Integer.parseInt(sp[0]);
        char x = sp[1].charAt(0);
        String s2 = in.nextLine();
        char[] s = s2.toCharArray();
        long res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == x) {
                int p = Math.min(i - j, n - i - 1) + 1;
                res += p;
            }
        }
        out.println(res);
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
