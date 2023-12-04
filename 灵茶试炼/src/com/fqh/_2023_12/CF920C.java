package com.fqh._2023_12;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/4 17:26
 * @Version V1.0
 */
public class CF920C {

//    https://codeforces.com/problemset/problem/920/C
//
//    输入 n(1≤n≤3e5) 和一个 1~n 的排列 a，然后输入一个长为 n-1 的 01 字符串 s。
//    s[i]=1 表示你可以交换 a[i] 和 a[i+1]（交换次数不限），s[i]=0 表示不能交换 a[i] 和 a[i+1]。
//    判断能否把 a 变成递增的。输出 YES 或 NO。


//    分组循环找 s 的连续 1 段，然后把这段对应的子数组排序。（邻项交换=冒泡排序）
//    最后判断 a 是否有序。

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        String s = in.nextLine();
        char[] ss = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (ss[i] == '0') {
                continue;
            }
            int st = i;
            for (i++; i < n - 1 && ss[i] == '1'; i++) ;
            Arrays.sort(a, st, i + 1);
        }
        boolean ok = true;
        for (int i = 1; i < n; ++i) {
            if (a[i] < a[i - 1]) {
                ok = false;
                break;
            }
        }
        if (ok) {
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
