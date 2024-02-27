package com.fqh.brute_force;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/27 11:27
 **/
public class CF_1514B {

//    https://codeforces.com/problemset/problem/1541/B
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤2n)，数组元素互不相同。
//
//    输出有多少对 (i,j) 满足 i<j 且 a[i]*a[j]=i+j。

//    输入
//        3
//        2
//        3 1
//        3
//        6 1 5
//        5
//        3 1 5 9 2
//    输出
//        1
//        1
//        3


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        long ans = 0;
        // a[i] * a[j] = (i + j) < 2n
        var map = new HashMap<Integer, Integer>();
        for (int j = 1; j <= n; j++) {
            int aj = a[j];
            for (int ai = 1; ai * ai < 2 * j; ai++) {
                Integer i = map.get(ai);
                if (i != null && ai * aj == i + j) {
                    ans++;
                }
            }
            map.put(aj, j);
        }
        out.println(ans);
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
