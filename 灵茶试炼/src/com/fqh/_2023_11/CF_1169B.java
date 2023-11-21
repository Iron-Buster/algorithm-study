package com.fqh._2023_11;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/21 22:43
 * @Version V1.0
 */
public class CF_1169B {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;


//    https://codeforces.com/problemset/problem/1169/B
//
//    输入 n(2≤n≤3e5) m(1≤m≤3e5) 和 m 个数对 (a[i],b[i])，元素范围 [1,n] 且 a[i] != b[i]。
//    能否找到两个数 x 和 y，使得每个数对中至少有一个数是 x 或者是 y？
//    输出 YES 或 NO。


//    提示 1：逆向思维：在第一个数对中，肯定有 x 或 y。
//
//    提示 2：枚举 x=a[0] 或者 x=b[0]，向后寻找，如果有一对数 (a[i],b[i]) 不包含 x，那么 y 肯定在这对数当中。
//
//    提示 3：枚举 y=a[i] 或者 y=b[i]，继续向后寻找，如果后面的数对都包含 x 或 y，则输出 YES。
//    如果所有的枚举都没有输出 YES，则输出 NO。
//
//    推荐用递归实现，非常简洁。
//    该方法可以推广至每个数对都包含 3 个数中的一个的情况。更多的数也同理。
//
//    https://codeforces.com/contest/1169/submission/232804200

    static boolean dfs(int x, int y) {
        for (int i = 0; i < m; ++i) {
            if (a[i] == x || a[i] == y || b[i] == x || b[i] == y) {
                continue;
            }
            if (y > 0) return false;
            return dfs(x, a[i]) || dfs(x, b[i]);
        }
        return true;
    }

    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; ++i) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        if (dfs(a[0], 0) || dfs(b[0], 0)) {
            out.println("YES");
        } else {
            out.println("NO");
        }
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
