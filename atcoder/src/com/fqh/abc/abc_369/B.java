package com.fqh.abc.abc_369;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    // 卡住了

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] s = line.split(" ");
            a[i] = Integer.parseInt(s[0]);
        }
        int ans = 0;
        int s1 = a[0], s2 = a[1];
        for (int i = 2; i < n; i += 2) {
            if (i + 1 < n) {
                int v1 = a[i], v2 = a[i+1];
                if (Math.abs(v1 - s1) < Math.abs(v2 - s1)) {
                    ans += Math.abs(v1 - s1);
                    ans += Math.abs(v2 - s2);
                } else {
                    ans += Math.abs(v1 - s2);
                    ans += Math.abs(v2 - s1);
                }
                s1 = a[i];
                s2 = a[i+1];
            } else {
                ans += Math.min(Math.abs(a[0] - s1), Math.abs(a[0] - s2));
                s1 = a[i];
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
