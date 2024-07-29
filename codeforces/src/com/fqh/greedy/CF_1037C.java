package com.fqh.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class CF_1037C {

//    https://codeforces.com/problemset/problem/1037/C
//
//    输入 n(1≤n≤1e6) 和两个长为 n 的 01 字符串 s 和 t。
//
//    有两种操作，每种操作都可以执行任意次。
//            1. 交换 s[i] 和 s[j]，代价为 |i-j|。
//            2. 翻转 s[i]，即 0 变为 1，1 变为 0，代价为 1。
//
//    输出把 s 变成 t 的最小总代价。



//    6
//            110110
//            000000
//    Output 4

    public static void solve() throws IOException {
        int n = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        char[] t = in.nextLine().toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 0 1
            // 1 0
            // 这种情况下 明显交换s[i]和s[i+1]比 翻转s[i]和s[i+1]代价小
            // 其余的全部翻转
            if (s[i] == t[i]) continue;
            if (i + 1 < n && (s[i+1] != t[i+1] && s[i] != s[i+1] && t[i] != t[i+1])) {
                // swap i,i+1
                ans++;
                i++;
            } else {
                ans++;
            }
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
