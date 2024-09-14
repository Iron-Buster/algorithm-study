package com.fqh.abc.abc_371;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class E {

    // https://atcoder.jp/contests/abc371/tasks/abc371_e
    // leetcode 字符串总引力 https://leetcode.cn/problems/total-appeal-of-a-string/description/
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        var last = new HashMap<Integer, Integer>();
        long ans = 0L, sum = 0L;
        for (int i = 0; i < n; i++) {
            int c = a[i];
            sum += i - last.getOrDefault(c, -1);
            ans += sum;
            last.put(c, i);
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
