package com.fqh.div4.ROUND_964;

import java.io.*;
import java.util.StringTokenizer;

public class D {

    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        char[] t = in.nextLine().toCharArray();
        if (s.length < t.length) {
            out.println("NO");
            return;
        }
        int m = s.length, n = t.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                if (s[i] == '?') {
                    s[i] = t[j];
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
        }
        if (j == n) {
            for (i = 0; i < m; i++) {
                if (s[i] == '?') s[i] = 'a';
            }
            out.println("YES");
            out.println(String.valueOf(s));
        } else {
            out.println("NO");
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
