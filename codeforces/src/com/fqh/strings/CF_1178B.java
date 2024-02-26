package com.fqh.strings;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/26 20:16
 **/
public class CF_1178B {


//    https://codeforces.com/problemset/problem/1178/B
//    输入一个长度 ≤1e6 的字符串 s，只包含小写字母 'v' 和 'o'。
//    把 s 中的两个相邻的 v 视作一个 w。
//    输出有多少个 wow 子序列。
//    注意：子序列不一定连续。子序列中的 w 必须由 s 中的相邻 v 组成。

//    输入 vvvovvv
//    输出 4
//
//    输入 vvovooovovvovoovoovvvvovovvvov
//    输出 100

    // 前后缀分解处理出w的个数，然后枚举o 根据乘法原理 wow等于 左边w个数 * 右边w个数
    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = a[i-1];
            if (s[i] == 'v' && s[i-1] == 'v') a[i] += 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            b[i] = b[i+1];
            if (s[i] == 'v' && s[i+1] == 'v') b[i] += 1;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'o') ans += (long) a[i] * b[i];
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
