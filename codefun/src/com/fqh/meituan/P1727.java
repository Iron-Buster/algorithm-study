package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/23 17:16
 **/
public class P1727 {

    //https://codefun2000.com/p/P1727
    //  #P1727. 2024.3.23-美团-第二题-塔子哥的回文子串

    public static void solve() throws IOException {
        int n = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        int ans = 0;
        // aaa -> 2
        // aabbaa -> 3
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i-1]) ans++;
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
