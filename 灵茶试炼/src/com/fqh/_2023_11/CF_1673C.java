package com.fqh._2023_11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/14 11:40
 * @Version V1.0
 */
public class CF_1673C {


//    https://codeforces.com/problemset/problem/1673/C
//
//    输入 T(≤1e4) 表示 T 组数据。
//    每组数据输入 n(1≤n≤4e4)。
//    输出把 n 拆分成若干回文数之和的方案数。模 1e9+7。
//    例如 3 有 3 种方案：3, 2+1, 1+1+1。


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;
    static final int MAXNN = (int) 4e4;
    static final int MOD = (int) (1e9 + 7);

    static boolean ok;
    static List<Integer> list = new ArrayList<>();
//    static Integer[][] f;
    static int[] dp = new int[MAXNN + 1];
    // 预处理4e4的所有回文数
    static void init() {
        if (ok) return;
        for (int i = 1; i <= MAXNN; ++i) {
            if (i < 10) {
                list.add(i);
                continue;
            }
            String s = String.valueOf(i);
            int j = 0, k = s.length() - 1;
            boolean ok = true;
            while (j < k) {
                if (s.charAt(j) != s.charAt(k)) {
                    ok = false;
                    break;
                }
                j++;
                k--;
            }
            if (ok) list.add(i);
        }
//        f = new Integer[list.size() + 1][MAXNN + 1];
//        dfs(0, 1000);
        dp[0] = 1;
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 1; j <= MAXNN; ++j) {
                if (j < list.get(i)) continue;
                dp[j] = (dp[j] + dp[j - list.get(i)]) % MOD;
            }
        }
        ok = true;
    }

//    数据太强-记忆化爆栈
//    static int dfs(int pos, int n) {
//        if (n < 0) return 0;
//        if (n == 0) return 1;
//        if (f[pos][n] != null) return f[pos][n];
//        int ans = 0;
//        for (int i = pos; i < list.size(); ++i) {
//            if (list.get(i) > n) break;
//            ans += dfs(i, n - list.get(i));
//            ans %= MOD;
//        }
//        return f[pos][n] = ans;
//    }

    static void solve() throws Exception {
        int n = in.nextInt();
        out.println(dp[n] % MOD);
    }

    public static void main(String[] args) throws Exception {
        init();
        int T = in.nextInt();
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
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
