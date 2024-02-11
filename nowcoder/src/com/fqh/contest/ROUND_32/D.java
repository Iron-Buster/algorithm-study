package com.fqh.contest.ROUND_32;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/11 18:43
 **/
public class D {

    static int n;
    static int[] a;
    static List<Integer>[] g;
    static long[] f;

    static long dfs(int x) {
        long res = 0;
        for (int y : g[x]) {
            res += dfs(y);
        }
        f[x] = res;
        return res + a[x];
    }
    public static void solve() throws IOException {
        n = in.nextInt();
        g = new List[n+1];
        f = new long[n+1];
        a = new int[n+1];
        Arrays.setAll(g, v -> new ArrayList<>());
        String s = in.nextLine();
        for (int i = 0; i < s.length(); i++) a[i+1] = s.charAt(i) - '0';
        for (int i = 1; i <= n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
        }
        dfs(1);
        for (int i = 1; i <= n; i++) {
            if (g[i].isEmpty()) {
                out.println(0);
            } else {
                out.println(f[i]);
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
