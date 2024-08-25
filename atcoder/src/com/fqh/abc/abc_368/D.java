package com.fqh.abc.abc_368;

import java.io.*;
import java.util.*;

public class D {

    // https://atcoder.jp/contests/abc368/tasks/abc368_d
    static List<Integer>[] g;
    static Set<Integer> set;


    static int dfs(int x, int fa) {
        int cnt = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            cnt += dfs(y, x);
        }
        // 当前点不能删
        if (cnt > 0 || set.contains(x)) {
            cnt++;
        }
        return cnt;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        g = new List[n + 1];
        set = new HashSet<>();
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        int st = -1;
        for (int i = 0; i < k; i++) {
            int v = in.nextInt();
            set.add(v);
            st = v;
        }
        int res = dfs(st, 0);
        out.println(res);
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
