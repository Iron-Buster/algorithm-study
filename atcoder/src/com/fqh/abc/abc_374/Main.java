package com.fqh.abc.abc_374;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class A {
        public static void solve() throws IOException {
            String s = in.nextLine();
            System.out.println(s.endsWith("san") ? "Yes" : "No");
        }

    }

    static class B {
        public static void solve() throws IOException {
            String a = in.nextLine();
            String b = in.nextLine();
            if (a.equals(b)) {
                out.println(0);
                return;
            }
            int mn = Math.min(a.length(), b.length());
            for (int i = 0; i < mn; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    out.println(i + 1);
                    return;
                }
            }
            out.println(mn + 1);
        }

    }


    static class C {
        public static void solve() throws IOException {
            int n = in.nextInt();
            long[] a = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                sum += a[i];
            }
            long ans = Long.MAX_VALUE;
            for (int s = 0; s < (1 << n); s++) {
                long sumA = 0;
                for (int i = 0; i < n; i++) {
                    if ((s & (1 << i)) != 0) {
                        sumA += a[i];
                    }
                }
                long sumB = sum - sumA;
                ans = Math.min(ans, Math.max(sumA, sumB));

            }
            out.println(ans);
        }

    }

    // TODO
    static class D {
        public static void solve() throws IOException {
            int n = in.nextInt();
            double s = in.nextDouble();
            double t = in.nextDouble();

            double[][] segs = new double[n][4];
            for (int i = 0; i < n; i++) {
                segs[i][0] = in.nextDouble();
                segs[i][1] = in.nextDouble();
                segs[i][2] = in.nextDouble();
                segs[i][3] = in.nextDouble();
            }


        }

        static double dis(double x1, double y1, double x2, double y2) {
            return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        }
    }

    // TODO
    static class E {

        static boolean chcek(int n, int x, long w, long[][] a) {
            long tot = 0;
            for (int i = 0; i < n; i++) {
                long ai = a[i][0];
                long pi = a[i][1];
                long bi = a[i][2];
                long qi = a[i][3];

                long mn = Long.MAX_VALUE;
                for (long scnt = 0; scnt <= (w + ai - 1) / ai; scnt++) {
                    long remain = Math.max(0, w - scnt * ai);
                    long tcnt = remain > 0 ? (remain + bi - 1) / bi : 0;
                    long cost = scnt * pi + tcnt * qi;
                    mn = Math.min(mn, cost);
                    if (cost > x) break;
                }
                tot += mn;
                if (tot > x) return false;
            }
            return tot <= x;
        }
        public static void solve() throws IOException {
            int n = in.nextInt();
            int x = in.nextInt();
            long[][] a = new long[n][4];
            long mx = 0;
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextLong();
                a[i][1] = in.nextLong();
                a[i][2] = in.nextLong();
                a[i][3] = in.nextLong();
                mx = Math.max(mx, Math.max(a[i][0], a[i][2]));
            }
            long l = 0;
            long r = (long) x * mx;
            long ans = 0;
            while (l <= r) {
                long mid = (l + r) / 2;
                if (chcek(n, x, mid, a)) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            out.println(ans);
        }

    }

    public static void solve() throws IOException {

    }

    static boolean MULTI_CASE = false;

    public static void main(String[] args) throws Exception {
        int T = MULTI_CASE ? in.nextInt() : 1;
        while (T-- > 0) {
            E.solve();
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
