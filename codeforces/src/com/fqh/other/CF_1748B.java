package com.fqh.other;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 10:46
 **/
public class CF_1748B {

//    https://codeforces.com/problemset/problem/1748/B
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
//    每组数据输入 n(1≤n≤1e5) 和长为 n 字符串 s，只包含字符 '0' 到 '9'。
//
//    输出 s 有多少个连续子串 t，满足 t 中每个字符的出现次数，都不超过 t 中的字符种类数。


//    输入
//        7
//        1
//        7
//        2
//        77
//        4
//        1010
//        5
//        01100
//        6
//        399996
//        5
//        23456
//        18
//        789987887987998798
//    输出
//        1
//        2
//        10
//        12
//        10
//        15
//        106

    public static void solve() throws IOException {
        int n = in.nextInt();
        String s = in.nextLine();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] map = new int[10];
            int cnt = 0; // 种类数 最多10种
            int mxC = 0; // 出现次数最多的
            for (int j = 0; j < Math.min(100, n - i); j++) { // 最坏情况是的子串长度 < 100
                char c = s.charAt(j+i);
                map[c-'0']++;
                if (map[c-'0'] == 1) cnt++;
                mxC = Math.max(mxC, map[c-'0']);
                if (cnt >= mxC) ans++;
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
