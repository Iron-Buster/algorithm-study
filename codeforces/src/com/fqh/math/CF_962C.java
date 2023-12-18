package com.fqh.math;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/18 10:27
 * @Version V1.0
 */
public class CF_962C {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

//    https://codeforces.com/contest/962/problem/C
//
//    输入 n(1≤n≤1e9)。
//    每次操作，你可以删除 n 的一个数字。需要保证删除后 n 仍然是一个没有前导零的正整数。
//    你可以操作任意次。
//    问：把 n 变成一个完全平方数，至少需要操作几次？
//    输出操作次数。如果无法做到，输出 -1。

//    输入 8314
//    输出 2
//    解释 删除 3 和 4，得到 81
//
//    输入 625
//    输出 0
//    解释 625 已经是完全平方数了
//
//    输入 333
//    输出 -1


    static boolean isSQ(int x) {
        int rt = (int) Math.sqrt(x);
        return rt * rt == x;
    }


//    二进制枚举保留哪些数（或者 DFS 选或不选）。注意第一个数不能是 0。

    // 二进制枚举
    static void solve() throws Exception {
        String str = in.nextLine();
        int ans = Integer.MAX_VALUE;
        int n = str.length();
        out: for (int b = 1; b < (1 << n); b++) {
            int val = 0;
            int index = 0;
            while (index < n) {
                if ((b >> (n - 1 - index) & 1) == 0) {
                    index++;
                    continue;
                }
                if (str.charAt(index) == '0') continue out;
                else break;
            }
            int mul = 1;
            for (int i = n - 1; i >= index; i--) {
                if ((b >> (n - 1 - i) & 1) == 0) continue;
                val += mul * (str.charAt(i) - '0');
                mul *= 10;
            }
            if (isSQ(val)) {
                ans = Math.min(ans, n - Integer.bitCount(b));
            }
        }
        if (ans == Integer.MAX_VALUE) out.println(-1);
        else out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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
