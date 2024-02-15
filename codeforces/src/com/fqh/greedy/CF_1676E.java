package com.fqh.greedy;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/15 14:58
 **/
public class CF_1676E {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        Arrays.sort(a);
        long suffix_sum = 0;
        int cnt = 0;
        TreeSet<PII> tset = new TreeSet<>((o1, o2) -> Long.compare(o1.first, o2.first));
        for (int i = n - 1; i >= 0; i--) {
            suffix_sum += a[i];
            ++cnt;
            tset.add(new PII(suffix_sum, cnt));
        }
        while (q-- > 0) {
            long x = in.nextLong();
            PII ceiling = tset.ceiling(new PII(x, 0));
            if (ceiling == null) {
                out.println(-1);
                continue;
            }
            out.println(ceiling.second);
        }
    }

    static class PII {
        long first;
        int second;

        public PII(long first, int second) {
            this.first = first;
            this.second = second;
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
