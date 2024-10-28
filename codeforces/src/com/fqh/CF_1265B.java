package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

public class CF_1265B {


//    https://codeforces.com/problemset/problem/1265/B
//
//    输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(1≤n≤2e5) 和一个 1~n 的排列 p。
//
//    对于每个长度 L=1,2,3,...,n，判断 p 是否存在一个长为 L 的连续子数组，包含 1~L 所有数字。
//
//    输出一个长为 n 的 01 字符串，依次表示 L=1,2,3,...,n 的答案，其中 0 表示 false，1 表示 true。

//    输入
//        3
//        6
//        4 5 1 3 2 6
//        5
//        5 3 1 2 4
//        4
//        1 4 3 2
//    输出
//        101011
//        11111
//        1001


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] idx = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            idx[a[i]] = i;
        }
        // 1-i之间的idx间距必须满足这种条件，1-i之间任意数字的下标差不能超过i
        // abs(mx[1-i] - idx[i]) <= i
        // abs(mn[i-1] - idx[i]) <= i
        // abs(mx[1-i] - mn[i-1]) < i
        int[] mx = new int[n+1];
        int[] mn = new int[n+1];
        mx[1] = idx[1];
        mn[1] = idx[1];
        for (int i = 2; i <= n; i++) {
            mx[i] = Math.max(mx[i-1], idx[i]);
            mn[i] = Math.min(mn[i-1], idx[i]);
        }

        var ans = new StringBuilder();
        ans.append(1);
        for (int i = 2; i <= n; i++) {
            int pos = idx[i];
            int max = mx[i];
            int min = mn[i];
            if (Math.abs(pos - max) > i || Math.abs(pos - min) > i || (max - min) >= i) {
                ans.append(0);
            } else {
                ans.append(1);
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
