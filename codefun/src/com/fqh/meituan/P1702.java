package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/17 23:20
 **/
public class P1702 {

    //https://codefun2000.com/p/P1702
    // #P1702. 2024.3.16美团-第二题-塔子哥学单词
    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        int x = 0, y = 0;
        for (char c : s) {
            if (c >= 'a' && c <= 'z') x++;
            else y++;
        }
        int res1 = Math.min(n - y, n - x);
        int res2 = y - (s[0] >= 'A' && s[0] <= 'Z' ? 1 : 0);
        out.println(Math.min(res1, res2));
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
