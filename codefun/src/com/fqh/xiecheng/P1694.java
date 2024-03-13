package com.fqh.xiecheng;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/13 23:58
 **/
public class P1694 {

//     #P1694. 2024.03.13-携程-第二题-相同的数
//    https://codefun2000.com/p/P1694


    public static void solve() throws IOException {
        // 带着下标排序，枚举最后变成了哪个数字，然后前缀和计算次数
        int n = in.nextInt();
        PII[] p = new PII[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            p[i] = new PII(i, x);
        }
        Arrays.sort(p, (a, b) -> Long.compare(a.val, b.val));
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + p[i].val;
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long v1 = i * p[i].val - s[i];
            long v2 = s[n] - s[i+1] - (n - i - 1) * p[i].val;
            ans[p[i].idx] = v1 + v2;
        }
        for (long x : ans) out.println(x);
    }

    static class PII {
        int idx;
        long val;

        public PII(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }
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
