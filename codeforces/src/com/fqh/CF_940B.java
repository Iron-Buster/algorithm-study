package com.fqh;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/22 20:07
 **/
public class CF_940B {
//    https://codeforces.com/problemset/problem/940/B
//
//    输入 n k a b (1≤n,k,a,b≤2e9)。
//
//    有两种操作：
//    花费 a，把 n 减一。
//    如果 n 是 k 的倍数，花费 b，把 n 变成 n/k。
//
//    输出把 n 变成 1 的最小总花费。
//
//    相似题目：
//            1553. 吃掉 N 个橘子的最少天数
//397. 整数替换

    static long n, k, a, b;
    static HashMap<Long, Long> dp;

    public static long dfs(long x) {
        if (x < k) return (x - 1) * a;
        if (dp.containsKey(x)) return dp.get(x);
        long cnt = x % k;                        // 让x是k的倍数所需要的操作次数
        long res1 = (x - 1) * a;                 // 全部用操作a
        long res2 = cnt * a + dfs(x / k) + b; // 先cnt个操作a 然后用操作b
        long ans = Math.min(res1, res2);
        dp.put(x, ans);
        return ans;
    }

    public static void solve() throws IOException {
        n = in.nextLong();
        k = in.nextLong();
        a = in.nextLong();
        b = in.nextLong();
        dp = new HashMap<>();
        if (k == 1) {
            out.println((n - 1) * a);
            return;
        }
        out.println(dfs(n));
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
