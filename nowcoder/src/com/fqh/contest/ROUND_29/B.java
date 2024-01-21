package com.fqh.contest.ROUND_29;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/21 20:39
 **/
public class B {

    public static void solve() throws IOException {
        int n = in.nextInt();
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 'Y' && b[i] == 'Y') {
                ans += 3;
                continue;
            }
            if (a[i] == 'N' && b[i] == 'Y') {
                ans += 2;
            } else if (a[i] == 'Y') {
                ans += 2;
            }
        }
        out.println(ans);
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
