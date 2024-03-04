package com.fqh.jd;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/4 14:39
 **/
public class P1674 {

    //  #P1674. 2024.03.02-京东春招第二题-素数三元组
    // https://codefun2000.com/p/P1674

    static int n;
    static boolean[] vis;

    public static void solve() throws IOException {
        n = in.nextInt();
        // 或者，只是单纯想标记一
        vis = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        TreeSet<Long> tset = new TreeSet<>();
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                primes.add(i);
                tset.add((long) i);
                vis[i] = true;
                for (int j = 2 * i; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
        long ans = 0;
        for (int k = 0; k < primes.size(); k++) { // C
            long x = (long) primes.get(k) * primes.get(k);
            if (x > primes.get(primes.size() - 1) * 2) break;
            for (int i = 0; i < primes.size(); i++) { // A
                long y = x - primes.get(i);
                if (tset.contains(y)) ans++;
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
