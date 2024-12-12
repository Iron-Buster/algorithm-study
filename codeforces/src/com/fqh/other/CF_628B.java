package com.fqh.other;


import java.io.*;
import java.util.StringTokenizer;

public class CF_628B {


//    https://codeforces.com/problemset/problem/628/B
//
//    输入一个长度 ≤3e5 的数字字符串 s。
//    输出 s 有多少个连续且非空的子串是 4 的倍数。
//    允许子串有前导零。

//    输入 124
//    输出 4
//    解释 12,4,24,24
//
//    输入 04
//    输出 3
//    解释 0,4,04
//
//    输入 5810438174
//    输出 9

    public static void solve() throws IOException {
        String s = in.nextLine();
        // 4的倍数最后两位数字一定能被4整除
        int n = s.length();
        long ans = 0;
        // 考虑长度为2的子串
        for (int i = 0; i < n - 1; i++) {
            String t = s.substring(i, i + 2);
            // 计算的是以t结尾的子串数量 所有要乘上左边的字符个数 (i+1)
            ans += (Integer.parseInt(t) % 4 == 0 ? 1 : 0) * (i + 1);
        }
        // 考虑长度为1的子串
        for (int i = 0; i < n; i++) {
            ans += (s.charAt(i) - '0') % 4 == 0 ? 1 : 0;
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
