package com.fqh.meituan;

import java.io.*;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/17 23:26
 **/
public class P1703 {

//    https://codefun2000.com/p/P1703
//#P1703. 2024.3.16美团-第三题-乘2

    // 取模快速幂
//    static int ksmM(int x, int n, int p) {
//        x %= p;
//        int res = 1 % p;
//        while (n > 0) {
//            if (n % 2 > 0) {
//                res = res * x % p;
//            }
//            x = x * x % p;
//            n /= 2;
//        }
//        return res;
//    }

    static final BigInteger MOD = BigInteger.valueOf(1000000007);

    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        long[] a = new long[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            cnt[i] = q;
        }
        while (q-- > 0) {
            int k = in.nextInt() - 1;
            cnt[k] -= 1;
        }
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            BigInteger two = BigInteger.TWO;
            BigInteger y = BigInteger.valueOf(cnt[i]);
            BigInteger v = BigInteger.valueOf(a[i]).multiply(two.modPow(y, MOD));
            ans = ans.add(v);
        }
        ans = ans.mod(MOD);
        out.println(ans.longValue());
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
