package com.fqh.jd;


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1871 {
    // https://codefun2000.com/p/P1871
    // 求满足 ai+aj = x 的（i,j）数对
    // 22
    // 31 13
    public static void solve() throws IOException {
        int n = in.nextInt();
        long x = in.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        HashMap<Long, Integer> map = new HashMap<>();
        long ans = 0;
        for (int j = 0; j < n; j++) {
            long v = x - a[j];
            map.merge(a[j], 1, Integer::sum);
            if (v != a[j]) {
                ans += 2L * map.getOrDefault(v, 0); // 1 3 和 3 1不是一样的
            } else {
                ans += map.getOrDefault(v, 0); // 2 2 和 2 2是一样的
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
