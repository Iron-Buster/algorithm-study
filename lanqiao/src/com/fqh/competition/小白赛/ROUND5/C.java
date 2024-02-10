package com.fqh.competition.小白赛.ROUND5;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/10 22:22
 **/
public class C {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        var map = new HashMap<Long, Integer>();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long v = (long) a[i] * i;
            ans += map.getOrDefault(v, 0);
            map.merge(v, 1, Integer::sum);
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
