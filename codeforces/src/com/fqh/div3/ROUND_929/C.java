package com.fqh.div3.ROUND_929;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 10:33
 **/
public class C {


    public static void solve() throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        int l = in.nextInt();
        if (l % a != 0 && l % b != 0) {
            out.println(1);
            return;
        }
        var set = new HashSet<Integer>();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (l < ((int) Math.pow(a, x) * (int) Math.pow(b, y))) {
                    break;
                }
                int k = l / ((int) Math.pow(a, x) * (int) Math.pow(b, y));
                if (k > 0 && k <= l) {
                    if (k * (int) Math.pow(a, x) * (int) Math.pow(b, y) == l) {
                        set.add(k);
                    }
                }
            }
        }
        out.println(set.size());
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
