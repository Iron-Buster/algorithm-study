package com.fqh.competition.小白赛.ROUND2;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/23 18:57
 * @Version V1.0
 */
public class C {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static boolean ok = false;
    static TreeSet<Integer> primes = new TreeSet<>();

    static void sieve() {
        if (ok) return;
        int mx = (int) 1e6;
        // 或者，只是单纯想标记一下
        var set = new HashSet<Long>();
        for (long i = 2; i <= mx; i++) {
            if (!set.contains(i)) {
                primes.add((int) i);
                set.add(i);
                for (long j = i * i; j <= mx; j += i) {
                    set.add(j);
                }
            }
        }
        ok = true;
    }

    static void solve() throws Exception {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Integer floor = primes.floor(a[i]);
            Integer ceiling = primes.ceiling(a[i]);
            if (floor != null && ceiling != null) {
                ans += Math.min(Math.abs(a[i] - floor), Math.abs(a[i] - ceiling));
            } else if (floor != null) {
                ans += Math.abs(a[i] - floor);
            } else {
                ans += Math.abs(a[i] - ceiling);
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        sieve();
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
