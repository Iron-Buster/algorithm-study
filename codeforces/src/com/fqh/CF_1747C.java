package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/5 12:25
 **/
public class CF_1747C {

//    https://codeforces.com/problemset/problem/1747/C
//
//    输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，下标从 1 开始。
//
//    Alice 和 Bob 玩回合制游戏，Alice 先。
//    每回合，如果 a1=0，那么当前玩家输掉游戏，对手获胜。
//    否则当前玩家把 a1 减少一，然后选择一个下标在 [2,n] 中的数字和 a1 交换。
//
//    双方都以最佳方式游戏，输出最后谁赢了。

//    输入
//        3
//        2
//        1 1
//        2
//        2 1
//        3
//        5 4 4
//    输出
//            Bob
//            Alice
//            Alice

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int x = a[0];
        int y = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) y = Math.min(y, a[i]);
        if (x > y) {
            out.println("Alice");
        } else {
            out.println("Bob");
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
