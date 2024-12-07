package com.fqh.div3.ROUND_991;


import java.io.*;
import java.util.StringTokenizer;

public class D {

    // https://codeforces.com/contest/2050/problem/D

    // 对于每个i,能够换的j位置相差不超过9，j - i <= 10
    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            int maxi = i;
            for (int j = i + 1; j < i + 9 && j < n; j++) {
                if (s[j] - (j - i) > s[maxi] - (maxi - i)) {
                    maxi = j;
                }
            }
            if (maxi != i) {
                char seti = (char) (s[maxi] - (maxi - i));
                for (int j = maxi; j > i; j--) {
                    s[j] = s[j-1];
                }
                s[i] = seti;
            }
        }
        out.println(String.valueOf(s));
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
