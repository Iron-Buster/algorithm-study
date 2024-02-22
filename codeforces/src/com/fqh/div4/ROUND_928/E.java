package com.fqh.div4.ROUND_928;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/19 18:20
 **/
public class E {

    static List<Long> a = new ArrayList<>();


    public static void solve() throws IOException {
        long n = in.nextLong();
        long k = in.nextLong();
        var a = new ArrayList<Long>();
        var vis = new HashSet<Long>();
        for (long i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                a.add(i);
                vis.add(i);
            }
        }
        List<Long> b = new ArrayList<>();
        for (long x : a) {
            if (x * 2 > n) break;
            if (vis.contains(x * 2)) continue;
            b.add(x * 2);
            vis.add(x * 2);
        }
        List<Long> c = new ArrayList<>();
        for (long x : a) {
            if (x * 3 > n) break;
            if (vis.contains(x * 3)) continue;
            c.add(x * 3);
            vis.add(x * 3);
        }
        List<Long> d = new ArrayList<>();
        for (long x : a) {
            if (x * 4 > n) break;
            if (vis.contains(x * 4)) continue;
            d.add(x * 4);
            vis.add(x * 4);
        }
        a.addAll(b);
        a.addAll(c);
        a.addAll(d);
        out.println(a.get((int) (k - 1)));
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
