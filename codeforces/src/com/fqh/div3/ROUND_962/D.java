package com.fqh.div3.ROUND_962;

import java.io.*;
import java.util.StringTokenizer;

public class D {
    // 1<=(n,x)<=1e6
    // ab + ac + bc <= n 并且 a + b + c < x
    // 求满足条件的 三元组(a,b,c)个数
    public static void solve() throws IOException {
        int n = in.nextInt();
        int x = in.nextInt();
        long ans = 0;
        // 枚举a,b
        for (int a = 1; a < x; a++) {
            for (int b = 1; b < x; b++) {
                if (a + b >= x) break;
                if (a * b > n) break;
                int remain = (n - a * b) / (a + b);
                remain = Math.min(remain, x - a - b);
                if (remain > 0) ans += remain;
            }
        }
        out.println(ans);
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
