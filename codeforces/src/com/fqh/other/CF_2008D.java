package com.fqh.other;

import java.io.*;
import java.util.StringTokenizer;

public class CF_2008D {

//    https://codeforces.com/contest/2008/problem/D

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() - 1;
        }
        char[] s = in.nextLine().toCharArray();
        DSU dsu = new DSU(n, s);

        for (int i = 0; i < n; i++) {
            if (a[i] == i) continue;
            dsu.union(i, a[i]);
        }

        // 0-黑色 1-白色
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int r = dsu.find(i);
            ans[i] = dsu.size[r];
        }
        for (int v : ans) out.print(v + " ");
        out.println();
    }


    static class DSU {
        int n;
        int[] fa;
        int[] size;

        public DSU(int n, char[] c) {
            this.n = n;
            this.fa = new int[n];
            this.size = new int[n]; // 记录黑块数量
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                if (c[i] == '0') size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            if (size[rx] > size[ry]) {
                fa[ry] = rx;
                size[rx] += size[ry];
            } else {
                fa[rx] = ry;
                size[ry] += size[rx];
            }
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
