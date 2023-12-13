package com.fqh.分组循环;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/13 15:11
 * @Version V1.0
 */
public class CF_620C {

//    https://codeforces.com/problemset/problem/620/C
//
//    输入 n(1≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
//
//    把 a 划分成尽量多的段，使得每一段都有重复数字。
//
//    如果无法做到，输出 -1。
//    否则，输出的第一行是段数 k，然后输出 k 行，表示每一段的开始和结束下标（下标从 1 开始）。
//    可以按任意顺序输出这些段。

//    输入
//5
//        1 2 3 4 1
//    输出
//1
//        1 5
//
//    输入
//5
//        1 2 3 4 5
//    输出 -1
//
//    输入
//7
//        1 2 1 3 1 2 1
//    输出
//2
//        1 3
//        4 7


    static final int MAXN = 300010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static List<int[]> f() {
        List<int[]> ans = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            int st = i;
            var set = new HashSet<Integer>();
            set.add(a[st]);
            for (i++; i <= n && set.add(a[i]); i++) ;
            if (i > n) {
                if (ans.size() == 0) {
                    return ans;
                }
                ans.get(ans.size() - 1)[1] = n;
            } else {
                ans.add(new int[]{st, i});
                i += 1;
            }
        }
        return ans;
    }

    static void solve() throws Exception {
        n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();
        }
        List<int[]> ans = f();
        if (ans.size() == 0) {
            out.println(-1);
        } else {
            out.println(ans.size());
            ans.forEach(e -> out.println(e[0] + " " + e[1]));
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
