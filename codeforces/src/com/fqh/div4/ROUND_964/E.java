package com.fqh.div4.ROUND_964;

import java.io.*;
import java.util.StringTokenizer;

public class E {

    // https://codeforces.com/contest/1999/problem/E
    // l变成0的次数肯定是最小的
    // 首先l当作y，然后任意一个数当作x，l变为0的次数为cntL * 2
    // 取l当作x，然后[l+1,r]当作y
    static int[] sum = new int[200001];
    static int[] cnt = new int[200001];

    static {
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = f(i);
        }
        for (int i = 1; i < cnt.length; i++) {
            sum[i] = cnt[i];
            sum[i] += sum[i - 1];
        }
    }

    static int f(int x) {
        int r = 0;
        while (x > 0) {
            x /= 3;
            r++;
        }
        return r;
    }

    public static void solve() throws IOException {
        int l = in.nextInt();
        int r = in.nextInt();
        out.println(sum[r] - sum[l - 1] + cnt[l]);
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
