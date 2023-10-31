package com.fqh._2023_10;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/10/31 13:06
 * @Version V1.0
 */
public class CF_1180B {

//    https://codeforces.com/problemset/problem/1180/B
//
//    输入 n(1≤n≤1e5) 和长为 n 的数组 a(-1e6≤a[i]≤1e6)。
//    你可以执行如下操作任意次：
//    选择一个 a[i]，把它替换为 -a[i]-1。
//    你需要让所有数的乘积最大。
//    输出修改后的数组。

//    输入
//        4
//        2 2 2
//    输出 -3 -3 -3
//
//    输入
//        1
//        0
//    输出 0
//
//    输入
//        3
//        -3 -3 2
//    输出 -3 -3 2


//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 0X3F题解 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    只看绝对值的话，对非负数操作是更优的。
//    操作后所有元素都是负数了。
//    如果 n 是偶数，那么这样就行。
//    如果 n 是奇数，需要选一个绝对值最大的负数操作一下。最大的负数绝对值-1是最优的
//
//    https://codeforces.com/contest/1180/submission/230002609

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    static void solve() throws Exception {
        int n = in.nextInt();
        int idx = 0;
        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();
            if (a[i] >= 0) a[i] = -a[i] - 1;
            if (a[i] < a[idx]) idx = i;
        }
        if (n % 2 != 0) {
            a[idx] = -a[idx] - 1;
        }
        for (int i = 1; i <= n; ++i) {
            out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) {
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
