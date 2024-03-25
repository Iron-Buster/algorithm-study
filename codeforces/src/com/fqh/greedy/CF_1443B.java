package com.fqh.greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/25 09:55
 **/
public class CF_1443B {

//    https://codeforces.com/problemset/problem/1443/B
//
//    输入 T(≤1e5) 表示 T 组数据。所有数据的字符串长度之和 ≤1e5。
//    每组数据输入 a(1≤a≤1000) b(1≤b≤1000) 和长度不超过 1e5 的 01 字符串。
//
//    你可以花费 a，把一段连续的 1 变成 0。
//    也可以花费 b，把一个 0 变成 1。
//    上述两种操作可以执行任意次。
//
//    输出把所有 1 都变成 0 的最小花费。

//    输入
//        2
//        1 1
//        01000010
//        5 1
//        01101110
//    输出
//        2
//        6


//    贪心。
//    如果没有第二种操作，那么答案就是 a * 连续 1 的段数。
//    第二种操作可以把两段连续 1 之间的 0 变成 1，这样两段 1 就合并成一段 1，可以减少一个 a 的花费。
//    如果两段连续 1 之间的 0 的个数 * b < a，那么把 0 变成 1 是更优的，否则不变更优。
    public static void solve() throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        int i = 0;
        int ans = a;
        while (i < n) {
            int st = i;
            char v = s[i];
            for (; i < n && s[i] == v; i++);
            if (v == '0' && st > 0 && i < n) {
                ans += Math.min(b * (i - st), a);
            }
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
