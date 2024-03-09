package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/9 12:28
 **/
public class P1680 {

//https://codefun2000.com/p/P1680
//    #P1680. 2024.3.9美团-第一题-塔子哥的M和T

    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        int[] cnt = new int[126];
        for (char c : s) cnt[c]++;
        out.println(cnt['M'] + cnt['T'] + Math.min(k, n - cnt['M'] - cnt['T']));
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
