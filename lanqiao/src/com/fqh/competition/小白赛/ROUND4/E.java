package com.fqh.competition.小白赛.ROUND4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/27 21:18
 **/
public class E {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] pos = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
            pos[b[i]] = i;
        }
        FenwickTree ft1 = new FenwickTree(n);
        FenwickTree ft2 = new FenwickTree(n);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i * ft2.query(pos[a[i]]) - ft1.query(pos[a[i]]);
            ft2.change(pos[a[i]], 1);
            ft1.change(pos[a[i]], i);
        }
        out.println(ans);
    }

    static class FenwickTree {
        int n;
        long[] s = new long[200005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) {    // 向后修
            while (x <= n) {
                s[x] += k;
                x += lowbit(x);
            }
        }

        public long query(int x) { // 向前查（前缀和）
            long t = 0;
            while (x > 0) {
                t += s[x];
                x -= lowbit(x);
            }
            return t;
        }
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
