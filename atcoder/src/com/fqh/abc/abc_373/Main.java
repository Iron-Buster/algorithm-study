package com.fqh.abc.abc_373;

import java.io.*;
import java.util.*;

public class Main {

    static class A {
        public static void solve() throws IOException {
            int ans = 0;
            for (int i = 1; i <= 12; i++) {
                String s = in.nextLine();
                ans += s.length() == i ? 1 : 0;
            }
            out.println(ans);
        }
    }

    static class B {
        public static void solve() throws IOException {
            String s = in.nextLine();
            int[] v = new int[26];
            for (int i = 0; i < 26; i++) {
                v[s.charAt(i) - 'A'] = i;
            }
            int ans = 0;
            for (int i = 0; i < 25; i++) {
                ans += Math.abs(v[i] - v[i + 1]);
            }
            out.println(ans);
        }
    }

    static class C {
        public static void solve() throws IOException {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
            }
            long mx1 = Arrays.stream(a).max().getAsLong();
            long mx2 = Arrays.stream(b).max().getAsLong();
            out.println(mx1 + mx2);
        }
    }


    static class D {
        public static void solve() throws IOException {
            int n = in.nextInt();
            int m = in.nextInt();
            List<int[]>[] g = new List[n + 1];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                int w = in.nextInt();
                g[u].add(new int[]{v, w});
                g[v].add(new int[]{u, -w});
            }
            long[] ans = new long[n];
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (vis[i]) continue;
                dfs(i, g, vis, ans);
            }

            for (long v : ans) out.print(v + " ");
            out.println();
        }

        static void dfs(int u, List<int[]>[] g, boolean[] vis, long[] ans) {
            vis[u] = true;
            for (int[] next : g[u]) {
                int v = next[0];
                int w = next[1];
                if (vis[v]) continue;
                vis[v] = true;
                ans[v] = w + ans[u];
                dfs(v, g, vis, ans);
            }
        }
    }


    static class E {

        public static void solve() throws IOException {

        }
    }


    static boolean MULTI_CASE = false;

    public static void main(String[] args) throws Exception {
        int T = MULTI_CASE ? in.nextInt() : 1;
        while (T-- > 0) {
            A.solve();
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
