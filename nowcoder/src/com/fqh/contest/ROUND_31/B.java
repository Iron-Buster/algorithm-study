package com.fqh.contest.ROUND_31;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/5 11:11
 **/
public class B {

    public static List<Long> primeDivisors(long x) {
        List<Long> primes = new ArrayList<>();
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) { // 如果 i 能够整除 x，说明 i 为 x 的一个质因子。
                int s = 0; //
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                primes.add((long) i);
            }
        }
        if (x > 1) { // 说明再经过操作之后 x 留下了一个素数
            primes.add(x);
        }
        return primes;
    }

    public static void solve() throws IOException {
        long x = in.nextLong();
        List<Long> divisors = primeDivisors(x);
        out.println(divisors.size());
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
