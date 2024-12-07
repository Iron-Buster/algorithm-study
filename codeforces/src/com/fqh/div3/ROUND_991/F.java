package com.fqh.div3.ROUND_991;


import java.io.*;
import java.util.StringTokenizer;

public class F {

    // https://codeforces.com/contest/2050/problem/F
    // a[i] % m = a[i+1] % m = (a[i+1] - a[i]) % m
    // st表维护区间GCD
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        int m = n - 1;
        int[] a = new int[n];
        int[] d = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            d[i] = Math.abs(a[i+1] - a[i]);
        }
        var st = new SparseTableGCD(d);
        var ans = new StringBuilder();
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            if (l == r) {
                ans.append(0).append(" ");
                continue;
            }
            l -= 1;
            r -= 2;
            int res = st.query(l, r);
            ans.append(res).append(" ");
        }

        out.println(ans);
    }

    // ST表维护区间GCD
    static class SparseTableGCD {
        private int[][] st; // st[i][j] 表示区间 [i, i + 2^j - 1] 的最大值
        private int[] log;
        private int n;

        public SparseTableGCD(int[] arr) {
            n = arr.length;
            int logN = Integer.highestOneBit(n) * 2 - 1; // log2(n)
            log = new int[n + 1];
            st = new int[n][20];

            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            for (int i = 0; i < n; i++) {
                st[i][0] = arr[i];
            }

            // 构建 st表
            for (int j = 1; (1 << j) <= n; j++) {
                for (int i = 0; i + (1 << j) - 1 < n; i++) {
                    st[i][j] = gcd(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        // 查询区间 [L, R] 的最大值
        public int query(int L, int R) {
            int j = log[R - L + 1];
            return gcd(st[L][j], st[R - (1 << j) + 1][j]);
        }

        // 计算两个数的 GCD
        public int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
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
