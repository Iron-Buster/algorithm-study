package com.fqh.abc.abc_371;

import java.io.*;
import java.util.*;

public class D {

    // https://atcoder.jp/contests/abc371/tasks/abc371_d
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : a) {
            tset.add(x);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }

        FenwickTree ft = new FenwickTree(tset.size() + 1);
        for (int i = 0; i < n; i++) {
            int index = map.get(a[i]);
            ft.change(index, b[i]);
        }

        int q = in.nextInt();
        List<Long> ans = new ArrayList<>();
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            Integer floorKey = map.floorKey(r);
            Integer ceilingKey = map.ceilingKey(l);
            if (floorKey == null || ceilingKey == null) {
                ans.add(0L);
                continue;
            }
            int right = map.get(floorKey);
            int left = map.get(ceilingKey);
            long res = ft.query(right) - ft.query(left - 1);
            ans.add(res);
        }
        for (long v : ans) out.println(v);
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
