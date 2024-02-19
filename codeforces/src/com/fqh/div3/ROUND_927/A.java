package com.fqh.div3.ROUND_927;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/18 20:14
 **/
public class A {


    public static void solve() throws IOException {
        int n = in.nextInt();
        String s = in.nextLine();
        int i = 0;
        int ans = 0;
        while (i < n) {
            if (s.charAt(i) == '*') {
                break;
            }
            if (s.charAt(i) == '@') {
                ans += 1;
                if (i + 1 < n && s.charAt(i + 1) != '*') {
                    i += 1;
                } else if (i + 2 < n && s.charAt(i + 2) != '*') {
                    i += 2;
                } else {
                    i++;
                }
            }
            else if (s.charAt(i) == '.') {
                if (i + 1 < n && s.charAt(i + 1) != '*') {
                    i += 1;
                } else if (i + 2 < n && s.charAt(i + 2) != '*') {
                    i += 2;
                } else {
                    i++;
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
