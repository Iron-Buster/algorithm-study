package com.fqh.abc.abc_375;

import java.io.*;
import java.util.StringTokenizer;

public class D {

    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        long[][] sum = new long[26][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                sum[j][i+1] = sum[j][i];
            }
            sum[s[i]-'A'][i+1]++;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                long l = sum[j][i];
                long r = sum[j][n] - sum[j][i+1];
                ans += l * r;
            }
        }
        out.println(ans);
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
