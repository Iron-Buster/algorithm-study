package com.fqh;

import java.io.*;
import java.util.*;

public class CF_1345B {


//    http://codeforces.com/problemset/problem/1354/B
//
//    输入 T(≤2e4) 表示 T 组数据。所有数据的字符串长度之和 ≤2e5。
//    每组数据输入一个长度 ≤2e5 的字符串 s，只包含数字 '1' '2' '3'。
//
//    输出 s 中的最短子串的长度，该子串必须包含所有 '1' '2' '3' 三种字符。
//    如果没有这样的子串，输出 0。

    // 滑动窗口求最短
    public static void solve() throws Exception {
        var s = in.nextLine();
        int n = s.length();
        int[] map = new int['9'];
        int j = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)]++;
            while (j < i && map['1'] >= 1 && map['2'] >= 1 && map['3'] >= 1) {
                ans = Math.min(ans, i - j + 1);
                map[s.charAt(j)]--;
                j++;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            out.println(0);
        } else {
            out.println(ans);
        }
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
