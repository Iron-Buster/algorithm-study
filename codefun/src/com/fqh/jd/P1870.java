package com.fqh.jd;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // https://codefun2000.com/p/P1870

    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int x = 0, y = 0;
        for (char c : s) {
            if (c == 'W') {
                y++;
            } else if (c == 'D') {
                int temp = x;
                x = y;
                y = -temp;
            } else if (c == 'A') {
                int temp = x;
                x = -y;
                y = temp;
            } else {
            }
        }
        out.println(x + " " + y);
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
