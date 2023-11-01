package com.fqh.abc.abc_326;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @Author: vq
 * @Date: 2023/11/1 17:08
 * @Version V1.0
 */
public class B {

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    /**
     *
     * 预处理出100-919的所有326数
     * 一个326 样数是一个三位数的正整数，其中百位数和十位数的乘积等于个位数。
     */

    static boolean ok = false;
    static TreeSet<Integer> tset = new TreeSet<>();
    static void init() {
        if (ok) return;
        for (int x = 100; x <= 919; ++x) {
            int v1 = x % 10;
            int v2 = (x / 10) % 10;
            int v3 = (x / 100);
            if (v3 * v2 == v1) tset.add(x);
        }
        ok = true;
    }

    static void solve() throws Exception {
        int N = in.nextInt();
        Integer res = tset.ceiling(N);
        out.println(res);
    }

    public static void main(String[] args) throws Exception {
        init();
        int t = 1;
        while (t-- > 0) {
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
