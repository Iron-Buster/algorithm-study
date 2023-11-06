package com.fqh._2023_11;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/6 9:31
 * @Version V1.0
 */
public class CF_816B {

//    https://codeforces.com/problemset/problem/816/B
//
//    输入 n k(1≤k≤n≤2e5) q(1≤q≤2e5)。
//    然后输入 n 个 recipe，每个 recipe 输入两个数 L R(1≤L≤R≤2e5)，表示冲一杯咖啡的推荐温度范围为 [L,R]。
//    定义一个整数温度 t 是「可接受的」，如果 t 包含在至少 k 个 recipe 的推荐温度范围内。
//    然后输入 q 个询问，每个询问输入两个数 a b(1≤a≤b≤2e5)，输出 [a,b] 内有多少个温度是可接受的，每行一个答案。
//
//    进阶：如果 k 是每个询问输入的数呢？@liupengsay

//    输入
//        3 2 4
//        91 94
//        92 97
//        97 99
//        92 94
//        93 97
//        95 96
//        90 100
//    输出
//        3
//        3
//        0
//        4
//
//    输入
//        2 1 1
//        1 1
//        200000 200000
//        90 100
//    输出 0

//    用差分数组维护区间 +1 操作。
//    然后还原数组，用前缀和统计还原后的数组的每个前缀有多少 >=k 的数。
//    这样就可以 O(1) 回答每个询问了。
//
//    https://codeforces.com/problemset/submission/816/231059531

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static void solve() throws Exception {
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        var diff = new int[200010];
        var s = new int[200020];
        for (int i = 0; i < n; ++i) {
            int left = in.nextInt();
            int right = in.nextInt();
            diff[left]++;
            diff[right + 1]--;
        }
        int sd = 0; // 差分数组的前缀和
        for (int i = 0; i < diff.length; ++i) {
            sd += diff[i];
            s[i + 1] = s[i];
            if (sd >= k) s[i + 1]++;
        }
        while (q-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            out.println(s[b + 1] - s[a]);
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
