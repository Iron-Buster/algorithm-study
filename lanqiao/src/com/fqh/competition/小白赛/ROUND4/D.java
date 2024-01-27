package com.fqh.competition.小白赛.ROUND4;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/27 20:24
 **/
public class D {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        var map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            a[i] = x;
            int right_most = -1;
            for (int j = a[i] - 365; j <= a[i] + 365; j++) {
                if (map.containsKey(j)) {
                    right_most = Math.max(right_most, map.get(j));
                }
            }
            b[i] = right_most;
            map.put(a[i], i);
        }
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) {
            f[i] = Math.max(f[i-1], b[i]);
        }
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            if (f[r] == -1) {
                out.println("NO");
            } else {
                if (f[r] >= l) out.println("YES");
                else out.println("NO");
            }
        }
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
