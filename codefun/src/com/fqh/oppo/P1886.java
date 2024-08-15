package com.fqh.oppo;

import java.io.*;
import java.util.StringTokenizer;

public class P1886 {


    //https://codefun2000.com/p/P1886

    // 111455
    // 统计前缀11 和 后缀5的个数
    // 然后枚举 4 乘法原理算一下
    static final int MOD = (int) (1e9 + 7);

    public static void solve() throws IOException {
        int n = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int cnt1 = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == '1' && s[i-1] == '1') {
                cnt1++;
            }
            a[i] = cnt1;
        }
        int cnt5 = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '5') {
                cnt5++;
            }
            b[i] = cnt5;
        }
        long ans = 0;
        for (int i = 2; i < n - 1; i++) {
            if (s[i] == '4') {
                ans += (long) a[i] * b[i];
                ans %= MOD;
            }
        }
        out.println(ans);
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
