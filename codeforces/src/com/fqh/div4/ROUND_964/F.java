package com.fqh.div4.ROUND_964;

import java.io.*;
import java.util.StringTokenizer;

public class F {

    // https://codeforces.com/contest/1999/problem/F
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int[] g = new int[2];
        for (int x : a) g[x]++;
        Bigmod ret = Bigmod.valueOf(0);
        for (int i = m / 2 + 1; i <= m; i++) {
            if (g[1] < i) continue;
            if (g[0] < m - i) continue;
            // C(g[1], i) * C(g[0], m-i)
            ret.add(Bigmod.valueOf(Bigmod.C(g[1], i)).mul(Bigmod.C(g[0], m - i)));
        }
        out.println(ret);
    }

    static {
        Bigmod.reset(false, 300300);
    }

    static
    class Bigmod {
        static long M9 = 998244353L, M1 = 1000_000_007L;
        static long M = 0;
        static int MAXN = -1;
        static long[] cacheStepmul;
        static long[] cacheStepmulInv;
        static long[] exp2;
        long num = 0;

        // TODO: reset this before anything.
        static void reset(boolean use998, int maxN) {
            // 300300
            M = use998 ? M9 : M1;
            MAXN = maxN;
            cacheStepmul = new long[MAXN];
            cacheStepmulInv = new long[MAXN];
            exp2 = new long[MAXN];
        }

        Bigmod(long num) {
            if (num >= 0) {
                this.num = num % M;
            } else {
                this.num = M - (-num) % M;
            }
        }

        static Bigmod valueOf(long num) {
            return new Bigmod(num);
        }

        @Override
        public String toString() {
            return Long.toString(num);
        }

        Bigmod add(long x) {
            if (x > 0) {
                num = (num + x % M) % M;
            } else if (x < 0) {
                num = (num - (-x) % M + M) % M;
            }
            return this;
        }

        Bigmod add(Bigmod bm) {
            return add(bm.num);
        }

        Bigmod sub(long x) {
            return add(-x);
        }

        Bigmod sub(Bigmod bm) {
            return add(-bm.num);
        }

        Bigmod mul(long x) {
            num = num * (x % M) % M;
            return this;
        }

        Bigmod mul(Bigmod bm) {
            return mul(bm.num);
        }

        Bigmod div(long x) {
            if (x == 0) throw new RuntimeException("cannot div 0.");
            return mul(exp(x, M - 2));
        }

        Bigmod div(Bigmod bm) {
            return div(bm.num);
        }

        Bigmod exp(long p) {
            long ret = 1L, baseLong = num % M;
            for (int i = 0; i <= 60 && p > 0; ++i) { //1<<30=1073741824
                if ((p & (1L << i)) > 0) {
                    ret = ret * baseLong % M;
                    p ^= (1L << i);
                }
                baseLong = baseLong * baseLong % M;
            }
            if (p != 0) throw new RuntimeException("p should reduced to 0 in exp.");
            num = ret;
            return this;
        }

        Bigmod exp(Bigmod bm) {
            return exp(bm.num);
        }

        static long exp(long x, long p) {
            return new Bigmod(x).exp(p).num;
        }

        static long C(long n, long m) {
            if (n < 0 || m < 0) throw new RuntimeException("n/m cannot be negative in C(n,m).");
            if (n < m) throw new RuntimeException("n is less than m in C(n,m).");
            if (n == 0) return 1;
            if (m == 0 || m == n) return 1;
            return new Bigmod(P(n, m)).mul(stepmulInv(m)).num;
        }

        static long P(long n, long m) {
            if (n < 0 || m < 0) throw new RuntimeException("n/m cannot be negative in P(n,m).");
            if (n < m) throw new RuntimeException("n is less than m in P(n,m).");
            if (n == 0) return 1;
            if (n < cacheStepmul.length) {
                // P(n,m)=n!/(n-m)!
                return new Bigmod(stepmul(n)).mul(stepmulInv(n - m)).num;
            }
            // NOTE: O(m) complexity when n is large.
            Bigmod r = new Bigmod(1);
            long val = n;
            for (long i = 0; i < m; ++i) r.mul(val--);
            return r.num;
        }

        static long stepmul(long n) { // n!
            if (n >= cacheStepmul.length) throw new RuntimeException("overflow cacheSm size.");
            if (cacheStepmul[0] == 0) {
                cacheStepmul[0] = 1;
                cacheStepmulInv[0] = exp(cacheStepmul[0], M - 2);
                for (int i = 1; i < cacheStepmul.length; ++i) {
                    cacheStepmul[i] = cacheStepmul[i - 1] * i % M;
                    cacheStepmulInv[i] = exp(cacheStepmul[i], M - 2);
                }
            }
            return cacheStepmul[(int) n];
        }

        static long stepmulInv(long n) {
            if (cacheStepmulInv[1] == 0) stepmul(2);
            return cacheStepmulInv[(int) n];
        }

        static long exp2(long n) { // 2^n
            if (n >= exp2.length) throw new RuntimeException("overflow exp2 size.");
            if (exp2[0] == 0) {
                exp2[0] = 1;
                for (int i = 1; i < exp2.length; ++i)
                    exp2[i] = exp2[i - 1] * 2 % M;
            }
            return exp2[(int) n];
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
